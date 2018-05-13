package ru.asmi.service;

public interface UserService {

    int FAILED = -1;
    int SUCCESS = 0;
    int ALREADY_USED = 1;
    int INVALID_DATA = 2;

    int registration(String email, String password, String name, String soname, int age);
}
