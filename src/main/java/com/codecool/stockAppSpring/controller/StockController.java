package com.codecool.stockAppSpring.controller;

import com.codecool.stockAppSpring.service.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/buy")
public class StockController {
    private final Trader trader;

    @Autowired
    public StockController(Trader trader) {
        this.trader = trader;
    }

    @GetMapping("/{symbol}/{bid}")
    public String purchase(@PathVariable String symbol, @PathVariable String bid) {
        try {
            return trader.buy(symbol, Double.parseDouble(bid));
        } catch (IllegalArgumentException | IOException e) {
            return "There was an error while attempting to buy the stock: " + e.getMessage();
        }
    }
}
