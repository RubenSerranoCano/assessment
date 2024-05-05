package com.rserrano.assessment.presentation;

import com.rserrano.assessment.application.PriceService;
import com.rserrano.assessment.domain.model.Price;
import com.rserrano.assessment.infrastructure.constants.DateConstants;
import com.rserrano.assessment.presentation.dto.FindPriceResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @GetMapping("/get-price-details")
    @Operation(
            summary = "Get the price details on a given time for a certain product and brand",
            description =
                    "Given a desired date and time, the product id and the brand id, returns the price details. " +
                    "In case of an overlap in the dates, it will return the price with the highest priority"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The price details have been successfully retrieved."),
            @ApiResponse(responseCode = "204", description = "No price found given the provided parameters.")
    })
    ResponseEntity<FindPriceResponseDto> getPriceByDateTimeAndProductIdAndBrandId(
            @RequestParam @Parameter(description = "format: '" + DateConstants.DEFAULT_DATE_TIME_FORMAT + "'.") String dateTime,
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
