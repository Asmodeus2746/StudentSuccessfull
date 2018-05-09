package ru.asmi.service;

import ru.asmi.dao.CourseDAO;
import ru.asmi.dao.CourseDAOImpl;
import ru.asmi.pojo.Course;

import java.sql.SQLException;
import java.util.ArrayList;

public class CourseServiceImpl implements CourseService {

    CourseDAO courseDAO = new CourseDAOImpl();

    @Override
    public ArrayList<Course> getCourses() throws SQLException {
        return courseDAO.getCourses();
    }

    @Override
    public Course getCourseById(int id) throws SQLException {
        return courseDAO.getCourseById(id);
    }

    @Override
    public boolean addCourse(Course course) throws SQLException {
        return courseDAO.addCourse(course);
    }

    @Override
    public boolean delCourse(int id) throws SQLException {
        return courseDAO.delCourse(id);
    }

    @Override
    public boolean delCourse(String title) throws SQLException {
        return courseDAO.delCourse(title);
    }

    @Override
    public boolean updateCourse(Course course) throws SQLException {
        return courseDAO.updateCourse(course);
    }
}
