package org.kiwi.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("type").equals("login")) {
            toLoginPage(req, resp);
        } else if (req.getParameter("type").equals("logout")) {
            clearName(req);
            toLoginPage(req, resp);
        }
    }

    private void clearName(HttpServletRequest req) {
        req.getSession().removeAttribute("name");
    }

    private void toLoginPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("page", "login.jsp");
        getServletContext().getRequestDispatcher("/WEB-INF/pages/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("name", req.getParameter("name"));
        resp.sendRedirect("/hello");
    }
}
