package ru.asmi.service;

import ru.asmi.dao.CourseNotFoundException;
import ru.asmi.dao.LectionDAO;
import ru.asmi.dao.LectionDAOImpl;
import ru.asmi.pojo.Course;
import ru.asmi.pojo.Lection;

import java.sql.SQLException;
import java.util.ArrayList;

public class LectionServiceImpl implements LectionService {

    LectionDAO lectionDAO = new LectionDAOImpl();

    @Override
    public ArrayList<Lection> getLectionByCourse(Course course) throws SQLException {
        return lectionDAO.getLectionByCourse(course);
    }

    @Override
    public ArrayList<Lection> getLectionByCourse(String courseName) throws SQLException {
        return lectionDAO.getLectionByCourse(courseName);
    }

    @Override
    public Lection getLectionById(int id) throws SQLException {
        return lectionDAO.getLectionById(id);
    }

    @Override
    public boolean addLection(Lection lection) throws SQLException, CourseNotFoundException {
        return lectionDAO.addLection(lection);
    }

    @Override
    public boolean delLection(int id) throws SQLException {
        return lectionDAO.delLection(id);
    }

    @Override
    public boolean updateLection(Lection lection) throws SQLException, CourseNotFoundException {
        return lectionDAO.updateLection(lection);
    }
}
