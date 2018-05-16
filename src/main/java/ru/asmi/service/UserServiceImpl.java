package ru.asmi.service;

import org.apache.log4j.Logger;
import ru.asmi.Enumerations.RegistationRet;
import ru.asmi.dao.StudentDAO;
import ru.asmi.dao.StudentDAOImpl;
import ru.asmi.pojo.Student;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private final static Logger logger = Logger.getLogger(UserServiceImpl.class);
    private static StudentDAO studentDAO = new StudentDAOImpl();


    @Override
    public RegistationRet registration(String email, String password, String name, String soname, int age) {

        Student student;

        if(email == null) return RegistationRet.INVALID_EMAIL;
        if(password == null) return RegistationRet.INVALID_PASSWORD;
        if(name == null) return RegistationRet.INVALID_NAME;
        if(soname == null) return RegistationRet.INVALID_SONAME;
        if(age < 1 || age > 120) return RegistationRet.INVALID_AGE;

        try {
            student = studentDAO.getStudentByEmail(email);
        } catch (SQLException e) {
            logger.error(e.toString() + " was catch");
            return RegistationRet.FAILED;
        }

        if(student == null) {
            student = new Student(name, soname, age, email, password, 0);
            try {
                studentDAO.addStudent(student);
                return RegistationRet.SUCCESS;
            } catch (SQLException e) {
                logger.error(e.toString() + " was catch");
                return RegistationRet.FAILED;
            }
        }
        else {
            return RegistationRet.ALREADY_USED;
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
