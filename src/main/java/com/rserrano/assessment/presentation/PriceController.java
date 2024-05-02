package com.rserrano.assessment.presentation;

import com.rserrano.assessment.application.PriceService;
import com.rserrano.assessment.domain.model.Price;
import com.rserrano.assessment.presentation.dto.FindPriceResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

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

    @GetMapping("/find-price")
    ResponseEntity<FindPriceResponseDto> getPriceByDateTimeAndProductIdAndBrandId(
            @RequestParam LocalDateTime desiredDateTime,
            @RequestParam Long productId,
            @RequestParam Long brandId
            ) {

        Price price = this.priceService.findPriceByDateTimeAndProductIdAndBrandId(desiredDateTime, productId, brandId);

        FindPriceResponseDto findPriceResponseDto = new FindPriceResponseDto();
        findPriceResponseDto.setProductId(price.getProduct().getId());
        findPriceResponseDto.setBrandId(price.getBrand().getId());
        findPriceResponseDto.setPriceList(price.getPriceList());
        findPriceResponseDto.setStartDateTime(price.getStartDateTime());
        findPriceResponseDto.setEndDateTime(price.getEndDateTime());
        findPriceResponseDto.setAmount(price.getAmount());

        return null;
    }

}
