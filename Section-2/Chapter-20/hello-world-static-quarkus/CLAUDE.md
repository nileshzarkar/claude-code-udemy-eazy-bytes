# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Overview

A single-module Quarkus (Java 21) app that serves one endpoint, `GET /hello`, which returns a
self-contained, styled HTML page (`text/html`) rather than JSON. Part of a Udemy course; the
parent `../README.md` is a course note (the original build prompt), not project documentation.

## Commands

Use the Maven wrapper (`./mvnw` on Git Bash/Linux, `mvnw.cmd` on Windows CMD/PowerShell).

- **Dev mode (live reload):** `./mvnw quarkus:dev` — serves http://localhost:8080/hello and the Dev UI at http://localhost:8080/q/dev/. Edit and save Java/resources and the running app hot-reloads; no restart.
- **Run all tests:** `./mvnw test`
- **Run a single test:** `./mvnw test -Dtest=HelloResourceTest` (or `-Dtest=HelloResourceTest#helloEndpointReturnsHtml` for one method)
- **Package (fast-jar):** `./mvnw package` → run with `java -jar target/quarkus-app/quarkus-run.jar`
- **Native build:** `./mvnw package -Dnative` (requires GraalVM/Mandrel)

Port is pinned to 8080 in `src/main/resources/application.properties`. If startup fails with a
port-in-use error, a stale JVM may hold 8080 — find and kill it (`Get-NetTCPConnection -LocalPort 8080`).

## Architecture

- **REST stack:** `quarkus-rest` — the current artifact for what was formerly *RESTEasy Reactive*. Not the legacy `quarkus-resteasy`. Uses Jakarta (`jakarta.ws.rs.*`) annotations, not `javax`.
- **Version alignment:** all Quarkus versions come from the `quarkus-bom` imported in `pom.xml` (`quarkus.platform.version`, currently 3.15.1). Add extensions without version tags — the BOM manages them.
- **Endpoint discovery:** `HelloResource` is found automatically via Quarkus/CDI classpath scanning. There is no `Application` class or manual route registration.
- **The HTML lives in Java:** `HelloResource.hello()` returns a Java **text block** (`""" … """`) containing a complete HTML document with all CSS inlined (`@Produces(MediaType.TEXT_HTML)`). To change the page's look, edit that string — there are no separate `.html`/`.css` files. The only external dependency is the Google Fonts `<link>`, which degrades to a system-font fallback offline.
- **Tests:** `@QuarkusTest` boots the real app on a random test port (8081) and REST Assured hits the live endpoint — these are integration-style, not mocked unit tests.
