package org.kiwi.servlet;

import org.kiwi.servlet.util.CookieUtils;
import org.kiwi.servlet.util.RenderUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (CookieUtils.isCookieExist(req, "name")) {
            req.getSession().setAttribute("name", CookieUtils.getCookieValue(req, "name"));
            RenderUtils.renderPage(this, req, resp, "hello");
        } else {
            RenderUtils.renderPage(this, req, resp, "home");
        }
    }
}
