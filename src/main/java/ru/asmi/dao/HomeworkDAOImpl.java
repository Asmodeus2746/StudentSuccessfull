package ru.asmi.dao;

import ru.asmi.ConnectionManager.ConnectionManager;
import ru.asmi.ConnectionManager.ConnectionManagerJDBC;
import ru.asmi.pojo.Course;
import ru.asmi.pojo.Homework;
import ru.asmi.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HomeworkDAOImpl implements HomeworkDAO {

    private static ConnectionManager connectionManager = ConnectionManagerJDBC.getInstance();

    @Override
    public ArrayList<Homework> getHomeworkList(Student student, Course course) throws SQLException, StudentNotFoundException, CourseNotFoundException {
        ArrayList<Homework> homeworks = new ArrayList<>();

        if((new CourseDAOImpl()).getCourseById(course.getId()) == null) throw new CourseNotFoundException();
        if((new StudentDAOImpl()).getStudentById(student.getId()) == null) throw new StudentNotFoundException();

        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Homework WHERE studentId = ? AND lectionID IN (SELECT lectionID FROM courses WHERE id = ? )");
        statement.setInt(1, student.getId());
        statement.setInt(2, course.getId());
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            homeworks.add(new Homework(resultSet.getInt("id"),
                    resultSet.getString("homework"),
                    resultSet.getInt("mark"),
                    resultSet.getInt("studentID"),
                    resultSet.getInt("lectionID")));
        }
        connection.close();
        return homeworks;
    }

    @Override
    public Homework getHomeworkById(int id) throws SQLException {
        Homework homework = null;
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM Homework WHERE id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if(resultSet.next()) {
            homework = new Homework(resultSet.getInt("id"),
                    resultSet.getString("homework"),
                    resultSet.getInt("mark"),
                    resultSet.getInt("studentID"),
                    resultSet.getInt("lectionID"));
        }
        connection.close();
        return homework;
    }

    @Override
    public void addHomework(Homework homework) throws SQLException, LectionNotFoundException, StudentNotFoundException {
        if((new LectionDAOImpl()).getLectionById(homework.getLectionID()) == null) throw new LectionNotFoundException();
        if((new StudentDAOImpl()).getStudentById(homework.getStudentID()) == null) throw new StudentNotFoundException();

        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO Homeworks (studentID, lectionID, homework, mark) VALUES (?, ?, ?, ?)");
        statement.setInt(1, homework.getStudentID());
        statement.setInt(2, homework.getLectionID());
        statement.setString(3, homework.getHomework());
        statement.setInt(4, homework.getMark());
        statement.execute();
        connection.close();
    }

    @Override
    public void delHomework(int id) throws SQLException {
        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM Homeworks WHERE id = ?");
        statement.setInt(1, id);
        statement.execute();
        connection.close();
    }

    @Override
    public void updateHomework(Homework homework) throws SQLException, LectionNotFoundException, StudentNotFoundException {
        if((new LectionDAOImpl()).getLectionById(homework.getLectionID()) == null) throw new LectionNotFoundException();
        if((new StudentDAOImpl()).getStudentById(homework.getStudentID()) == null) throw new StudentNotFoundException();

        Connection connection = connectionManager.getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE Homeworks SET studentID = ?, lectionID = ?, homework = ?, mark = ? WHERE id = ? ");
        statement.setInt(1, homework.getStudentID());
        statement.setInt(2, homework.getLectionID());
        statement.setString(3, homework.getHomework());
        statement.setInt(4, homework.getMark());
        statement.setInt(5, homework.getId());
        statement.execute();
        connection.close();
    }
}
