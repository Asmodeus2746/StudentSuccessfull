package ru.asmi.service;

import ru.asmi.dao.StudentDAO;
import ru.asmi.dao.StudentDAOImpl;
import ru.asmi.pojo.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {

    StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public ArrayList<Student> getStudents() throws SQLException {
        return studentDAO.getStudents();
    }

    @Override
    public Student getStudentById(int id) throws SQLException {
        return studentDAO.getStudentById(id);
    }

    @Override
    public boolean addStudent(Student student) throws SQLException {
        return studentDAO.addStudent(student);
    }

    @Override
    public boolean delStudent(int id) throws SQLException {
        return studentDAO.delStudent(id);
    }

    @Override
    public boolean delStudent(String name) throws SQLException {
        return studentDAO.delStudent(name);
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        return studentDAO.updateStudent(student);
    }
}
