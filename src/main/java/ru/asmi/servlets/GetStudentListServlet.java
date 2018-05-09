package ru.asmi.servlets;

import org.apache.log4j.Logger;
import ru.asmi.dao.StudentDAO;
import ru.asmi.dao.StudentDAOImpl;
import ru.asmi.pojo.Student;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GetStudentListServlet extends HttpServlet {

    private final static Logger logger = Logger.getLogger(GetStudentListServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StudentDAO studentDAO = new StudentDAOImpl();
        try {
            List<Student> students = studentDAO.getStudents();
            for(Student student : students) resp.getWriter().println("name: " + student.getName() + " soname: " + student.getSoname() + " age: " + student.getAge());
        } catch (SQLException | NullPointerException e) {
            resp.getWriter().println("Sorry! We have some problems =(");
            logger.error("Problem with student_list page");
            logger.error(e.toString());
        }
    }
}
