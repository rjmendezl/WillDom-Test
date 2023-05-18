package com.example.creditcardvalidation.models.entities;

import ch.qos.logback.core.net.SyslogOutputStream;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity(name = "credit_cards")
public class Card {

    @Id
    @SequenceGenerator(name = "credit_cards_id_card_seq", sequenceName = "credit_cards_id_card_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credit_cards_id_card_seq")
    @Column(name = "id_card")
    private Integer id;

    @Column(name = "owner")
    private String owner;

    @Column(name = "number")
    private String number;

    @Column(name = "cvv")
    private String cvv;

    @Column(name = "month")
    private Integer month;

    @Column(name = "year")
    private Integer year;

    //Constructors
    public Card(Integer id,
                String owner,
                String number,
                String cvv,
                Integer month,
                Integer year)
    {
        super();
        this.id = id;
        this.owner = owner;
        this.number = number;
        this.cvv = cvv;
        this.month = month;
        this.year = year;
    }

    public Card() {super();}

    //Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
