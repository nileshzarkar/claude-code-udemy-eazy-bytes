package com.eazybytes.colorexplorer.service;

import com.eazybytes.colorexplorer.model.PaletteColor;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

/**
 * Supplies the curated set of 20 handpicked palette colors.
 */
@ApplicationScoped
public class ColorService {

    private static final List<PaletteColor> COLORS = List.of(
            new PaletteColor("Sunset Coral", "#FF6B6B"),
            new PaletteColor("Tangerine", "#FF9F43"),
            new PaletteColor("Golden Amber", "#FFC048"),
            new PaletteColor("Lemon Zest", "#FEDB4E"),
            new PaletteColor("Lime Punch", "#A3CB38"),
            new PaletteColor("Fresh Mint", "#26DE81"),
            new PaletteColor("Emerald Sea", "#0BE881"),
            new PaletteColor("Teal Wave", "#00D2D3"),
            new PaletteColor("Sky Cyan", "#48DBFB"),
            new PaletteColor("Ocean Blue", "#0FBCF9"),
            new PaletteColor("Royal Indigo", "#4834D4"),
            new PaletteColor("Electric Violet", "#7158E2"),
            new PaletteColor("Lavender Dream", "#A55EEA"),
            new PaletteColor("Orchid Pink", "#D980FA"),
            new PaletteColor("Bubblegum", "#FF6BCB"),
            new PaletteColor("Rose Blush", "#FD79A8"),
            new PaletteColor("Crimson Red", "#EE5253"),
            new PaletteColor("Terracotta", "#E17055"),
            new PaletteColor("Slate Gray", "#576574"),
            new PaletteColor("Midnight Navy", "#2C3A47")
    );

    /**
     * @return an immutable list of the curated palette colors.
     */
    public List<PaletteColor> getColors() {
        return COLORS;
    }
}
