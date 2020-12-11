package com.codecool.stockAppSpring.service;

import com.codecool.stockAppSpring.model.Stock;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;

@Component
public class RemoteURLReader {
    public Stock readFromUrl(String endpoint) throws IOException {
        URL url = new URL(endpoint);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(url, Stock.class);
    }
}
