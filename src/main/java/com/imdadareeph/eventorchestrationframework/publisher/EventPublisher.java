package com.imdadareeph.eventorchestrationframework.publisher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;
import java.util.function.Supplier;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventPublisher {

    Random random = new Random();

    @Bean
    public Supplier<Flux<Integer>> publisher(){
        return () -> Flux.interval(Duration.ofSeconds(60)).map(value -> random.nextInt(1000 - 1) + 1).log();
    }
}
