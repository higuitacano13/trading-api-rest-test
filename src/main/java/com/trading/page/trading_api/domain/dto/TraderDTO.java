package com.trading.page.trading_api.domain.dto;

import com.trading.page.trading_api.persistence.entities.Trader;


public class TraderDTO {

    public TraderDTO() {
    }

    public TraderDTO(Trader trader) {
        this.name = trader.getName();
        this.email = trader.getEmail();
        this.balance = trader.getBalance();
    }


    private String name;
    private String email;
    private Double balance;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }


}
