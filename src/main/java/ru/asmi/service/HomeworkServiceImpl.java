package ru.asmi.service;

import ru.asmi.dao.*;
import ru.asmi.pojo.Course;
import ru.asmi.pojo.Homework;
import ru.asmi.pojo.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class HomeworkServiceImpl implements HomeworkService {

    HomeworkDAO homeworkDAO = new HomeworkDAOImpl();

    @Override
    public ArrayList<Homework> getHomeworkList(Student student, Course course) throws SQLException, StudentNotFoundException, CourseNotFoundException {
        return homeworkDAO.getHomeworkList(student, course);
    }

    @Override
    public Homework getHomeworkById(int id) throws SQLException {
        return homeworkDAO.getHomeworkById(id);
    }

    @Override
    public boolean addHomework(Homework homework) throws SQLException, LectionNotFoundException, StudentNotFoundException {
        return homeworkDAO.addHomework(homework);
    }

    @Override
    public boolean delHomework(int id) throws SQLException {
        return homeworkDAO.delHomework(id);
    }

    @Override
    public boolean updateHomework(Homework homework) throws SQLException, LectionNotFoundException, StudentNotFoundException {
        return homeworkDAO.updateHomework(homework);
    }
}
