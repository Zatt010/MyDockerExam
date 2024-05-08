package com.ucb.mydocker.service;

import com.ucb.mydocker.dto.CardDto;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

@RestController
public class CardController implements ICardApi {

    @GetMapping("/cards")
    public String getCards() {
        return "Lista de tarjetas";
    }

    @GetMapping(value = "/cards/{id}", produces = "application/json")
    public ResponseEntity<CardDto> getCardById(@PathVariable String id) {
        CardDto card = new CardDto("1234567890123456", "John Doe", "12/25", "123");
        return ResponseEntity.ok(card);
    }

    @PostMapping(value = "/cards", produces = "application/json")
    public ResponseEntity createCard(@RequestBody CardDto card) {
        return ResponseEntity.ok(card);
    }
}
