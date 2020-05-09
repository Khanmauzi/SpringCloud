package com.example.microservices.currencyexchangeservice.controllers;

import com.example.microservices.currencyexchangeservice.models.ExchangeValue;
import com.example.microservices.currencyexchangeservice.services.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")

public class CurrencyExchangeController {
    @Autowired
    private CurrencyExchangeService currencyExchangeService;


    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        return currencyExchangeService.getExchangeValue(from, to, Integer.parseInt(environment.getProperty("local.server.port")));
    }
}
