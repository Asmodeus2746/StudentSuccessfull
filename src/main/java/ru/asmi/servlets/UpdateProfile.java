package ru.asmi.servlets;

import ru.asmi.Enumerations.RegistationRet;
import ru.asmi.service.UserService;
import ru.asmi.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateProfile extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String soname = req.getParameter("soname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        int age;
        try {
            age =  Integer.parseInt(req.getParameter("age"));
        } catch (NumberFormatException e) {
            age = 0;
        }

        RegistationRet regRet = userService.updateUser(email, password, name, soname, age);
        switch (regRet) {
            case FAILED: {
                resp.sendRedirect(req.getContextPath() + "/profile.jsp?ret=FAILED");
                break;
            }
            case SUCCESS: {
                resp.sendRedirect(req.getContextPath() + "/profile");
                break;
            }
            case ALREADY_USED: {
                resp.sendRedirect(req.getContextPath() + "/profile.jsp?ret=ALREADY_USED");
                break;
            }
            case INVALID_EMAIL: {
                resp.sendRedirect(req.getContextPath() + "/profile.jsp?ret=INVALID_EMAIL");
                break;
            }
            case INVALID_PASSWORD: {
                resp.sendRedirect(req.getContextPath() + "/profile.jsp?ret=INVALID_PASSWORD");
                break;
            }
            case INVALID_NAME: {
                resp.sendRedirect(req.getContextPath() + "/profile.jsp?ret=INVALID_NAME");
                break;
            }
            case INVALID_SONAME: {
                resp.sendRedirect(req.getContextPath() + "/profile.jsp?ret=INVALID_SONAME");
                break;
            }
            case INVALID_AGE: {
                resp.sendRedirect(req.getContextPath() + "/registration.jsp?ret=INVALID_AGE");
                break;
            }
        }
    }
}
