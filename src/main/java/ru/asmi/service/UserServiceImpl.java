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

    private boolean checkStudentExist(String email) throws SQLException {
        return studentDAO.getStudentByEmail(email) == null;
    }

    private boolean checkStudentPassword(String email, String password) throws SQLException {
        return studentDAO.getStudentByEmail(email).getPassword().equals(password);
    }


    @Override
    public RegistationRet registration(String email, String password, String name, String soname, int age) {
        if(email == null || email.isEmpty()) return RegistationRet.INVALID_EMAIL;
        if(password == null || password.isEmpty()) return RegistationRet.INVALID_PASSWORD;
        if(name == null || name.isEmpty()) return RegistationRet.INVALID_NAME;
        if(soname == null || soname.isEmpty()) return RegistationRet.INVALID_SONAME;
        if(age < 1 || age > 120) return RegistationRet.INVALID_AGE;


        Student student = new Student(name, soname, age, email, password, 0);
        try {
            if(!checkStudentExist(email)) return RegistationRet.ALREADY_USED;
            studentDAO.addStudent(student);
            return RegistationRet.SUCCESS;
        } catch (SQLException e) {
            logger.error(e.toString() + " was catch");
            return RegistationRet.FAILED;
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

    @Override
    public Student getStudentInformation(int id) {
        try {
            return studentDAO.getStudentById(id);
        } catch (SQLException e) {
            logger.error(e.toString() + " was catch");
            return null;
        }
    }

    @Override
    public RegistationRet updateUser(String email, String password, String name, String soname, int age) {
        if(email == null || email.isEmpty()) return RegistationRet.INVALID_EMAIL;
        if(password == null || password.isEmpty()) return RegistationRet.INVALID_PASSWORD;
        if(name == null || name.isEmpty()) return RegistationRet.INVALID_NAME;
        if(soname == null || soname.isEmpty()) return RegistationRet.INVALID_SONAME;
        if(age < 1 || age > 120) return RegistationRet.INVALID_AGE;


        Student student = new Student(name, soname, age, email, password, 0);
        try {
            if(checkStudentExist(email)) return RegistationRet.FAILED;
            if(!checkStudentPassword(email, password)) return RegistationRet.INVALID_PASSWORD;
            studentDAO.updateStudentByEmail(student);
            return RegistationRet.SUCCESS;
        } catch (SQLException e) {
            logger.error(e.toString() + " was catch");
            return RegistationRet.FAILED;
        }
    }
}
