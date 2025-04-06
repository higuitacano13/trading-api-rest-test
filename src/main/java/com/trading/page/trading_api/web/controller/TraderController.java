package com.trading.page.trading_api.web.controller;

import com.trading.page.trading_api.domain.dto.TraderDTO;
import com.trading.page.trading_api.domain.service.TraderService;
import com.trading.page.trading_api.persistence.entities.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/trading/traders")
public class TraderController {
    @Autowired
    private TraderService traderService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerTrader(@RequestBody Trader trader) {

        if (trader == null || trader.getEmail() == null || trader.getEmail().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El trader no fue encontrado con el email proporcionado");
        }

        Trader existingTrader = traderService.getTraderByEmail(trader.getEmail());
        if (existingTrader.getEmail() != null && existingTrader.getEmail().equals(trader.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El email ya está registrado");
        }

        trader.setId(null);
        trader.setCreatedAt(LocalDateTime.now());
        traderService.registerTrader(trader);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TraderDTO getTraderByEmail(@RequestParam("email") String email) {
        Trader trader = traderService.getTraderByEmail(email);

        if (trader.getEmail() == null || trader.getEmail().isBlank()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El trader no fue encontrado con el email proporcionado");
        }
        return new TraderDTO(trader);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TraderDTO> getAllTraders() {
        try {
            if (traderService == null) {
                throw new IllegalStateException("traderService no está inicializado");
            }

            return traderService.getAllTraders()
                    .stream()
                    .sorted(Comparator.comparing(Trader::getId))
                    .map(TraderDTO::new)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al obtener los traders", e);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateTrader(@RequestBody TraderDTO trader) {

        Trader existingTrader = traderService.getTraderByEmail(trader.getEmail());
        if (existingTrader.getEmail() == null || existingTrader.getEmail().isBlank()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El trader no fue encontrado con el email proporcionado");
        }

        traderService.updateTrader(trader, existingTrader);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void addMoney(@RequestBody TraderDTO trader) {
        Trader existingTrader = traderService.getTraderByEmail(trader.getEmail());

        if (existingTrader.getEmail() == null || existingTrader.getEmail().isBlank()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El trader no fue encontrado con el email proporcionado");
        }

        traderService.addMoney(trader, existingTrader);
    }
}
