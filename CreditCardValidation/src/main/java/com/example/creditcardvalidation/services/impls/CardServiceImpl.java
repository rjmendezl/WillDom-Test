package com.example.creditcardvalidation.services.impls;

import com.example.creditcardvalidation.models.dtos.CardInfo;
import com.example.creditcardvalidation.models.dtos.MessageDTO;
import com.example.creditcardvalidation.models.entities.Card;
import com.example.creditcardvalidation.repositories.CardRepository;
import com.example.creditcardvalidation.services.CardService;
import com.sun.source.doctree.SystemPropertyTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

        if(cardInfo.getNumber().length() >= 16 && cardInfo.getNumber().length() <= 19 && cardInfo.getCvv().length() >= 3 && cardInfo.getCvv().length() <= 4){
            System.out.println("nice");
            cardRepository.save(card);
        }
        else {
            System.out.println("Hay errores");
        }
    }
}
