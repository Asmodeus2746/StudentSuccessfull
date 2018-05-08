package ru.asmi.dao;

import ru.asmi.ConnectionManager.ConnectionManager;
import ru.asmi.ConnectionManager.ConnectionManagerJDBC;
import ru.asmi.pojo.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {

    private static ConnectionManager connectionManager = ConnectionManagerJDBC.getInstance();

    @Override
    public ArrayList<Student> getStudents() throws SQLException {
        ArrayList<Student> students = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Students");
        while (resultSet.next()) {
            students.add(new Student(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("soname"),
                    resultSet.getInt("age")));
        }
        connection.close();
        return students;
    }

    @Override
    public Student getStudentById(int id) throws SQLException {
        Student student = null;
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Students WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()) {
            student = new Student(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("soname"),
                    resultSet.getInt("age"));
        }
        connection.close();
        return student;
    }

    @Override
    public boolean addStudent(Student student) throws SQLException {
        boolean ret;
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Students (id, name, soname, age) VALUES (?, ?, ?, ?)");
        statement.setInt(1, student.getId());
        statement.setString(2, student.getName());
        statement.setString(3, student.getSoname());
        statement.setInt(4, student.getAge());
        ret = statement.execute();
        connection.close();
        return ret;
    }

    @Override
    public boolean delStudent(int id) throws SQLException {
        boolean ret;
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Students WHERE id = ?");
        statement.setInt(1, id);
        ret = statement.execute();
        connection.close();
        return ret;
    }

    @Override
    public boolean delStudent(String name) throws SQLException {
        boolean ret;
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Students WHERE name = ?");
        statement.setString(1, name);
        ret = statement.execute();
        connection.close();
        return ret;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        boolean ret;
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE Students SET name = ?, soname = ?, age = ? WHERE id = ? ");
        statement.setString(1, student.getName());
        statement.setString(2, student.getSoname());
        statement.setInt(3, student.getAge());
        statement.setInt(4, student.getId());
        ret = statement.execute();
        connection.close();
        return ret;
    }
}
