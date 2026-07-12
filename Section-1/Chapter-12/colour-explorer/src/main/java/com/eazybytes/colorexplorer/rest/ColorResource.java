package com.eazybytes.colorexplorer.rest;

import com.eazybytes.colorexplorer.model.PaletteColor;
import com.eazybytes.colorexplorer.model.ViewedColor;
import com.eazybytes.colorexplorer.service.ColorService;
import com.eazybytes.colorexplorer.service.RecentlyViewedService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

/**
 * Supporting endpoints for the Color Palette Explorer single-page app.
 *
 * <p>The application itself is a static web app served from {@code META-INF/resources};
 * these endpoints only feed it the palette data and persist "recently viewed" clicks.</p>
 */
@Path("/api/colors")
@Produces(MediaType.APPLICATION_JSON)
public class ColorResource {

    @Inject
    ColorService colorService;

    @Inject
    RecentlyViewedService recentlyViewedService;

    @GET
    public List<PaletteColor> all() {
        return colorService.getColors();
    }

    @GET
    @Path("/recent")
    public List<ViewedColor> recent() {
        return recentlyViewedService.recent();
    }

    @POST
    @Path("/view")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response view(ViewRequest request) {
        if (request == null || request.hex() == null || request.hex().isBlank()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\":\"hex is required\"}").build();
        }
        List<ViewedColor> recent = recentlyViewedService.record(
                request.name() == null ? "Unknown" : request.name(), request.hex());
        return Response.ok(recent).build();
    }

    /** Payload sent by the browser when a color card is clicked. */
    public record ViewRequest(String name, String hex) {
    }
}
