package com.example.customannotation.service;

import com.example.customannotation.annotation.LogExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LogExecutionService {

    @LogExecutionTime
    public void logExecute(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("Function executed!");
    }

    @LogExecutionTime
    public void logExecute2(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("Function executed!");
    }
}
