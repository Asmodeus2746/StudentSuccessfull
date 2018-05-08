package ru.asmi.pojo;

public class Course {
    private int id;
    private String title;
    private String annotation;

    public Course(int id, String title, String annotation) {
        this.id = id;
        this.title = title;
        this.annotation = annotation;
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

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }
}
