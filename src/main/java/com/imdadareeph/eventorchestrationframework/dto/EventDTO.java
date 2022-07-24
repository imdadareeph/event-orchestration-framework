package com.imdadareeph.eventorchestrationframework.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder(toBuilder=true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    public String eventId;
    public String eventCategory;
    public Date timestamp;
    public String producer;
    public String action;
    public String resourceType;
    public Data data;


    @lombok.Data
    public static class Data{
        public String correlationId;
        public String channalName;
        public String requestId;
    }
}


