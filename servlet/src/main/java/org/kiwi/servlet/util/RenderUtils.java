package org.kiwi.servlet.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RenderUtils {
    public static void renderPage(HttpServlet servlet, HttpServletRequest req, HttpServletResponse resp, final String pageName) throws ServletException, IOException {
        req.setAttribute("page", pageName + ".jsp");
        servlet.getServletContext().getRequestDispatcher("/WEB-INF/pages/main.jsp").forward(req, resp);
    }
}
