package com.example.creditcardvalidation.services.impls;

import com.example.creditcardvalidation.models.dtos.CardInfo;
import com.example.creditcardvalidation.models.entities.Card;
import com.example.creditcardvalidation.repositories.CardRepository;
import com.example.creditcardvalidation.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public void register(CardInfo cardInfo) throws Exception {

        Card card = new Card();

        card.setOwner(cardInfo.getOwner());
        card.setNumber(cardInfo.getNumber());
        card.setCvv(cardInfo.getCvv());
        card.setMonth(cardInfo.getMonth());
        card.setYear(cardInfo.getYear());

        cardRepository.save(card);

    }
}
