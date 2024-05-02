package com.rserrano.assessment.presentation.dto;

import com.rserrano.assessment.domain.model.PriceList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class FindPriceResponseDto {

    private Long productId;
    private Long brandId;
    private PriceList priceList;
    private LocalDateTime startDateTime, endDateTime;
    private Double amount;

}
