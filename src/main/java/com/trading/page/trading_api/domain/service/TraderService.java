package com.trading.page.trading_api.domain.service;

import com.trading.page.trading_api.domain.repository.TraderRepository;
import com.trading.page.trading_api.persistence.entities.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TraderService {
    @Autowired
    private TraderRepository traderRepository;

    public void registerTrader(Trader trader) {
        traderRepository.save(trader);
    }

    public Trader getTraderById(Integer id) {
        return traderRepository.findById(id).get();
    }

    public Trader getTraderByEmail(String email) {
        return traderRepository.findByEmail(email).orElse(new Trader());
    }

    public List<Trader> getAllTraders(){
        return traderRepository.findAll();
    }

    public void updateTrader(String email, String name) {
        Trader exitingTrader = traderRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Trader not found"));

        exitingTrader.setName(name);
        exitingTrader.setUpdatedAt(LocalDateTime.now());
        traderRepository.save(exitingTrader);
    }

    public void addMoney(String email, Double amount) {
        Trader exitingTrader = traderRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Trader not found"));
        exitingTrader.setBalance(exitingTrader.getBalance() + amount);
        traderRepository.save(exitingTrader);
    }



}
