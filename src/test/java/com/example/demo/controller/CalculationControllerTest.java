package com.example.demo.controller;

import com.google.gson.JsonObject;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.env.Environment;
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

    @Autowired
    private Environment env;

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

    @Test
    void testAddPostMixedString() throws Exception {
        JsonObject post_body = new JsonObject();
        post_body.addProperty("number_a", 1);
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

    @Test
    void testAddGetOverflow() throws Exception {
        MvcResult result = this.mockMvc.perform(get(CalculationController.BASE_URL+"/add/1000000000000/100000000000"))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity())
                .andReturn();

        assertEquals( env.getProperty("error.input.malformednumbers"),result.getResponse().getContentAsString());
    }

    @Test
    void testIntOverflow() throws Exception {
        JsonObject post_body = new JsonObject();
        post_body.addProperty("number_a", Integer.MAX_VALUE);
        post_body.addProperty("number_b", "2");

        MvcResult result = this.mockMvc.perform(post(CalculationController.BASE_URL+"/add/")
                .contentType(MediaType.APPLICATION_JSON).content(String.valueOf(post_body)))
                .andExpect(status().isNotAcceptable())
                .andReturn();

        assertEquals( env.getProperty("error.output.intoverflow"),result.getResponse().getContentAsString());
    }

    @Test
    void testIntOverflowSecond() throws Exception {
        JsonObject post_body = new JsonObject();
        post_body.addProperty("number_a", Integer.MAX_VALUE);
        post_body.addProperty("number_b", Integer.MAX_VALUE);

        MvcResult result = this.mockMvc.perform(post(CalculationController.BASE_URL+"/add/")
                .contentType(MediaType.APPLICATION_JSON).content(String.valueOf(post_body)))
                .andExpect(status().isNotAcceptable())
                .andReturn();

        assertEquals( env.getProperty("error.output.intoverflow"),result.getResponse().getContentAsString());
    }

    @Test
    void testMalformedInput() throws Exception {
        JsonObject post_body = new JsonObject();
        post_body.addProperty("number_a", "2324dsfdg3423");
        post_body.addProperty("number_b", "2");

        MvcResult result = this.mockMvc.perform(post(CalculationController.BASE_URL+"/add/")
                .contentType(MediaType.APPLICATION_JSON).content(String.valueOf(post_body)))
                .andExpect(status().isUnprocessableEntity())
                .andReturn();

        assertEquals( env.getProperty("error.input.malformednumbers"),result.getResponse().getContentAsString());
    }
}