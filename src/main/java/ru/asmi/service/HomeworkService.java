package ru.asmi.service;

import ru.asmi.dao.CourseNotFoundException;
import ru.asmi.dao.LectionNotFoundException;
import ru.asmi.dao.StudentNotFoundException;
import ru.asmi.pojo.Course;
import ru.asmi.pojo.Homework;
import ru.asmi.pojo.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface HomeworkService {
    ArrayList<Homework> getHomeworkList(Student student, Course course) throws SQLException, StudentNotFoundException, CourseNotFoundException;
    Homework getHomeworkById(int id) throws SQLException;
    boolean addHomework(Homework homework) throws SQLException, LectionNotFoundException, StudentNotFoundException;
    boolean delHomework(int id) throws SQLException;
    boolean updateHomework(Homework homework) throws SQLException, LectionNotFoundException, StudentNotFoundException;
}
