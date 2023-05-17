package com.example.creditcardvalidation.repositories;

import com.example.creditcardvalidation.models.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {
}
