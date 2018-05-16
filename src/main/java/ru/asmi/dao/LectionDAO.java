package ru.asmi.dao;

import ru.asmi.Exceptions.CourseNotFoundException;
import ru.asmi.pojo.Course;
import ru.asmi.pojo.Lection;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LectionDAO {
    ArrayList<Lection> getLectionByCourse(Course course) throws SQLException;
    ArrayList<Lection> getLectionByCourse(String courseName) throws SQLException;
    Lection getLectionById(int id) throws SQLException;
    void addLection(Lection lection) throws SQLException;
    void delLection(int id) throws SQLException;
    void updateLection(Lection lection) throws SQLException;
}
