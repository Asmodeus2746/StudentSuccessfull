package ru.asmi.service;

import ru.asmi.Enumerations.RegistationRet;
import ru.asmi.pojo.Student;

public interface UserService {

    RegistationRet registration(String email, String password, String name, String soname, int age);
    Student auth(String email, String password);
}
