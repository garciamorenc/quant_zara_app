package org.quant.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.quant.domain.model.PriceDto;
import org.quant.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PriceControllerImpl.class)
@ContextConfiguration(classes = {PriceController.class, PriceControllerImpl.class})
public class PriceControllerImplTest {

    private static final PriceDto PRICE_LIST_1 = PriceDto.builder()
                .brandId(1)
                .startDate("2020-06-14-00.00.00")
                .endDate("2020-06-14-00.00.00")
                .priceList(1)
                .productId(35455)
                .price(35.50)
                .build();

    private static final PriceDto PRICE_LIST_2 = PriceDto.builder()
            .brandId(1)
            .startDate("2020-06-14-15.00.00")
            .endDate("2020-06-14-18.30.00")
            .priceList(2)
            .productId(35455)
            .price(25.45)
            .build();

    private static final PriceDto PRICE_LIST_3 = PriceDto.builder()
            .brandId(1)
            .startDate("2020-06-15-00.00.00")
            .endDate("2020-06-15-11.00.00")
            .priceList(3)
            .productId(35455)
            .price(30.50)
            .build();

    private static final PriceDto PRICE_LIST_4 = PriceDto.builder()
            .brandId(1)
            .startDate("2020-06-15-16.00.00")
            .endDate("2020-12-31-23.59.59")
            .priceList(4)
            .productId(35455)
            .price(38.95)
            .build();

    private static final Integer BRAND_ID = 1;
    private static final Integer PRODUCT_ID = 35455;

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PriceService priceService;

    private ObjectMapper objectMapper = new ObjectMapper();

    // Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    void givenGetPriceByFilters_Test1_thenFindPriceList1() throws Exception {
        String testDate = "2020-06-14-10.00.00";
        when(priceService.getPriceByBrandProductDate(BRAND_ID, PRODUCT_ID, testDate)).thenReturn(PRICE_LIST_1);
        mvc.perform(MockMvcRequestBuilders.get("/prices")
                        .param("brandId", BRAND_ID.toString())
                        .param("productId", PRODUCT_ID.toString())
                        .param("date", testDate)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId")
                        .value(PRICE_LIST_1.brandId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate")
                        .value(PRICE_LIST_1.startDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate")
                        .value(PRICE_LIST_1.endDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList")
                        .value(PRICE_LIST_1.priceList()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId")
                        .value(PRICE_LIST_1.productId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price")
                        .value(PRICE_LIST_1.price()));

        verify(priceService, only()).getPriceByBrandProductDate(BRAND_ID, PRODUCT_ID, testDate);
    }

    // Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    void givenGetPriceByFilters_Test2_thenFindPriceList2() throws Exception {
        String testDate = "2020-06-14-16.00.00";
        when(priceService.getPriceByBrandProductDate(BRAND_ID, PRODUCT_ID, testDate)).thenReturn(PRICE_LIST_2);
        mvc.perform(MockMvcRequestBuilders.get("/prices")
                        .param("brandId", BRAND_ID.toString())
                        .param("productId", PRODUCT_ID.toString())
                        .param("date", testDate)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId")
                        .value(PRICE_LIST_2.brandId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate")
                        .value(PRICE_LIST_2.startDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate")
                        .value(PRICE_LIST_2.endDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList")
                        .value(PRICE_LIST_2.priceList()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId")
                        .value(PRICE_LIST_2.productId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price")
                        .value(PRICE_LIST_2.price()));

        verify(priceService, only()).getPriceByBrandProductDate(BRAND_ID, PRODUCT_ID, testDate);
    }

    // Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    void givenGetPriceByFilters_Test3_thenFindPriceList1() throws Exception {
        String testDate = "2020-06-14-21.00.00";
        when(priceService.getPriceByBrandProductDate(BRAND_ID, PRODUCT_ID, testDate)).thenReturn(PRICE_LIST_2);
        mvc.perform(MockMvcRequestBuilders.get("/prices")
                        .param("brandId", BRAND_ID.toString())
                        .param("productId", PRODUCT_ID.toString())
                        .param("date", testDate)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId")
                        .value(PRICE_LIST_2.brandId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate")
                        .value(PRICE_LIST_2.startDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate")
                        .value(PRICE_LIST_2.endDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList")
                        .value(PRICE_LIST_2.priceList()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId")
                        .value(PRICE_LIST_2.productId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price")
                        .value(PRICE_LIST_2.price()));

        verify(priceService, only()).getPriceByBrandProductDate(BRAND_ID, PRODUCT_ID, testDate);
    }

    // Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
    @Test
    void givenGetPriceByFilters_Test4_thenFindPriceList3() throws Exception {
        String testDate = "2020-06-15-10.00.00";
        when(priceService.getPriceByBrandProductDate(BRAND_ID, PRODUCT_ID, testDate)).thenReturn(PRICE_LIST_3);
        mvc.perform(MockMvcRequestBuilders.get("/prices")
                        .param("brandId", BRAND_ID.toString())
                        .param("productId", PRODUCT_ID.toString())
                        .param("date", testDate)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId")
                        .value(PRICE_LIST_3.brandId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate")
                        .value(PRICE_LIST_3.startDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate")
                        .value(PRICE_LIST_3.endDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList")
                        .value(PRICE_LIST_3.priceList()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId")
                        .value(PRICE_LIST_3.productId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price")
                        .value(PRICE_LIST_3.price()));

        verify(priceService, only()).getPriceByBrandProductDate(BRAND_ID, PRODUCT_ID, testDate);
    }

    // Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
    @Test
    void givenGetPriceByFilters_Test5_thenFindPriceList4() throws Exception {
        String testDate = "2020-06-15-21.00.00";
        when(priceService.getPriceByBrandProductDate(BRAND_ID, PRODUCT_ID, testDate)).thenReturn(PRICE_LIST_4);
        mvc.perform(MockMvcRequestBuilders.get("/prices")
                        .param("brandId", BRAND_ID.toString())
                        .param("productId", PRODUCT_ID.toString())
                        .param("date", testDate)
                        .accept(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.brandId")
                        .value(PRICE_LIST_4.brandId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.startDate")
                        .value(PRICE_LIST_4.startDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.endDate")
                        .value(PRICE_LIST_4.endDate()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.priceList")
                        .value(PRICE_LIST_4.priceList()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.productId")
                        .value(PRICE_LIST_4.productId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price")
                        .value(PRICE_LIST_4.price()));

        verify(priceService, only()).getPriceByBrandProductDate(BRAND_ID, PRODUCT_ID, testDate);
    }
}
