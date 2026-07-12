# 🎨 Colour Palette Explorer

A modern, responsive web application built with **Quarkus 3**, **Java 21** and **Maven**.
It presents 20 handpicked colours in a beautiful grid and lets you copy, explore and
track them — all served directly from Quarkus (no separate front-end server).

## ✨ Features

- **20 handpicked colours** in a responsive grid, each card showing **HEX, RGB and HSL**
  (RGB/HSL are derived server-side from the hex value so they can never drift).
- **Hover effects** — cards lift, scale and cast a soft shadow.
- **Click to copy** — clicking a card copies its HEX to the clipboard, paints the page
  background and shows a toast: *"Copied #RRGGBB to clipboard!"*.
- **Real-time search** — filter by name, HEX, RGB or HSL as you type.
- **Dark mode toggle** — remembers your choice and respects your OS preference.
- **Animated hero** — floating gradient blobs and a shimmering title.
- **Recently Viewed** — the last five clicked colours, persisted with timestamps to a
  local JSON file (`data/viewed-colors.json`) so history survives restarts.

## 🧱 Tech & structure

```
src/main/java/com/eazybytes/colorexplorer
├── model/PaletteColor.java   # record: name + HEX, derives RGB & HSL
├── model/ViewedColor.java    # record: a click with an ISO timestamp
├── service/ColorService.java # palette + JSON persistence (@ApplicationScoped)
└── web/ColorResource.java    # thin JSON API for the SPA
src/main/resources
├── application.properties
└── META-INF/resources        # static UI served by Quarkus
    ├── index.html
    ├── css/style.css
    └── js/app.js
```

The UI is a static single-page app served from `META-INF/resources`. A thin JSON API
(`/api/colors`, `/api/recently-viewed`, `/api/views`) feeds it data and persists clicks.

## 🚀 Running

**Dev mode** (live reload):

```bash
mvn quarkus:dev
```

Then open <http://localhost:8080>.

**Run the tests:**

```bash
mvn test
```

**Production build & run:**

```bash
mvn package
java -jar target/quarkus-app/quarkus-run.jar
```

## 🔌 API reference

| Method | Path                   | Description                              |
|--------|------------------------|------------------------------------------|
| GET    | `/api/colors`          | The 20 colours with HEX, RGB, HSL        |
| GET    | `/api/recently-viewed` | Last 5 viewed colours (newest first)     |
| POST   | `/api/views`           | Record a click `{ "name", "hex" }`       |

---

Built with Quarkus 3 & Java 21 · 🎨
