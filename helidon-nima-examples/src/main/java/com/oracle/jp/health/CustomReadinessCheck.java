package com.oracle.jp.health;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;

@Readiness
@ApplicationScoped
public class CustomReadinessCheck implements HealthCheck {

    private final AtomicLong readyTime = new AtomicLong(0);

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse
                .named("CustomReadinessCheck")
                .status(isReady())
                .withData("time", readyTime.get())
                .build();
    }

    public void onStartUp(@Observes @Initialized(ApplicationScoped.class) Object init) {
        readyTime.set(System.currentTimeMillis());
    }

    private boolean isReady() {
        return Duration.ofMillis(
                System.currentTimeMillis() - readyTime.get()).getSeconds() >= 5;
    }

}
