package com.rserrano.assessment.domain.repository;

import com.rserrano.assessment.domain.model.Price;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PriceRepository {

    Price findPriceByDateTimeAndProductIdAndBrandId(LocalDateTime desiredDateTime, Long productId, Long brandId);

}
