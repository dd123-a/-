package com.ping.homeschool.model;

import java.util.Date;

public class ClassNotice {
    private int classNoticeId;
    private int classId;
    private String classNoticeAuthor;
    private String classNoticeTitle;
    private String classNoticeTheme;
    private String classNoticeContent;
    private Date classNoticeTime;

    public ClassNotice() {
    }

    public ClassNotice(int classNoticeId, int classId, String classNoticeAuthor, String classNoticeTitle, String classNoticeTheme, String classNoticeContent, Date classNoticeTime) {
        this.classNoticeId = classNoticeId;
        this.classId = classId;
        this.classNoticeAuthor = classNoticeAuthor;
        this.classNoticeTitle = classNoticeTitle;
        this.classNoticeTheme = classNoticeTheme;
        this.classNoticeContent = classNoticeContent;
        this.classNoticeTime = classNoticeTime;
    }

    public int getClassNoticeId() {
        return classNoticeId;
    }

    public void setClassNoticeId(int classNoticeId) {
        this.classNoticeId = classNoticeId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassNoticeAuthor() {
        return classNoticeAuthor;
    }

    public void setClassNoticeAuthor(String classNoticeAuthor) {
        this.classNoticeAuthor = classNoticeAuthor;
    }

    public String getClassNoticeTitle() {
        return classNoticeTitle;
    }

    public void setClassNoticeTitle(String classNoticeTitle) {
        this.classNoticeTitle = classNoticeTitle;
    }

    public String getClassNoticeTheme() {
        return classNoticeTheme;
    }

    public void setClassNoticeTheme(String classNoticeTheme) {
        this.classNoticeTheme = classNoticeTheme;
    }

    public String getClassNoticeContent() {
        return classNoticeContent;
    }

    public void setClassNoticeContent(String classNoticeContent) {
        this.classNoticeContent = classNoticeContent;
    }

    public Date getClassNoticeTime() {
        return classNoticeTime;
    }

    public void setClassNoticeTime(Date classNoticeTime) {
        this.classNoticeTime = classNoticeTime;
    }

    @Override
    public String toString() {
        return "ClassNotice{" +
                "classNoticeId=" + classNoticeId +
                ", classId=" + classId +
                ", classNoticeAuthor='" + classNoticeAuthor + '\'' +
                ", classNoticeTitle='" + classNoticeTitle + '\'' +
                ", classNoticeTheme='" + classNoticeTheme + '\'' +
                ", classNoticeContent='" + classNoticeContent + '\'' +
                ", classNoticeTime=" + classNoticeTime +
                '}';
    }
}
