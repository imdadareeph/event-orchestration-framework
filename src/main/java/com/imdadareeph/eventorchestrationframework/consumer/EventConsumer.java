package com.imdadareeph.eventorchestrationframework.consumer;

import com.imdadareeph.eventorchestrationframework.dto.EventDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventConsumer {


    @Bean
    public Consumer<EventDTO> sink() {
        return System.out::println;
    }

    @Bean
    public Consumer<String> consume() {
        return System.out::println;
    }
    @Bean
    public Function<String, String> uppercase(){
        return v -> {
            System.out.println("Uppercasing: " + v);
            return v.toUpperCase();
        };
    }

    @Bean
    public Consumer<String> eonsumer(){
        return (value) -> log.info("Consumer Received : " + value);
    }

}
