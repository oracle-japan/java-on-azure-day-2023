package com.oracle.jp.health;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Startup;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;

@Startup
@ApplicationScoped
public class CustomStartupCheck implements HealthCheck {

    private final AtomicLong readyTime = new AtomicLong(0);


    @Override
    public HealthCheckResponse call() {
      return HealthCheckResponse.named("CustomStartedCheck")  
          .status(isStarted())
          .withData("time", readyTime.get())
          .build();
    }
  
    public void onStartUp(
        @Observes @Initialized(ApplicationScoped.class) Object init) {
      readyTime.set(System.currentTimeMillis()); 
    }
  
    private boolean isStarted() { 
      return Duration.ofMillis(System.currentTimeMillis() - readyTime.get()).getSeconds() >= 8;
    }

}
