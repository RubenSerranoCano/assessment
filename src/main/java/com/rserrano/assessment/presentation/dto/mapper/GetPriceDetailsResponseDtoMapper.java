package com.rserrano.assessment.presentation.dto.mapper;

import com.rserrano.assessment.domain.model.Price;
import com.rserrano.assessment.presentation.dto.GetPriceDetailsResponseDto;
import org.springframework.stereotype.Component;

@Component
public class GetPriceDetailsResponseDtoMapper implements BuildDto<GetPriceDetailsResponseDto, Price> {

    @Override
    public GetPriceDetailsResponseDto buildDto(Price domainObject) {
        GetPriceDetailsResponseDto dto = new GetPriceDetailsResponseDto();
        dto.setProductId(domainObject.getProduct().getId());
        dto.setBrandId(domainObject.getBrand().getId());
        dto.setPriceListName(domainObject.getPriceList().getName());
        dto.setStartDateTime(domainObject.getStartDateTime());
        dto.setEndDateTime(domainObject.getEndDateTime());
        dto.setAmount(domainObject.getAmount());
        return dto;
    }
}
