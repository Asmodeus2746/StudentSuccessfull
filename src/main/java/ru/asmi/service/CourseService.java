package ru.asmi.service;

import ru.asmi.pojo.Course;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CourseService {
    ArrayList<Course> getCourses() throws SQLException;
    Course getCourseById(int id) throws SQLException;
    boolean addCourse(Course course) throws SQLException;
    boolean delCourse(int id) throws SQLException;
    boolean delCourse(String title) throws SQLException;
    boolean updateCourse(Course course) throws SQLException;
}
