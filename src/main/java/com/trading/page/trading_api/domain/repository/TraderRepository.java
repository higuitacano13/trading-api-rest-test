package com.trading.page.trading_api.domain.repository;

import com.trading.page.trading_api.persistence.entities.Trader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TraderRepository  extends JpaRepository<Trader, Integer> {
    Optional<Trader> findByEmail(String email);
}
