package ru.asmi.service;

import ru.asmi.dao.CourseNotFoundException;
import ru.asmi.pojo.Course;
import ru.asmi.pojo.Lection;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LectionService {
    ArrayList<Lection> getLectionByCourse(Course course) throws SQLException;
    ArrayList<Lection> getLectionByCourse(String courseName) throws SQLException;
    Lection getLectionById(int id) throws SQLException;
    boolean addLection(Lection lection) throws SQLException, CourseNotFoundException;
    boolean delLection(int id) throws SQLException;
    boolean updateLection(Lection lection) throws SQLException, CourseNotFoundException;
}
