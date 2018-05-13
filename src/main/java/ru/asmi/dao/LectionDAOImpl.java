package ru.asmi.dao;

import ru.asmi.ConnectionManager.ConnectionManager;
import ru.asmi.ConnectionManager.ConnectionManagerJDBC;
import ru.asmi.pojo.Course;
import ru.asmi.pojo.Lection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LectionDAOImpl implements LectionDAO {

    private static ConnectionManager connectionManager = ConnectionManagerJDBC.getInstance();

    @Override
    public ArrayList<Lection> getLectionByCourse(Course course) throws SQLException {
        ArrayList<Lection> lections = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Lections WHERE courseID = ?");
        statement.setInt(1, course.getId());
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            lections.add(new Lection(resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("article"),
                    resultSet.getString("homework"),
                    resultSet.getString("presentation"),
                    resultSet.getInt("courseID")));
        }
        connection.close();
        return lections;
    }

    @Override
    public ArrayList<Lection> getLectionByCourse(String courseName) throws SQLException {
        ArrayList<Lection> lections = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Lections WHERE courseID IN (SELECT id FROM courses WHERE name = ?)");
        statement.setString(1, courseName);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            lections.add(new Lection(resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("article"),
                    resultSet.getString("homework"),
                    resultSet.getString("presentation"),
                    resultSet.getInt("courseID")));
        }
        connection.close();
        return lections;
    }

    @Override
    public Lection getLectionById(int id) throws SQLException {
        Lection lection = null;
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Lections WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()) {
            lection = new Lection(resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("article"),
                    resultSet.getString("homework"),
                    resultSet.getString("presentation"),
                    resultSet.getInt("courseID"));
        }
        connection.close();
        return lection;
    }

    @Override
    public void addLection(Lection lection) throws SQLException, CourseNotFoundException {
        if((new CourseDAOImpl()).getCourseById(lection.getCourseID()) == null) throw new CourseNotFoundException();

        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Lections (title, article, homework, presentation, courseID) VALUES (?, ?, ?, ?, ?)");
        statement.setString(1, lection.getTitle());
        statement.setString(2, lection.getArticle());
        statement.setString(3, lection.getHomework());
        statement.setString(4, lection.getPresentation());
        statement.setInt(5, lection.getCourseID());
        statement.execute();
        connection.close();
    }

    @Override
    public void delLection(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Lections WHERE id = ?");
        statement.setInt(1, id);
        statement.execute();
        connection.close();
    }

    @Override
    public void updateLection(Lection lection) throws SQLException, CourseNotFoundException {
        if((new CourseDAOImpl()).getCourseById(lection.getCourseID()) == null) throw new CourseNotFoundException();

        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE Lections SET title = ?, article = ?, homework = ?, presentation = ?, courseID = ? WHERE id = ? ");
        statement.setString(1, lection.getTitle());
        statement.setString(2, lection.getArticle());
        statement.setString(3, lection.getHomework());
        statement.setString(4, lection.getPresentation());
        statement.setInt(5, lection.getCourseID());
        statement.setInt(6, lection.getId());
        statement.execute();
        connection.close();
    }
}
