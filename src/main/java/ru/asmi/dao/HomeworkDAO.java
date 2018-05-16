package ru.asmi.dao;

import ru.asmi.Exceptions.CourseNotFoundException;
import ru.asmi.Exceptions.LectionNotFoundException;
import ru.asmi.Exceptions.StudentNotFoundException;
import ru.asmi.pojo.Course;
import ru.asmi.pojo.Homework;
import ru.asmi.pojo.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface HomeworkDAO {
    ArrayList<Homework> getHomeworkList(Student student, Course course) throws SQLException;
    Homework getHomeworkById(int id) throws SQLException;
    void addHomework(Homework homework) throws SQLException;
    void delHomework(int id) throws SQLException;
    void updateHomework(Homework homework) throws SQLException;
}
