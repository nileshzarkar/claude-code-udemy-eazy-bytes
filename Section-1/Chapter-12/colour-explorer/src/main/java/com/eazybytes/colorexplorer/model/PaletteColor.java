package com.eazybytes.colorexplorer.model;

/**
 * A single handpicked palette color.
 *
 * <p>Only the {@code name} and {@code hex} are stored; the derived RGB and HSL
 * representations are computed on demand so there is a single source of truth.</p>
 */
public record PaletteColor(String name, String hex) {

    /**
     * @return the color as an {@code "rgb(r, g, b)"} CSS string.
     */
    public String rgb() {
        int[] c = toRgb();
        return "rgb(%d, %d, %d)".formatted(c[0], c[1], c[2]);
    }

    /**
     * @return the color as an {@code "hsl(h, s%, l%)"} CSS string.
     */
    public String hsl() {
        int[] c = toRgb();
        double r = c[0] / 255.0;
        double g = c[1] / 255.0;
        double b = c[2] / 255.0;

        double max = Math.max(r, Math.max(g, b));
        double min = Math.min(r, Math.min(g, b));
        double delta = max - min;

        double h = 0;
        if (delta != 0) {
            if (max == r) {
                h = ((g - b) / delta) % 6;
            } else if (max == g) {
                h = (b - r) / delta + 2;
            } else {
                h = (r - g) / delta + 4;
            }
            h *= 60;
            if (h < 0) {
                h += 360;
            }
        }

        double l = (max + min) / 2;
        double s = delta == 0 ? 0 : delta / (1 - Math.abs(2 * l - 1));

        return "hsl(%d, %d%%, %d%%)".formatted(
                Math.round(h), Math.round(s * 100), Math.round(l * 100));
    }

    private int[] toRgb() {
        String clean = hex.startsWith("#") ? hex.substring(1) : hex;
        int r = Integer.parseInt(clean.substring(0, 2), 16);
        int g = Integer.parseInt(clean.substring(2, 4), 16);
        int b = Integer.parseInt(clean.substring(4, 6), 16);
        return new int[]{r, g, b};
    }
}
