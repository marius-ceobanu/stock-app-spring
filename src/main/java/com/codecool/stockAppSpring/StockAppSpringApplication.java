package com.codecool.stockAppSpring;

import com.codecool.stockAppSpring.service.RemoteURLReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class StockAppSpringApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(StockAppSpringApplication.class);
    private final RemoteURLReader remoteURLReader;

    @Autowired
    public StockAppSpringApplication(RemoteURLReader remoteURLReader) {
        this.remoteURLReader = remoteURLReader;
    }


    public static void main(String[] args) {
        SpringApplication.run(StockAppSpringApplication.class, args);
    }

    @PostConstruct
    public void afterInit() {
        LOGGER.info(remoteURLReader.toString());
    }
}
