/* ===========================================================================
   Color Palette Explorer — front-end logic
   =========================================================================== */
(() => {
    "use strict";

    const API = "/api/colors";
    const state = { colors: [], filter: "" };

    const els = {
        grid: document.getElementById("grid"),
        search: document.getElementById("search"),
        empty: document.getElementById("empty-state"),
        toast: document.getElementById("toast"),
        themeToggle: document.getElementById("theme-toggle"),
        themeIcon: document.querySelector(".theme-icon"),
        recentSection: document.getElementById("recent-section"),
        recentList: document.getElementById("recent-list"),
    };

    /* ---------------- Color math (mirrors the Java model) ---------------- */
    function hexToRgb(hex) {
        const h = hex.replace("#", "");
        return {
            r: parseInt(h.substring(0, 2), 16),
            g: parseInt(h.substring(2, 4), 16),
            b: parseInt(h.substring(4, 6), 16),
        };
    }

    function rgbString(hex) {
        const { r, g, b } = hexToRgb(hex);
        return `rgb(${r}, ${g}, ${b})`;
    }

    function hslString(hex) {
        let { r, g, b } = hexToRgb(hex);
        r /= 255; g /= 255; b /= 255;
        const max = Math.max(r, g, b), min = Math.min(r, g, b);
        const delta = max - min;
        let h = 0;
        if (delta !== 0) {
            if (max === r) h = ((g - b) / delta) % 6;
            else if (max === g) h = (b - r) / delta + 2;
            else h = (r - g) / delta + 4;
            h = Math.round(h * 60);
            if (h < 0) h += 360;
        }
        const l = (max + min) / 2;
        const s = delta === 0 ? 0 : delta / (1 - Math.abs(2 * l - 1));
        return `hsl(${h}, ${Math.round(s * 100)}%, ${Math.round(l * 100)}%)`;
    }

    /* ---------------- Rendering ---------------- */
    function cardTemplate(color) {
        const rgb = rgbString(color.hex);
        const hsl = hslString(color.hex);
        return `
        <article class="card" tabindex="0" role="button"
                 data-hex="${color.hex}" data-name="${color.name}"
                 aria-label="Copy ${color.name}, ${color.hex}">
            <div class="swatch" style="background:${color.hex}">
                <span class="copy-badge">Click to copy</span>
            </div>
            <div class="card-body">
                <h3 class="card-name">${color.name}</h3>
                <div class="value-row"><span class="label">HEX</span><span class="value">${color.hex.toUpperCase()}</span></div>
                <div class="value-row"><span class="label">RGB</span><span class="value">${rgb}</span></div>
                <div class="value-row"><span class="label">HSL</span><span class="value">${hsl}</span></div>
            </div>
        </article>`;
    }

    function renderGrid() {
        const term = state.filter.trim().toLowerCase();
        const matches = state.colors.filter(c =>
            c.name.toLowerCase().includes(term) || c.hex.toLowerCase().includes(term));

        els.grid.innerHTML = matches.map(cardTemplate).join("");
        els.empty.classList.toggle("hidden", matches.length !== 0);
    }

    function timeAgo(iso) {
        const diff = Math.floor((Date.now() - new Date(iso).getTime()) / 1000);
        if (diff < 5) return "just now";
        if (diff < 60) return `${diff}s ago`;
        if (diff < 3600) return `${Math.floor(diff / 60)}m ago`;
        if (diff < 86400) return `${Math.floor(diff / 3600)}h ago`;
        return `${Math.floor(diff / 86400)}d ago`;
    }

    function renderRecent(items) {
        if (!items || items.length === 0) {
            els.recentSection.classList.add("hidden");
            return;
        }
        els.recentSection.classList.remove("hidden");
        els.recentList.innerHTML = items.map(v => `
            <div class="recent-chip">
                <span class="recent-swatch" style="background:${v.hex}"></span>
                <span class="recent-meta">
                    <span class="name">${v.name}</span>
                    <span class="time">${v.hex.toUpperCase()} · ${timeAgo(v.viewedAt)}</span>
                </span>
            </div>`).join("");
    }

    /* ---------------- Interactions ---------------- */
    let toastTimer;
    function showToast(message, hex) {
        els.toast.innerHTML = `<span class="dot" style="background:${hex || "transparent"}"></span>${message}`;
        els.toast.classList.add("show");
        clearTimeout(toastTimer);
        toastTimer = setTimeout(() => els.toast.classList.remove("show"), 2200);
    }

    async function copyHex(hex) {
        try {
            await navigator.clipboard.writeText(hex.toUpperCase());
        } catch {
            // Fallback for browsers/contexts without the async clipboard API
            const ta = document.createElement("textarea");
            ta.value = hex.toUpperCase();
            ta.style.position = "fixed";
            ta.style.opacity = "0";
            document.body.appendChild(ta);
            ta.select();
            try { document.execCommand("copy"); } catch { /* ignore */ }
            document.body.removeChild(ta);
        }
    }

    async function onColorClick(hex, name) {
        document.body.style.background = hex;
        await copyHex(hex);
        showToast("Copied HEX to clipboard!", hex);
        try {
            const res = await fetch(`${API}/view`, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ name, hex }),
            });
            if (res.ok) {
                renderRecent(await res.json());
            }
        } catch (e) {
            console.warn("Could not record view", e);
        }
    }

    function handleGridActivate(target) {
        const card = target.closest(".card");
        if (!card) return;
        onColorClick(card.dataset.hex, card.dataset.name);
    }

    /* ---------------- Theme ---------------- */
    const THEME_KEY = "cpe-theme";
    function applyTheme(theme) {
        document.documentElement.setAttribute("data-theme", theme);
        els.themeIcon.textContent = theme === "dark" ? "☀️" : "🌙";
        localStorage.setItem(THEME_KEY, theme);
    }

    function initTheme() {
        const saved = localStorage.getItem(THEME_KEY);
        const prefersDark = window.matchMedia("(prefers-color-scheme: dark)").matches;
        applyTheme(saved || (prefersDark ? "dark" : "light"));
    }

    /* ---------------- Boot ---------------- */
    async function init() {
        initTheme();

        els.themeToggle.addEventListener("click", () => {
            const current = document.documentElement.getAttribute("data-theme");
            applyTheme(current === "dark" ? "light" : "dark");
        });

        els.search.addEventListener("input", (e) => {
            state.filter = e.target.value;
            renderGrid();
        });

        els.grid.addEventListener("click", (e) => handleGridActivate(e.target));
        els.grid.addEventListener("keydown", (e) => {
            if (e.key === "Enter" || e.key === " ") {
                e.preventDefault();
                handleGridActivate(e.target);
            }
        });

        try {
            const [colorsRes, recentRes] = await Promise.all([
                fetch(API),
                fetch(`${API}/recent`),
            ]);
            state.colors = await colorsRes.json();
            renderGrid();
            renderRecent(await recentRes.json());
        } catch (e) {
            console.error("Failed to load palette", e);
            els.grid.innerHTML = `<p class="empty-state">Could not load colors. Is the server running?</p>`;
        }
    }

    document.addEventListener("DOMContentLoaded", init);
})();
