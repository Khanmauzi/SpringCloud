package com.example.microservices.currencyexchangeservice.repositories;

import com.example.microservices.currencyexchangeservice.entities.ExchangeData;
import com.example.microservices.currencyexchangeservice.models.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ExchangeRepository extends JpaRepository<ExchangeData, Long> {
    ExchangeData findByFromAndTo(String from, String to);
}
