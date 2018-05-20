package ru.asmi.pojo;

public class Student {
    private int id;
    private String name;
    private String soname;
    private int age;
    private String email;
    private String password;
    private int seqLevel;

    public Student(int id, String name, String soname, int age, String email, String password, int seqLevel) {
        this.id = id;
        this.name = name;
        this.soname = soname;
        this.age = age;
        this.email = email;
        this.password = password;
        this.seqLevel = seqLevel;
    }

    public Student(String name, String soname, int age, String email, String password, int seqLevel) {
        this.name = name;
        this.soname = soname;
        this.age = age;
        this.email = email;
        this.password = password;
        this.seqLevel = seqLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoname() {
        return soname;
    }

    public void setSoname(String soname) {
        this.soname = soname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public  String getEmail() { return  email; }

    public void setEmail(String email) {this.email = email;}

    public  String getPassword() { return  password; }

    public void setPassword(String password) {this.password = password;}

    public int getSeqLevel() { return seqLevel; }

    public void setSeqLevel(int seqLevel) { this.seqLevel = seqLevel; }
}
