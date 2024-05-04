package com.rserrano.assessment.presentation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class FindPriceResponseDto {

    private Long productId;
    private Long brandId;
    private String priceListName;
    private LocalDateTime startDateTime, endDateTime;
    private Double amount;

}
