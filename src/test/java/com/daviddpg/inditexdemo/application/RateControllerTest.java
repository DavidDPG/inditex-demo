package com.daviddpg.inditexdemo.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RateControllerTest {

    private final String RATES_URL = "/rates";                                  // Maybe a constants class is better, I could reuse them on the controller?

    private final String DATETIME_PARAM = "dateTime";
    private final String PRODUCT_ID_PARAM = "productId";
    private final String BRAND_ID_PARAM = "brandId";

    private final MockMvc mockMvc;

    public RateControllerTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    // localhost:8080/api/rates/

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
                .andExpect(MockMvcResultMatchers.jsonPath("$.rateId").value("1"));
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
                .andExpect(MockMvcResultMatchers.jsonPath("$.rateId").value("2"));
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
                .andExpect(MockMvcResultMatchers.jsonPath("$.rateId").value("1"));
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
                .andExpect(MockMvcResultMatchers.jsonPath("$.rateId").value("3"));
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
                .andExpect(MockMvcResultMatchers.jsonPath("$.rateId").value("4"));
    }

    // Extra tests
    @Test
    @DisplayName("10:00 del día 10 del producto 35455 para la brand 1 (ZARA)")
    void test6() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(RATES_URL)
                                .queryParam(DATETIME_PARAM, "2020-06-10-10.00.00")
                                .queryParam(PRODUCT_ID_PARAM, "35455")
                                .queryParam(BRAND_ID_PARAM, "1")
                )
                .andDo(
                        MockMvcResultHandlers.print()
                )
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("404 NOT_FOUND"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Could not find Rate that matches parameters"));
    }

    @Test
    @DisplayName("18:30 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void test7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(RATES_URL)
                                .queryParam(DATETIME_PARAM, "2020-06-14-18.30.00")
                                .queryParam(PRODUCT_ID_PARAM, "35455")
                                .queryParam(BRAND_ID_PARAM, "1")
                )
                .andDo(
                        MockMvcResultHandlers.print()
                )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.rateId").value("2"));
    }

    @Test
    @DisplayName("15:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void test8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(RATES_URL)
                                .queryParam(DATETIME_PARAM, "2020-06-14-15.00.00")
                                .queryParam(PRODUCT_ID_PARAM, "35455")
                                .queryParam(BRAND_ID_PARAM, "1")
                )
                .andDo(
                        MockMvcResultHandlers.print()
                )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.rateId").value("2"));
    }

    @Test
    @DisplayName("14:59:59 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void test9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(RATES_URL)
                                .queryParam(DATETIME_PARAM, "2020-06-14-14.59.59")
                                .queryParam(PRODUCT_ID_PARAM, "35455")
                                .queryParam(BRAND_ID_PARAM, "1")
                )
                .andDo(
                        MockMvcResultHandlers.print()
                )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.rateId").value("1"));
    }

    @Test
    @DisplayName("18:30:01 del día 14 del producto 35455 para la brand 1 (ZARA)")
    void test10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(RATES_URL)
                                .queryParam(DATETIME_PARAM, "2020-06-14-18.30.01")
                                .queryParam(PRODUCT_ID_PARAM, "35455")
                                .queryParam(BRAND_ID_PARAM, "1")
                )
                .andDo(
                        MockMvcResultHandlers.print()
                )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.rateId").value("1"));
    }

    @Test
    @DisplayName("Brand no existente (2)")
    void test11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(RATES_URL)
                                .queryParam(DATETIME_PARAM, "2020-06-14-18.30.00")
                                .queryParam(PRODUCT_ID_PARAM, "35455")
                                .queryParam(BRAND_ID_PARAM, "2")
                )
                .andDo(
                        MockMvcResultHandlers.print()
                )
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("404 NOT_FOUND"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Could not find Rate that matches parameters"));
    }

    @Test
    @DisplayName("Producto no existente (10000)")
    void test12() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(RATES_URL)
                                .queryParam(DATETIME_PARAM, "2020-06-14-18.30.00")
                                .queryParam(PRODUCT_ID_PARAM, "10000")
                                .queryParam(BRAND_ID_PARAM, "1")
                )
                .andDo(
                        MockMvcResultHandlers.print()
                )
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("404 NOT_FOUND"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Could not find Rate that matches parameters"));
    }

    @Test
    @DisplayName("Producto no existente (10000) y brand no existente (2)")
    void test13() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(RATES_URL)
                                .queryParam(DATETIME_PARAM, "2020-06-14-18.30.00")
                                .queryParam(PRODUCT_ID_PARAM, "10000")
                                .queryParam(BRAND_ID_PARAM, "2")
                )
                .andDo(
                        MockMvcResultHandlers.print()
                )
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("404 NOT_FOUND"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Could not find Rate that matches parameters"));
    }

    @Test
    @DisplayName("Formato de fecha invalido(20200614-183000)")
    void test14() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(RATES_URL)
                                .queryParam(DATETIME_PARAM, "20200614-183000")
                                .queryParam(PRODUCT_ID_PARAM, "35455")
                                .queryParam(BRAND_ID_PARAM, "1")
                )
                .andDo(
                        MockMvcResultHandlers.print()
                )
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.code").value("400 BAD_REQUEST"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("dateTime format is incorrect"));
    }
}
