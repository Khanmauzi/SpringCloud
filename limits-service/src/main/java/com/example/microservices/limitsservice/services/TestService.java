package com.example.microservices.limitsservice.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
public class TestService {

    @Scheduled(cron = "${test.cron.scheduler}")
    public void testScheduler() {
        log.info("Printing date {}", new Date());
    }

}
