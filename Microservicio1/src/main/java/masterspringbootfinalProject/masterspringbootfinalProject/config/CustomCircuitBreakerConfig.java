package masterspringbootfinalProject.masterspringbootfinalProject.config;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import java.time.Duration;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;


@Configuration
public class CustomCircuitBreakerConfig {

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> globalCustomConfiguration() {
        return factory -> factory.configureDefault(id -> {
            CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                    .failureRateThreshold(50)
                    .slowCallRateThreshold(50)
                    .slowCallDurationThreshold(Duration.ofSeconds(2))
                    .permittedNumberOfCallsInHalfOpenState(3)
                    .slidingWindowSize(10)
                    .build();

            return new Resilience4JConfigBuilder(id)
                    .circuitBreakerConfig(circuitBreakerConfig)
                    .build();
        });
    }
}


