package com.learning.ex_productservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.ex_productservice.Model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class ExProductServiceApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void test() throws Exception {
        long ct=restTemplate.getForObject("/products/prodcount", Long.class);
        Assertions.assertEquals(ct,7);
    }

    @Test
    @Disabled
    void tesr1() throws Exception {
        Product product = new Product();
        product.setPrd_name("Samsung_S25");
        product.setPrd_price(70000);
        product.setPrd_desc("Samsung S25 advanced mobile");
        product.setPrd_count(10);
        mockMvc.perform(post("/products/addproduct1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.prd_name").value("Samsung_S25"));

    }
}
