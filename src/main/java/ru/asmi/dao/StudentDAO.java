package ru.asmi.dao;

import ru.asmi.pojo.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentDAO {
    ArrayList<Student> getStudents() throws SQLException;
    Student getStudentById(int id) throws SQLException;
    Student getStudentByEmail(String email) throws SQLException;
    void addStudent(Student student) throws SQLException;
    void delStudent(int id) throws SQLException;
    void delStudent(String name) throws SQLException;
    void updateStudent(Student student) throws SQLException;
}
