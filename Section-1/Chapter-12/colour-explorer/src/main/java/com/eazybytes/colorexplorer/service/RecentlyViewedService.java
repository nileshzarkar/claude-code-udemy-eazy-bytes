package com.eazybytes.colorexplorer.service;

import com.eazybytes.colorexplorer.model.ViewedColor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Tracks the colors a user has clicked, keeping the most recent ones in memory
 * and persisting the full history to a local JSON file.
 */
@ApplicationScoped
public class RecentlyViewedService {

    private static final Logger LOG = Logger.getLogger(RecentlyViewedService.class);

    private final ObjectMapper objectMapper;

    @ConfigProperty(name = "app.viewed-colors.file", defaultValue = "data/viewed-colors.json")
    String viewedColorsFile;

    @ConfigProperty(name = "app.recently-viewed.limit", defaultValue = "5")
    int recentLimit;

    /** Full, ordered history (oldest first). Guarded by {@code this} for writes. */
    private final Deque<ViewedColor> history = new ConcurrentLinkedDeque<>();

    @Inject
    public RecentlyViewedService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    void loadFromDisk() {
        Path path = Path.of(viewedColorsFile);
        if (!Files.exists(path)) {
            LOG.infof("No existing history file at %s, starting fresh", path.toAbsolutePath());
            return;
        }
        try {
            byte[] bytes = Files.readAllBytes(path);
            if (bytes.length == 0) {
                return;
            }
            CollectionType type = objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, ViewedColor.class);
            List<ViewedColor> loaded = objectMapper.readValue(bytes, type);
            history.addAll(loaded);
            LOG.infof("Loaded %d viewed colors from %s", loaded.size(), path.toAbsolutePath());
        } catch (IOException e) {
            LOG.warnf(e, "Could not read history file %s, starting fresh", path);
        }
    }

    /**
     * Records a click on the given color and persists it to disk.
     *
     * @return the up-to-date list of recently viewed colors (newest first).
     */
    public synchronized List<ViewedColor> record(String name, String hex) {
        ViewedColor viewed = new ViewedColor(name, hex, Instant.now());
        history.addLast(viewed);
        persist();
        return recent();
    }

    /**
     * @return the last N viewed colors, newest first.
     */
    public List<ViewedColor> recent() {
        List<ViewedColor> all = new ArrayList<>(history);
        Collections.reverse(all);
        return all.stream().limit(recentLimit).toList();
    }

    private void persist() {
        Path path = Path.of(viewedColorsFile);
        try {
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }
            byte[] json = objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsBytes(new ArrayList<>(history));
            Files.write(path, json);
            LOG.debugf("Persisted %d viewed colors to %s", history.size(), path.toAbsolutePath());
        } catch (IOException e) {
            LOG.errorf(e, "Failed to persist viewed colors to %s", path);
        }
    }
}
