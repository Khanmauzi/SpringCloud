package com.example.microservices.currencyconversionservice.services;

import com.example.microservices.currencyconversionservice.entities.CurrencyConversionBean;
import com.example.microservices.currencyconversionservice.restcalls.CurrencyExchangeServiceProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class CurrencyConverterService {

    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    public CurrencyConversionBean getValue(String from, String to, BigDecimal quantity) {

        /**
         * This is general method to to make restp api call;
         * We are using RestSerivceCall
         * */

      /**  Map<String,String> uriVariable = new HashMap<>();
        uriVariable.put("from",from);
        uriVariable.put("to",to);
        ResponseEntity<CurrencyConversionBean>responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversionBean.class,uriVariable);

        CurrencyConversionBean currencyConversionBean = responseEntity.getBody();
       */

      /**
       * here we are using FeignClient to make call to the currency exchange service
       * */
        CurrencyConversionBean currencyConversionBean = currencyExchangeServiceProxy.retrieveExchangeValue(from,to);
        currencyConversionBean.setTotalCalculatedAmout(quantity.multiply(currencyConversionBean.getConversionMultiple()));
        log.info("Conversion service response {}", currencyConversionBean);
        return currencyConversionBean;
    }

}
