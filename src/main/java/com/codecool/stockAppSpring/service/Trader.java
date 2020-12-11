package com.codecool.stockAppSpring.service;

import com.codecool.stockAppSpring.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Trader {
    private final StockAPIService stockAPIService;

    @Autowired
    public Trader(StockAPIService stockAPIService) {
        this.stockAPIService = stockAPIService;
    }

    public String buy(String symbol, double bid) throws IllegalArgumentException, IOException {
        Stock stock = stockAPIService.getStock(symbol);
        double price = stock.getPrice();
        String result;

        if(price <= bid) {
            result = "Purchased " + symbol + " stock at $" + bid + ", since its higher that the current price ($" + price + ")";
        } else {
            result = "Bid for " + symbol + " was $" + bid + " but the stock price is $" + price + ", no purchase was made.";
        }
        return result;
    }
}
