package com.rserrano.assessment.application;

import com.rserrano.assessment.domain.model.Price;
import com.rserrano.assessment.domain.repository.PriceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    @Transactional
    public Price findPriceByDateTimeAndProductIdAndBrandId(LocalDateTime desiredDateTime, Long productId, Long brandId) {
        return priceRepository
                .findPriceByDateTimeAndProductIdAndBrandId(
                        desiredDateTime,
                        productId,
                        brandId
                ).orElse(null);
    }
}
