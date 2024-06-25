package com.example.customannotation.service;

import com.example.customannotation.annotation.TransactionalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@TransactionalService
public class ComposedService {
    private final static Logger logger = LoggerFactory.getLogger(ComposedService.class);

    public void performTransaction() {
        logger.info("I am the service, working.................!");
    }
}