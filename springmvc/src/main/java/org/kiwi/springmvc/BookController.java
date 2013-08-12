package org.kiwi.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static java.util.Arrays.asList;

@Controller
@RequestMapping(value = "/user/{userId}/book")
public class BookController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView getUserBooks(@PathVariable String userId) {
        ModelAndView modelAndView = new ModelAndView("book/index");
        modelAndView.addObject("userId", userId);
        modelAndView.addObject("books", asList("harry potter", "hello world", "man from mars", "asshole"));
        return modelAndView;
    }

    @RequestMapping(value = "/{bookId}/show")
    public ModelAndView showUserBook(@PathVariable String userId, @PathVariable String bookId) {
        ModelAndView modelAndView = new ModelAndView("book/show");
        modelAndView.addObject("userId", userId);
        modelAndView.addObject("bookId", bookId);
        return modelAndView;
    }
}
