package com.example.creditcardvalidation.services;

import com.example.creditcardvalidation.models.dtos.CardInfo;

public interface CardService {

    void register(CardInfo cardInfo) throws Exception;
}
