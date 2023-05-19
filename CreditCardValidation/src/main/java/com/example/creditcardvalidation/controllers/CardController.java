package com.example.creditcardvalidation.controllers;


import com.example.creditcardvalidation.models.dtos.CardInfo;
import com.example.creditcardvalidation.models.dtos.MessageDTO;
import com.example.creditcardvalidation.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/card")
@CrossOrigin(origins="*")
public class CardController {

    //Getting date
    Date date = new Date();
    ZoneId timeZone = ZoneId.systemDefault();
    LocalDate getLocalDate = date.toInstant().atZone(timeZone).toLocalDate();

    //Setting variables to compare
    Integer monthValue = getLocalDate.getMonthValue();
    Integer yearValue = getLocalDate.getYear();

    @Autowired
    CardService cardService;

    @PostMapping("/register")
    public ResponseEntity<MessageDTO> registerCard (@RequestBody CardInfo cardInfo, BindingResult result){

        try {
            if (result.hasErrors()) {
                String errors = result.getAllErrors().toString();

                return new ResponseEntity<>(
                        new MessageDTO("Hay errores: " + errors),
                        HttpStatus.BAD_REQUEST
                );
            }

            //Validation of expiration date
            if ((cardInfo.getMonth() >= monthValue && cardInfo.getYear() >= yearValue && Check(cardInfo.getNumber()))
                    || (cardInfo.getMonth() < monthValue && cardInfo.getYear() > yearValue && Check(cardInfo.getNumber()))){
                //Validation to see if it's an AMEX card, if so, the CVV must be 4 digits long
                if(cardInfo.getNumber().length() == 15 && cardInfo.getCvv().length() == 4){
                    cardService.register(cardInfo);

                    return new ResponseEntity<>(
                            new MessageDTO("Tarjeta registrada"),
                            HttpStatus.CREATED
                    );
                //Validation of CVV for the other cards
                } else if (cardInfo.getNumber().length() > 15 && cardInfo.getCvv().length() == 3) {
                    cardService.register(cardInfo);

                    return new ResponseEntity<>(
                            new MessageDTO("Tarjeta registrada"),
                            HttpStatus.CREATED
                    );
                }
            }

            //If none of the above is true, it means the card is not valid and you will get an error
            return new ResponseEntity<>(
                    new MessageDTO("Tarjeta no registrada"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new MessageDTO("Error interno"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    //Luhn's Algorithm
    // (you can try with: 4624 7482 3324 9780 (VISA) AND 3712 3883 9571 772 (AMEX), these are valid card numbers)
    private static boolean Check(String ccNumber)
    {
        int sum = 0;
        boolean alternate = false;
        for (int i = ccNumber.length() - 1; i >= 0; i--)
        {
            int n = Integer.parseInt(ccNumber.substring(i, i + 1));
            if (alternate)
            {
                n *= 2;
                if (n > 9)
                {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        System.out.println(sum % 10 == 0);
        return (sum % 10 == 0);
    }

}


