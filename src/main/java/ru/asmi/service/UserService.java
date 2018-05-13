package ru.asmi.service;

import ru.asmi.pojo.Student;

public interface UserService {

    int FAILED = -1;
    int SUCCESS = 0;
    int ALREADY_USED = 1;
    int INVALID_EMAIL = 2;
    int INVALID_PASSWORD = 3;
    int INVALID_NAME = 4;
    int INVALID_SONAME = 5;
    int INVALID_AGE = 6;

    int registration(String email, String password, String name, String soname, int age);
    Student auth(String email, String password);
}
