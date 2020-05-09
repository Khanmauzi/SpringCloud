package com.example.microservices.currencyconversionservice.entities;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CurrencyConversionBean {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private BigDecimal quantity;
    private BigDecimal totalCalculatedAmout;
    private int port;
}
