package ru.asmi.servlets;

import org.apache.log4j.Logger;
import ru.asmi.pojo.Course;
import ru.asmi.pojo.Student;
import ru.asmi.service.CourseService;
import ru.asmi.service.CourseServiceImpl;
import ru.asmi.service.StudentService;
import ru.asmi.service.StudentServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GetCourseListServlet extends HttpServlet {

    private final static Logger logger = Logger.getLogger(GetCourseListServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        CourseService courseService = new CourseServiceImpl();
        try {
            List<Course> courses = courseService.getCourses();
            for(Course course : courses) resp.getWriter().println("course: " + course.getTitle() + " annotation: " + course.getAnnotation());
        } catch (SQLException | NullPointerException e) {
            resp.getWriter().println("Sorry! We have some problems =(");
            logger.error("Problem with course_list page");
            logger.error(e.toString());
        }
    }
}
