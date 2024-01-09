package com.ping.homeschool.model;

public class MyClass {
    private Integer classId;

    private String className;

    private Integer classAdviser;

    private String adviserName;

    private String classInfo;

    private Short classOver;

    private String classTop;

    public MyClass() {
    }

    public MyClass(Integer classId, String className, Integer classAdviser, String adviserName, String classInfo, Short classOver, String classTop) {
        this.classId = classId;
        this.className = className;
        this.classAdviser = classAdviser;
        this.adviserName = adviserName;
        this.classInfo = classInfo;
        this.classOver = classOver;
        this.classTop = classTop;
    }

    public String getAdviserName() {
        return adviserName;
    }

    public void setAdviserName(String adviserName) {
        this.adviserName = adviserName;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getClassAdviser() {
        return classAdviser;
    }

    public void setClassAdviser(Integer classAdviser) {
        this.classAdviser = classAdviser;
    }

    public String getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }

    public Short getClassOver() {
        return classOver;
    }

    public void setClassOver(Short classOver) {
        this.classOver = classOver;
    }

    public String getClassTop() {
        return classTop;
    }

    public void setClassTop(String classTop) {
        this.classTop = classTop;
    }
}
