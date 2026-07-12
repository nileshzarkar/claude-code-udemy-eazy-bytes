package com.eazybytes.colorexplorer.model;

import java.time.Instant;

/**
 * A record of a color the user clicked, together with the moment it was viewed.
 */
public record ViewedColor(String name, String hex, Instant viewedAt) {
}
