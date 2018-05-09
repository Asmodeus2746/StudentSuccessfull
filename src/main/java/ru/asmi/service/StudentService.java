package ru.asmi.service;

import ru.asmi.pojo.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentService {
    ArrayList<Student> getStudents() throws SQLException;
    Student getStudentById(int id) throws SQLException;
    boolean addStudent(Student student) throws SQLException;
    boolean delStudent(int id) throws SQLException;
    boolean delStudent(String name) throws SQLException;
    boolean updateStudent(Student student) throws SQLException;
}
