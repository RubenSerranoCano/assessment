package com.rserrano.assessment.presentation;

import com.rserrano.assessment.application.PriceService;
import com.rserrano.assessment.domain.model.Price;
import com.rserrano.assessment.infrastructure.constants.DateConstants;
import com.rserrano.assessment.presentation.dto.FindPriceResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.rserrano.assessment.infrastructure.constants.ApiConstants.API_V1_PREFIX;

@RestController
@RequestMapping(API_V1_PREFIX)
public class PriceController {

    private final PriceService priceService;

    PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping("/test")
    ResponseEntity<String> test() {
        return ResponseEntity.ok().body("This is a response!");
    }

    @GetMapping("/get-price")
    ResponseEntity<FindPriceResponseDto> getPriceByDateTimeAndProductIdAndBrandId(
            @RequestParam String dateTime,
            @RequestParam Long productId,
            @RequestParam Long brandId
    ) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateConstants.DEFAULT_DATE_TIME_FORMAT);
        LocalDateTime desiredDateTime = LocalDateTime.parse(dateTime, formatter);

        Price price = this.priceService.findPriceByDateTimeAndProductIdAndBrandId(desiredDateTime, productId, brandId);
        if (price == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).build();
        }
        FindPriceResponseDto findPriceResponseDto = new FindPriceResponseDto();
        findPriceResponseDto.setProductId(price.getProduct().getId());
        findPriceResponseDto.setBrandId(price.getBrand().getId());
        findPriceResponseDto.setPriceListName(price.getPriceList().getName());
        findPriceResponseDto.setStartDateTime(price.getStartDateTime());
        findPriceResponseDto.setEndDateTime(price.getEndDateTime());
        findPriceResponseDto.setAmount(price.getAmount());

        return ResponseEntity.ok().body(findPriceResponseDto);
    }

}
