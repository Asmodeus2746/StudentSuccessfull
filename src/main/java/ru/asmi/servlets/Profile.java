package ru.asmi.servlets;

import ru.asmi.pojo.Student;
import ru.asmi.service.UserService;
import ru.asmi.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Profile extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = null;

        Integer id = (Integer) req.getSession().getAttribute("id");
        if(id != null) student = userService.getStudentInformation(id);
        if(student != null) {
            req.getSession().setAttribute("email", student.getEmail());
            req.getSession().setAttribute("soname", student.getSoname());
            req.getSession().setAttribute("age", student.getAge());
        }
        resp.sendRedirect(req.getContextPath() + "/profile.jsp");
    }
}
