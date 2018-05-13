package ru.asmi.pojo;

public class Lection {
    private int id;
    private String title;
    private String article;
    private String homework;
    private String presentation;
    private int courseID;
    private Course course;

    public Lection(int id, String title, String article, String homework, String presentation, int courseID) {
        this.id = id;
        this.title = title;
        this.article = article;
        this.homework = homework;
        this.presentation = presentation;
        this.courseID = courseID;
    }

    public Lection(String title, String article, String homework, String presentation, int courseID) {
        this.title = title;
        this.article = article;
        this.homework = homework;
        this.presentation = presentation;
        this.courseID = courseID;
    }

    public Lection(int id, String title, String article, String homework, String presentation, int courseID, Course course) {
        this.id = id;
        this.title = title;
        this.article = article;
        this.homework = homework;
        this.presentation = presentation;
        this.courseID = courseID;
        this.course = course;
    }

    public Lection(String title, String article, String homework, String presentation, int courseID, Course course) {
        this.title = title;
        this.article = article;
        this.homework = homework;
        this.presentation = presentation;
        this.courseID = courseID;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
