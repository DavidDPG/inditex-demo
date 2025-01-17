package com.daviddpg.inditexdemo.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RateControllerTest {

    private final String RATES_URL = "/api/rates";                              // Maybe a constants class is better, I could reuse them on the controller?

    private final String DATETIME_PARAM = "dateTime";
    private final String PRODUCT_ID_PARAM = "productId";
    private final String BRAND_ID_PARAM = "brandId";

    private final MockMvc mockMvc;

    public RateControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    @DisplayName("10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")  //  It was difficult to come up with a good name for the tests that related to the requirements
    void test1() throws Exception {                                             //  so I opted for giving them display names
        this.mockMvc.perform(
                    MockMvcRequestBuilders.get(RATES_URL)                       //  Could extract these common parts to a private method that accepts the dateTime
                    .queryParam(DATETIME_PARAM, "2020-06-14-10.00.00")  //  but I feel that leaving the explicit query parameters in a test makes it more readable
                    .queryParam(PRODUCT_ID_PARAM, "35455")
                    .queryParam(BRAND_ID_PARAM, "1")
                )
                .andDo(
                        MockMvcResultHandlers.print()
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("rateId: 1")));
    }

    @Test
    @DisplayName("16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void test2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(RATES_URL)
                                .queryParam(DATETIME_PARAM, "2020-06-14-16.00.00")
                                .queryParam(PRODUCT_ID_PARAM, "35455")
                                .queryParam(BRAND_ID_PARAM, "1")
                )
                .andDo(
                        MockMvcResultHandlers.print()
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("rateId: 2")));
    }

    @Test
    @DisplayName("21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void test3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(RATES_URL)
                                .queryParam(DATETIME_PARAM, "2020-06-14-21.00.00")
                                .queryParam(PRODUCT_ID_PARAM, "35455")
                                .queryParam(BRAND_ID_PARAM, "1")
                )
                .andDo(
                        MockMvcResultHandlers.print()
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("rateId: 2")));
    }

    @Test
    @DisplayName("10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
    void test4() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(RATES_URL)
                                .queryParam(DATETIME_PARAM, "2020-06-15-10.00.00")
                                .queryParam(PRODUCT_ID_PARAM, "35455")
                                .queryParam(BRAND_ID_PARAM, "1")
                )
                .andDo(
                        MockMvcResultHandlers.print()
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("rateId: 3")));
    }

    @Test
    @DisplayName("21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
    void test5() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(RATES_URL)
                                .queryParam(DATETIME_PARAM, "2020-06-16-21.00.00")
                                .queryParam(PRODUCT_ID_PARAM, "35455")
                                .queryParam(BRAND_ID_PARAM, "1")
                )
                .andDo(
                        MockMvcResultHandlers.print()
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("rateId: 4")));
    }
}
