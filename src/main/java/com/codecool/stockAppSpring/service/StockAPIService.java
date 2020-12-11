package com.codecool.stockAppSpring.service;

import com.codecool.stockAppSpring.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class StockAPIService {
    private final RemoteURLReader remoteURLReader;
    private static final String API_PATH = "https://run.mocky.io/v3/9e14e086-84c2-4f98-9e36-54928830c980?stock=%s";

    @Autowired
    public StockAPIService(RemoteURLReader remoteURLReader) {
        this.remoteURLReader = remoteURLReader;
    }

    public Stock getStock(String symbol) throws IllegalArgumentException, IOException {
        String url = String.format(API_PATH, symbol);
        try {
            Stock stock = remoteURLReader.readFromUrl(url);
            if(stock.getSymbol().equals(symbol)) {
                return stock;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IOException e) {
            throw new IOException("Sorry, could not load stock data!");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Symbol does not exist!");
        }
    }
}
