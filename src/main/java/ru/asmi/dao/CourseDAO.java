package ru.asmi.dao;

import ru.asmi.pojo.Course;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CourseDAO {
    ArrayList<Course> getCourses() throws SQLException;
    Course getCourseById(int id) throws SQLException;
    void addCourse(Course course) throws SQLException;
    void delCourse(int id) throws SQLException;
    void delCourse(String title) throws SQLException;
    void updateCourse(Course course) throws SQLException;
}
