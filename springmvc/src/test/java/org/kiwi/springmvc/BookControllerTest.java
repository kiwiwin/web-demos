package org.kiwi.springmvc;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class BookControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new BookController()).build();
    }

    @Test
    public void should_get_book_list() throws Exception {
        mockMvc.perform(get("/user/mike/book/index"))
                .andExpect(view().name(is("book/index")))
                .andExpect(model().attribute("books", hasItems(
                        "harry potter", "hello world", "man from mars", "asshole"
                )))
                .andExpect(model().attribute("userId", is("mike")));
    }

    @Test
    public void should_get_book() throws Exception {
        mockMvc.perform(get("/user/jack/book/mybook/show"))
                .andExpect(view().name(is("book/show")))
                .andExpect(model().attribute("userId", is("jack")))
                .andExpect(model().attribute("bookId", is("mybook")));
    }
}
