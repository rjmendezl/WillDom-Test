package com.example.creditcardvalidation.controllers;


import com.example.creditcardvalidation.models.dtos.CardInfo;
import com.example.creditcardvalidation.models.dtos.MessageDTO;
import com.example.creditcardvalidation.services.CardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
@CrossOrigin(origins="*")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/register")
    public ResponseEntity<MessageDTO> registerCard (@Valid CardInfo cardInfo, BindingResult result){
        try {
            if(result.hasErrors()) {
                String errors = result.getAllErrors().toString();

                return new ResponseEntity<>(
                        new MessageDTO("Hay errores: " + errors),
                        HttpStatus.BAD_REQUEST
                );
            }

            cardService.register(cardInfo);

            return new ResponseEntity<>(
                    new MessageDTO("Tarjeta registrada"),
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new MessageDTO("Error interno"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
