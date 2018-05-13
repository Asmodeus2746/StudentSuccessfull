package ru.asmi.pojo;

public class Homework {
    private int id;
    private String homework;
    private int mark;
    private int lectionID;
    private int studentID;
    private Lection lection;
    private Student student;

    public Homework(int id, String homework, int mark, int lectionID, int studentID) {
        this.id = id;
        this.homework = homework;
        this.mark = mark;
        this.lectionID = lectionID;
        this.studentID = studentID;
    }

    public Homework(String homework, int mark, int lectionID, int studentID) {
        this.homework = homework;
        this.mark = mark;
        this.lectionID = lectionID;
        this.studentID = studentID;
    }

    public Homework(int id, String homework, int mark, int lectionID, int studentID, Lection lection, Student student) {
        this.id = id;
        this.homework = homework;
        this.mark = mark;
        this.lectionID = lectionID;
        this.studentID = studentID;
        this.lection = lection;
        this.student = student;
    }

    public Homework(String homework, int mark, int lectionID, int studentID, Lection lection, Student student) {
        this.homework = homework;
        this.mark = mark;
        this.lectionID = lectionID;
        this.studentID = studentID;
        this.lection = lection;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getLectionID() {
        return lectionID;
    }

    public void setLectionID(int lectionID) {
        this.lectionID = lectionID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public Lection getLection() {
        return lection;
    }

    public void setLection(Lection lection) {
        this.lection = lection;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
