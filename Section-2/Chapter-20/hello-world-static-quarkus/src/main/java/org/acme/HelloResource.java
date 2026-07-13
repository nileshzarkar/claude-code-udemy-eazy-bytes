package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * REST endpoint that serves a fancy "Hello World" HTML page.
 *
 * <p>Reachable at: <a href="http://localhost:8080/hello">http://localhost:8080/hello</a></p>
 */
@Path("/hello")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String hello() {
        // A Java text block (""" ... """) holding a self-contained HTML document.
        // Everything (CSS + fonts fallback) is inlined so there are no extra files to serve.
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Hello World · Quarkus</title>
                    <link rel="preconnect" href="https://fonts.googleapis.com">
                    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
                    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@600;800&display=swap"
                          rel="stylesheet">
                    <style>
                        * { margin: 0; padding: 0; box-sizing: border-box; }

                        html, body {
                            height: 100%;
                        }

                        body {
                            /* Animated gradient background */
                            background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
                            background-size: 400% 400%;
                            animation: gradientShift 15s ease infinite;
                            font-family: 'Poppins', -apple-system, BlinkMacSystemFont,
                                         'Segoe UI', Roboto, Helvetica, Arial, sans-serif;
                            display: flex;
                            align-items: center;
                            justify-content: center;
                            text-align: center;
                            color: #ffffff;
                        }

                        @keyframes gradientShift {
                            0%   { background-position: 0% 50%; }
                            50%  { background-position: 100% 50%; }
                            100% { background-position: 0% 50%; }
                        }

                        .card {
                            padding: 3rem 4rem;
                            border-radius: 24px;
                            background: rgba(255, 255, 255, 0.12);
                            backdrop-filter: blur(12px);
                            -webkit-backdrop-filter: blur(12px);
                            box-shadow: 0 20px 50px rgba(0, 0, 0, 0.35);
                            border: 1px solid rgba(255, 255, 255, 0.25);
                            animation: floatIn 1s ease-out;
                        }

                        @keyframes floatIn {
                            from { opacity: 0; transform: translateY(30px); }
                            to   { opacity: 1; transform: translateY(0); }
                        }

                        h1 {
                            font-weight: 800;
                            font-size: clamp(2.5rem, 8vw, 5.5rem);
                            letter-spacing: 2px;
                            text-shadow: 0 4px 20px rgba(0, 0, 0, 0.4);
                            animation: pulse 3s ease-in-out infinite;
                        }

                        @keyframes pulse {
                            0%, 100% { transform: scale(1); }
                            50%      { transform: scale(1.04); }
                        }

                        p {
                            margin-top: 1rem;
                            font-weight: 600;
                            font-size: clamp(1rem, 3vw, 1.4rem);
                            opacity: 0.9;
                        }

                        .badge {
                            display: inline-block;
                            margin-top: 1.5rem;
                            padding: 0.4rem 1rem;
                            border-radius: 999px;
                            background: rgba(0, 0, 0, 0.25);
                            font-size: 0.85rem;
                            letter-spacing: 1px;
                        }
                    </style>
                </head>
                <body>
                    <div class="card">
                        <h1>Hello&nbsp;World&nbsp;👋</h1>
                        <p>Served fresh from a Quarkus REST endpoint.</p>
                        <span class="badge">GET /hello · text/html</span>
                    </div>
                </body>
                </html>
                """;
    }
}
