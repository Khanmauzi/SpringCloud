package com.example.microservices.currencyexchangeservice.services;

import com.example.microservices.currencyexchangeservice.entities.ExchangeData;
import com.example.microservices.currencyexchangeservice.models.ExchangeValue;
import com.example.microservices.currencyexchangeservice.repositories.ExchangeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
@Slf4j
public class CurrencyExchangeService {

    @Autowired
    ExchangeRepository exchangeRepository;

    public ExchangeValue getExchangeValue(String from, String to,int port){
        ExchangeValue exchangeValue = new ExchangeValue();
        log.info(from+to);
        try {

             ExchangeData exchangeData = exchangeRepository.findByFromAndTo(from.toUpperCase(), to.toUpperCase());
             exchangeValue.setId(exchangeData.getId());
             exchangeValue.setTo(exchangeData.getTo());
             exchangeValue.setFrom(exchangeData.getFrom());
             exchangeValue.setConversionMultiple(exchangeData.getConversionMultiple());
            log.info(exchangeValue.toString());
        } catch (Exception e) {
            log.info("Exception : "+e);
        }

        exchangeValue.setPort(port);
        return exchangeValue;
    }

}
