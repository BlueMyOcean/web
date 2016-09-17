package com.jinjiang.web.back.test;

import com.jinjiang.web.back.controller.IndexController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by W on 2016/8/25.
 */
public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception{
        IndexController homeController = new IndexController();

        MockMvc mockMvc = standaloneSetup(homeController).build();

        mockMvc.perform(get("/")).andExpect(view().name("home"));


    }
}
