package com.example.demo.controller;

import com.google.gson.JsonObject;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CalculationController.class)
class CalculationControllerTest {

    // for mocking HTTP requests
    @Autowired
    private MockMvc mockMvc;

    // test POST method function
    @Test
    void testAddPostInt() throws Exception {
        JsonObject post_body = new JsonObject();
        post_body.addProperty("number_a", 1);
        post_body.addProperty("number_b", 2);

        MvcResult result = this.mockMvc.perform(post(CalculationController.BASE_URL+"/add/")
                .contentType(MediaType.APPLICATION_JSON).content(String.valueOf(post_body)))
                .andExpect(status().isAccepted())
                .andReturn();

        assertEquals("3",result.getResponse().getContentAsString());
    }

    @Test
    void testAddPostString() throws Exception {
        JsonObject post_body = new JsonObject();
        post_body.addProperty("number_a", "1");
        post_body.addProperty("number_b", "2");

        MvcResult result = this.mockMvc.perform(post(CalculationController.BASE_URL+"/add/")
                .contentType(MediaType.APPLICATION_JSON).content(String.valueOf(post_body)))
                .andExpect(status().isAccepted())
                .andReturn();

        assertEquals("3",result.getResponse().getContentAsString());
    }

    // test GET method function
    @Test
    void testAddGetInt() throws Exception {
        MvcResult result = this.mockMvc.perform(get(CalculationController.BASE_URL+"/add/1/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertEquals("2",result.getResponse().getContentAsString());
    }

    @Ignore("Until GET parameters can be parsed")
    @Test
    void testAddGetString() throws Exception {
        MvcResult result = this.mockMvc.perform(get(CalculationController.BASE_URL+"/add/'1'/'1'"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertEquals("2",result.getResponse().getContentAsString());
    }
}