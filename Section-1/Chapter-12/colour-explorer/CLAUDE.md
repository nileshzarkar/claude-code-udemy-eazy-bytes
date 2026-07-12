# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Overview

Colour Palette Explorer: a Quarkus 3 / Java 21 app that serves a static single-page UI plus a thin JSON API. It shows 20 curated colours and tracks recently-viewed clicks, persisted to a local JSON file.

## Commands

```bash
mvn quarkus:dev        # dev mode with live reload, http://localhost:8080
mvn test               # run all tests
mvn package            # production build -> target/quarkus-app/
java -jar target/quarkus-app/quarkus-run.jar   # run the packaged app
```

Run a single test class or method:

```bash
mvn test -Dtest=ColorResourceTest
mvn test -Dtest=ColorResourceTest#returnsTwentyColors
```

## Architecture

Backend is intentionally thin — the UI is a static SPA (`src/main/resources/META-INF/resources/`: `index.html`, `css/style.css`, `js/app.js`) served directly by Quarkus. All UI logic lives in `app.js`; the Java side only supplies data and records clicks.

Java side (`src/main/java/com/eazybytes/colorexplorer/`):
- `model/PaletteColor` — record storing only `name` + `hex`. RGB and HSL are **derived on demand** from the hex (`rgb()`, `hsl()`), so there's a single source of truth and they can't drift. Don't add stored RGB/HSL fields.
- `model/ViewedColor` — a click: name, hex, and an `Instant` timestamp.
- `service/ColorService` — `@ApplicationScoped`; holds the hardcoded list of 20 `PaletteColor`s (add/edit colours here).
- `service/RecentlyViewedService` — `@ApplicationScoped`; keeps the full click history in an in-memory `ConcurrentLinkedDeque`, loads it from disk on `@PostConstruct`, and rewrites the whole JSON file on every `record()`. `record()` is `synchronized`. The recent-list limit and file path come from config.
- `rest/ColorResource` — JAX-RS resource, all endpoints under `@Path("/api/colors")`.

### REST API (source of truth; README is partly out of date on paths)

| Method | Path                 | Description                              |
|--------|----------------------|------------------------------------------|
| GET    | `/api/colors`        | The 20 colours (name, hex, derived rgb/hsl) |
| GET    | `/api/colors/recent` | Last N viewed colours, newest first      |
| POST   | `/api/colors/view`   | Record a click; body `{ "name", "hex" }`; returns updated recent list. `hex` is required (400 otherwise). |

## Configuration

`src/main/resources/application.properties`:
- `app.viewed-colors.file` — where click history is persisted (default `data/viewed-colors.json`).
- `app.recently-viewed.limit` — size of the "recent" list (default `5`).

The `data/` directory is created on first write. Deleting `data/viewed-colors.json` resets history.
