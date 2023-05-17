package com.example.creditcardvalidation.models.dtos;

import java.util.Date;

public class CardInfo {

    private Integer id;

    private String owner;

    private Integer number;

    private Integer cvv;

    private Integer month;

    private Integer year;

    //Constructors
    public CardInfo(Integer id,
                String owner,
                Integer number,
                Integer cvv,
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

    public CardInfo() {super();}

    //Getters and Setters

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
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
