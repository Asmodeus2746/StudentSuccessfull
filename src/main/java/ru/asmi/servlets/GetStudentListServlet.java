package ru.asmi.servlets;

import ru.asmi.dao.StudentDAO;
import ru.asmi.dao.StudentDAOImpl;
import ru.asmi.pojo.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GetStudentListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentDAO studentDAO = new StudentDAOImpl();
        try {
            List<Student> students = studentDAO.getStudents();
            for(Student student : students) resp.getWriter().println("name: " + student.getName() + " soname: " + student.getSoname() + " age: " + student.getAge());
        } catch (SQLException e) {
            //e.printStackTrace();
            resp.getWriter().println("Can't connect with database");
        }
    }
}
