package ru.asmi.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LeaveSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("name", null);
        req.getSession().setAttribute("id", null);
        req.getSession().setAttribute("seqLevel", null);
        resp.sendRedirect(req.getContextPath() + "/auth.jsp");
    }
}
