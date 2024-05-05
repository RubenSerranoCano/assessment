package com.rserrano.assessment.presentation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerAcceptanceTests {

    private final String GET_PRICE_DETAILS_URL = "/api/v1/get-price-details";
    private final String PRODUCT_ID_KEY = "productId";
    private final String BRAND_ID_KEY = "brandId";
    private final String PRICE_LIST_NAME_KEY = "priceListName";
    private final String START_DATE_TIME_KEY = "startDateTime";
    private final String END_DATE_TIME_KEY = "endDateTime";
    private final String AMOUNT_KEY = "amount";


    @Autowired
    private MockMvc mockMvc;

    // Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    public void should_return_price_list_1() throws Exception {
        // Given
        final String desiredDateTime = "2020-06-14 10:00:00";
        final String productId = "35455";
        final String brandId = "1";

        // When
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(GET_PRICE_DETAILS_URL)
                .param("dateTime", desiredDateTime)
                .param("productId", productId)
                .param("brandId", brandId)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        // Then
        MockHttpServletResponse response = mvcResult.getResponse();
        String responseString = response.getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode responseJson = mapper.readTree(responseString);

        String expectedProductId = "35455";
        String expectedBrandId = "1";
        String expectedPriceListName = "Price list 1";
        String expectedStartDateTime = "2020-06-14T00:00:00";
        String expectedEndDateTime = "2020-12-31T23:59:59";
        String expectedAmount = "35.5";

        // Assert JSON content
        Assertions.assertEquals(expectedProductId, responseJson.get(PRODUCT_ID_KEY).asText());
        Assertions.assertEquals(expectedBrandId, responseJson.get(BRAND_ID_KEY).asText());
        Assertions.assertEquals(expectedPriceListName, responseJson.get(PRICE_LIST_NAME_KEY).asText());
        Assertions.assertEquals(expectedStartDateTime, responseJson.get(START_DATE_TIME_KEY).asText());
        Assertions.assertEquals(expectedEndDateTime, responseJson.get(END_DATE_TIME_KEY).asText());
        Assertions.assertEquals(expectedAmount, responseJson.get(AMOUNT_KEY).asText());
    }

    // Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    public void should_return_price_list_2() throws Exception {
        // Given
        final String desiredDateTime = "2020-06-14 16:00:00";
        final String productId = "35455";
        final String brandId = "1";

        // When
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(GET_PRICE_DETAILS_URL)
                .param("dateTime", desiredDateTime)
                .param("productId", productId)
                .param("brandId", brandId)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        // Then
        MockHttpServletResponse response = mvcResult.getResponse();
        String responseString = response.getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode responseJson = mapper.readTree(responseString);

        String expectedProductId = "35455";
        String expectedBrandId = "1";
        String expectedPriceListName = "Price list 2";
        String expectedStartDateTime = "2020-06-14T15:00:00";
        String expectedEndDateTime = "2020-06-14T18:30:00";
        String expectedAmount = "25.45";

        // Assert JSON content
        Assertions.assertEquals(expectedProductId, responseJson.get(PRODUCT_ID_KEY).asText());
        Assertions.assertEquals(expectedBrandId, responseJson.get(BRAND_ID_KEY).asText());
        Assertions.assertEquals(expectedPriceListName, responseJson.get(PRICE_LIST_NAME_KEY).asText());
        Assertions.assertEquals(expectedStartDateTime, responseJson.get(START_DATE_TIME_KEY).asText());
        Assertions.assertEquals(expectedEndDateTime, responseJson.get(END_DATE_TIME_KEY).asText());
        Assertions.assertEquals(expectedAmount, responseJson.get(AMOUNT_KEY).asText());
    }

    // Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
    @Test
    public void should_return_price_list_1_again() throws Exception {
        // Given
        final String desiredDateTime = "2020-06-14 21:00:00";
        final String productId = "35455";
        final String brandId = "1";

        // When
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(GET_PRICE_DETAILS_URL)
                .param("dateTime", desiredDateTime)
                .param("productId", productId)
                .param("brandId", brandId)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        // Then
        MockHttpServletResponse response = mvcResult.getResponse();
        String responseString = response.getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode responseJson = mapper.readTree(responseString);

        String expectedProductId = "35455";
        String expectedBrandId = "1";
        String expectedPriceListName = "Price list 1";
        String expectedStartDateTime = "2020-06-14T00:00:00";
        String expectedEndDateTime = "2020-12-31T23:59:59";
        String expectedAmount = "35.5";

        // Assert JSON content
        Assertions.assertEquals(expectedProductId, responseJson.get(PRODUCT_ID_KEY).asText());
        Assertions.assertEquals(expectedBrandId, responseJson.get(BRAND_ID_KEY).asText());
        Assertions.assertEquals(expectedPriceListName, responseJson.get(PRICE_LIST_NAME_KEY).asText());
        Assertions.assertEquals(expectedStartDateTime, responseJson.get(START_DATE_TIME_KEY).asText());
        Assertions.assertEquals(expectedEndDateTime, responseJson.get(END_DATE_TIME_KEY).asText());
        Assertions.assertEquals(expectedAmount, responseJson.get(AMOUNT_KEY).asText());
    }

    // Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
    @Test
    public void should_return_price_list_3() throws Exception {
        // Given
        final String desiredDateTime = "2020-06-15 10:00:00";
        final String productId = "35455";
        final String brandId = "1";

        // When
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(GET_PRICE_DETAILS_URL)
                .param("dateTime", desiredDateTime)
                .param("productId", productId)
                .param("brandId", brandId)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        // Then
        MockHttpServletResponse response = mvcResult.getResponse();
        String responseString = response.getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode responseJson = mapper.readTree(responseString);

        String expectedProductId = "35455";
        String expectedBrandId = "1";
        String expectedPriceListName = "Price list 3";
        String expectedStartDateTime = "2020-06-15T00:00:00";
        String expectedEndDateTime = "2020-06-15T11:00:00";
        String expectedAmount = "30.5";

        // Assert JSON content
        Assertions.assertEquals(expectedProductId, responseJson.get(PRODUCT_ID_KEY).asText());
        Assertions.assertEquals(expectedBrandId, responseJson.get(BRAND_ID_KEY).asText());
        Assertions.assertEquals(expectedPriceListName, responseJson.get(PRICE_LIST_NAME_KEY).asText());
        Assertions.assertEquals(expectedStartDateTime, responseJson.get(START_DATE_TIME_KEY).asText());
        Assertions.assertEquals(expectedEndDateTime, responseJson.get(END_DATE_TIME_KEY).asText());
        Assertions.assertEquals(expectedAmount, responseJson.get(AMOUNT_KEY).asText());
    }

    // Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
    @Test
    public void should_return_price_list_4() throws Exception {
        // Given
        final String desiredDateTime = "2020-06-16 21:00:00";
        final String productId = "35455";
        final String brandId = "1";

        // When
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(GET_PRICE_DETAILS_URL)
                .param("dateTime", desiredDateTime)
                .param("productId", productId)
                .param("brandId", brandId)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        // Then
        MockHttpServletResponse response = mvcResult.getResponse();
        String responseString = response.getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode responseJson = mapper.readTree(responseString);

        String expectedProductId = "35455";
        String expectedBrandId = "1";
        String expectedPriceListName = "Price list 4";
        String expectedStartDateTime = "2020-06-15T16:00:00";
        String expectedEndDateTime = "2020-12-31T23:59:59";
        String expectedAmount = "38.95";

        // Assert JSON content
        Assertions.assertEquals(expectedProductId, responseJson.get(PRODUCT_ID_KEY).asText());
        Assertions.assertEquals(expectedBrandId, responseJson.get(BRAND_ID_KEY).asText());
        Assertions.assertEquals(expectedPriceListName, responseJson.get(PRICE_LIST_NAME_KEY).asText());
        Assertions.assertEquals(expectedStartDateTime, responseJson.get(START_DATE_TIME_KEY).asText());
        Assertions.assertEquals(expectedEndDateTime, responseJson.get(END_DATE_TIME_KEY).asText());
        Assertions.assertEquals(expectedAmount, responseJson.get(AMOUNT_KEY).asText());
    }
}