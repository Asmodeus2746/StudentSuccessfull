package ru.asmi.servlets;

import ru.asmi.service.UserService;
import ru.asmi.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Registration extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String soname = req.getParameter("soname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));

        int regRet = userService.registration(email, password, name, soname, age);
        switch (regRet) {
            case UserService.FAILED: {
                resp.sendRedirect(req.getContextPath() + "/registration.jsp?ret=FAILED");
                break;
            }
            case UserService.SUCCESS: {
                resp.sendRedirect(req.getContextPath() + "/registration.jsp?ret=SUCCESS");
                break;
            }
            case UserService.INVALID_DATA: {
                resp.sendRedirect(req.getContextPath() + "/registration.jsp?ret=INVALID_DATA");
                break;
            }
            case UserService.ALREADY_USED: {
                resp.sendRedirect(req.getContextPath() + "/registration.jsp?ret=ALREADY_USED");
                break;
            }
        }
    }
}
