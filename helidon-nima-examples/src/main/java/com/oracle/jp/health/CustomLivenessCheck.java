package com.oracle.jp.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import jakarta.enterprise.context.ApplicationScoped;


@Liveness
@ApplicationScoped
public class CustomLivenessCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse
            .named("CustomLivenessCheck")
            .up()
            .withData("time", System.currentTimeMillis())
            .build();
    }

}
