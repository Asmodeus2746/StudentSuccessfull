package ru.asmi.servlets;

import ru.asmi.pojo.Student;
import ru.asmi.service.UserService;
import ru.asmi.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Auth extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Student student = userService.auth(email, password);
        if(student != null) {
            req.getSession().setAttribute("name", student.getName());
            req.getSession().setAttribute("id", student.getId());
            req.getSession().setAttribute("seqLevel", student.getSeqLevel());
            resp.sendRedirect(req.getContextPath() + "/auth.jsp?ret=SUCCESS");
        } else {
            resp.sendRedirect(req.getContextPath() + "/auth.jsp?ret=FAILED");
        }
    }
}
