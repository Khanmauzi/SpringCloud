package com.example.microservices.limitsservice.models;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class LimitConfiguration {
    @Value("${limits-service.maximum}")
    private int maximum;
    @Value("${limits-service.minimum}")
    private int minimum;
}
