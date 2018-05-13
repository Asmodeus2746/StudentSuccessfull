package ru.asmi.dao;

import ru.asmi.pojo.Course;
import ru.asmi.pojo.Homework;
import ru.asmi.pojo.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface HomeworkDAO {
    ArrayList<Homework> getHomeworkList(Student student, Course course) throws SQLException, StudentNotFoundException, CourseNotFoundException;
    Homework getHomeworkById(int id) throws SQLException;
    void addHomework(Homework homework) throws SQLException, LectionNotFoundException, StudentNotFoundException;
    void delHomework(int id) throws SQLException;
    void updateHomework(Homework homework) throws SQLException, LectionNotFoundException, StudentNotFoundException;
}
