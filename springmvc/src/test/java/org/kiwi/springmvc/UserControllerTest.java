package org.kiwi.springmvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void should_get_user_by_path() throws Exception {
        mockMvc.perform(get("/user/kiwi"))
                .andExpect(view().name(is("user/show")))
                .andExpect(model().attribute("name", is("kiwi")));
    }

    @Test
    public void should_get_user_by_param() throws Exception {
        mockMvc.perform(get("/user?name=camel"))
                .andExpect(view().name(is("user/show")))
                .andExpect(model().attribute("name", is("camel")));
    }

    @Test
    public void should_get_user_list() throws Exception {
        mockMvc.perform(get("/user/index"))
                .andExpect(view().name(is("user/index")))
                .andExpect(model().attribute("users", hasItems(
                        "lucy", "jack", "kiwi"
                )));
    }
}
