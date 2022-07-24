package com.imdadareeph.eventorchestrationframework.processor;

import com.imdadareeph.eventorchestrationframework.dto.EventDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.Optional;
import java.util.function.Function;

@Slf4j
@Configuration
public class EventProcessor {

    private static final Logger log = LoggerFactory.getLogger(EventProcessor.class);

    @Bean
    public Function<Flux<EventDTO>, Flux<EventDTO>> eventFunction(){

        return eventDTOFlux -> eventDTOFlux
                .doOnNext(eventDTO -> log.info("Received event details in eventFunctiom : {}",eventDTO))
                .map(updatedEvent -> {
                    Optional.ofNullable(updatedEvent.getEventId()).ifPresent(e-> updatedEvent.setEventId(new StringBuilder("EVENT_").append(e).toString()));
                    return updatedEvent;
                }).doOnNext(updatedEvent -> log.info("Processed event details in eventFunctiom : {}",updatedEvent));
    }

    @Bean
    public Function<Flux<Integer>, Flux<String>> processor(){
        return longFlux -> longFlux
                .map(i -> processEvent(i))
                .log();
    }


    private String processEvent(Integer value) {
        if (value % 15 == 0) {
            return "strippekiddie15";
        } else if (value % 5 == 0) {
            return "process5";
        } else if (value % 3 == 0) {
            return "process3";
        } else {
            return String.valueOf(value);
        }
    }
}
