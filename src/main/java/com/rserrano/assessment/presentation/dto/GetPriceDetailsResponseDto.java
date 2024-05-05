package com.rserrano.assessment.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class GetPriceDetailsResponseDto {

    private Long productId;
    private Long brandId;
    private String priceListName;
    private LocalDateTime startDateTime, endDateTime;
    private Double amount;

}
