package ru.asmi.dao;

import ru.asmi.ConnectionManager.ConnectionManager;
import ru.asmi.ConnectionManager.ConnectionManagerJDBC;
import ru.asmi.Exceptions.InputDataNotFoundException;
import ru.asmi.pojo.Course;

import java.sql.*;
import java.util.ArrayList;

public class CourseDAOImpl implements CourseDAO {

    private static ConnectionManager connectionManager = ConnectionManagerJDBC.getInstance();

    @Override
    public ArrayList<Course> getCourses() throws SQLException {
        ArrayList<Course> courses = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Courses");
        while (resultSet.next()) {
            courses.add(new Course(resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("annotation")));
        }
        connection.close();
        return courses;
    }

    @Override
    public Course getCourseById(int id) throws SQLException {
        Course course = null;
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Courses WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()) {
            course = new Course(resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("annotation"));
        }
        connection.close();
        return course;
    }

    @Override
    public void addCourse(Course course) throws SQLException {
        if(course == null) throw new InputDataNotFoundException();

        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Courses (title, annotation) VALUES (?, ?)");
        statement.setString(1, course.getTitle());
        statement.setString(2, course.getAnnotation());
        statement.execute();
        connection.close();
    }

    @Override
    public void delCourse(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Courses WHERE id = ?");
        statement.setInt(1, id);
        statement.execute();
        connection.close();
    }

    @Override
    public void delCourse(String title) throws SQLException {
        if(title == null) throw new InputDataNotFoundException();

        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Courses WHERE name = ?");
        statement.setString(1, title);
        statement.execute();
        connection.close();
    }

    @Override
    public void updateCourse(Course course) throws SQLException {
        if(course == null) throw new InputDataNotFoundException();

        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE Courses SET title = ?, annotation = ? WHERE id = ? ");
        statement.setString(1, course.getTitle());
        statement.setString(2, course.getAnnotation());
        statement.setInt(3, course.getId());
        statement.execute();
        connection.close();
    }
}
