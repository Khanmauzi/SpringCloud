package com.example.microservices.currencyconversionservice.controllers;

import com.example.microservices.currencyconversionservice.entities.CurrencyConversionBean;
import com.example.microservices.currencyconversionservice.services.CurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("")
public class CurrencyConverter {

    @Autowired
    CurrencyConverterService currencyConverterService;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        return currencyConverterService.getValue(from,to,quantity);
    }
}
