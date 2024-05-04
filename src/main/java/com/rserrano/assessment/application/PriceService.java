package com.rserrano.assessment.application;

import com.rserrano.assessment.domain.model.Price;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public interface PriceService {

    Price findPriceByDateTimeAndProductIdAndBrandId(LocalDateTime desiredDateTime, Long productId, Long brandId);

}
