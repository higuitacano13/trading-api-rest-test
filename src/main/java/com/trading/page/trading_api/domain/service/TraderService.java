package com.trading.page.trading_api.domain.service;

import com.trading.page.trading_api.domain.dto.TraderDTO;
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

    public void updateTrader(TraderDTO newTraderInfo, Trader existingTrader) {
        existingTrader.setName(newTraderInfo.getName());
        existingTrader.setUpdatedAt(LocalDateTime.now());
        traderRepository.save(existingTrader);
    }

    public void addMoney(TraderDTO newTraderInfo, Trader existingTrader) {
        existingTrader.setBalance(existingTrader.getBalance() + newTraderInfo.getBalance());
        traderRepository.save(existingTrader);
    }



}
