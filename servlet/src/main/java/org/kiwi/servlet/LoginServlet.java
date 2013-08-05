package org.kiwi.servlet;

import org.kiwi.servlet.util.CookieUtils;
import org.kiwi.servlet.util.RenderUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("type").equals("login")) {
            RenderUtils.renderPage(this, req, resp, "login");
        } else if (req.getParameter("type").equals("logout")) {
            clearName(req);
            CookieUtils.clearCookie(req, resp, "name");
            RenderUtils.renderPage(this, req, resp, "login");
        }
    }

    private void clearName(HttpServletRequest req) {
        req.getSession().removeAttribute("name");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CookieUtils.createCookie(resp, "name", req.getParameter("name"));
        req.getSession().setAttribute("name", req.getParameter("name"));
        resp.sendRedirect("/hello");
    }
}
