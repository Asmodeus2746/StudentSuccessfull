package ru.asmi.service;

import org.apache.log4j.Logger;
import ru.asmi.dao.StudentDAO;
import ru.asmi.dao.StudentDAOImpl;
import ru.asmi.pojo.Student;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private final static Logger logger = Logger.getLogger(UserServiceImpl.class);
    private static StudentDAO studentDAO = new StudentDAOImpl();


    @Override
    public int registration(String email, String password, String name, String soname, int age) {

        Student student;

        if(email == null) return INVALID_EMAIL;
        if(password == null) return INVALID_PASSWORD;
        if(name == null) return INVALID_NAME;
        if(soname == null) return INVALID_SONAME;
        if(age < 1 || age > 120) return INVALID_AGE;

        try {
            student = studentDAO.getStudentByEmail(email);
        } catch (SQLException e) {
            logger.error(e.toString() + " was catch");
            return FAILED;
        }

        if(student == null) {
            student = new Student(name, soname, age, email, password, 0);
            try {
                studentDAO.addStudent(student);
                return SUCCESS;
            } catch (SQLException e) {
                logger.error(e.toString() + " was catch");
                return FAILED;
            }
        }
        else {
            return ALREADY_USED;
        }
    }

    @Override
    public Student auth(String email, String password) {

        Student student;

        if(email == null || password == null) return null;

        try {
            student = studentDAO.getStudentByEmail(email);
            return student;
        } catch (SQLException e) {
            logger.error(e.toString() + " was catch");
            return null;
        }
    }
}
