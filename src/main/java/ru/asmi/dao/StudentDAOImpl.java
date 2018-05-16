package ru.asmi.dao;

import ru.asmi.ConnectionManager.ConnectionManager;
import ru.asmi.ConnectionManager.ConnectionManagerJDBC;
import ru.asmi.Exceptions.InputDataNotFoundException;
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
                    resultSet.getInt("age"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getInt("seqLevel")));
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
                    resultSet.getInt("age"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getInt("seqLevel"));
        }
        connection.close();
        return student;
    }

    @Override
    public Student getStudentByEmail(String email) throws SQLException {
        if(email == null) throw new InputDataNotFoundException();

        Student student = null;
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Students WHERE email = ?");
        statement.setString(1, email);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()) {
            student = new Student(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("soname"),
                    resultSet.getInt("age"),
                    resultSet.getString("email"),
                    resultSet.getString("password"),
                    resultSet.getInt("seqLevel"));
        }
        connection.close();
        return student;
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        if(student == null) throw new InputDataNotFoundException();

        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Students (name, soname, age, email, password, seqLevel) VALUES (?, ?, ?, ?, ?, ?)");
        statement.setString(1, student.getName());
        statement.setString(2, student.getSoname());
        statement.setInt(3, student.getAge());
        statement.setString(4, student.getEmail());
        statement.setString(5, student.getPassword());
        statement.setInt(6, student.getSeqLevel());
        statement.execute();
        connection.close();
    }

    @Override
    public void delStudent(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Students WHERE id = ?");
        statement.setInt(1, id);
        statement.execute();
        connection.close();
    }

    @Override
    public void delStudent(String name) throws SQLException {
        if(name == null) throw new InputDataNotFoundException();

        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Students WHERE name = ?");
        statement.setString(1, name);
        statement.execute();
        connection.close();
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        if(student == null) throw new InputDataNotFoundException();

        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE Students SET name = ?, soname = ?, age = ?, email = ?, password = ?, seqLevel = ? WHERE id = ? ");
        statement.setString(1, student.getName());
        statement.setString(2, student.getSoname());
        statement.setInt(3, student.getAge());
        statement.setString(4, student.getEmail());
        statement.setString(5, student.getPassword());
        statement.setInt(6, student.getSeqLevel());
        statement.setInt(7, student.getId());
        statement.execute();
        connection.close();
    }
}
