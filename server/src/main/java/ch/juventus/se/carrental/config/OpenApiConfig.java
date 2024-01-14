package ch.juventus.se.carrental.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Fleetwise API Docomentation",
                description = "CarRental system project for software engineering @ Juventus Schule Zürich",
                version = "1.0"

        ),
        servers = {
                @Server(
                        description = "Local environment",
                        url = "http://localhost:8080"
                )
        }
)
public class OpenApiConfig {
}
