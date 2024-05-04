package com.rserrano.assessment.domain.repository;

import com.rserrano.assessment.domain.model.Price;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceRepository {

    Optional<Price> findPriceByDateTimeAndProductIdAndBrandId(LocalDateTime desiredDateTime, Long productId, Long brandId);

}
