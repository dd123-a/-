package com.ping.homeschool.model;
import java.util.Date;
public class SystemNotice {
    private int systemNoticeId;
    private String systemNoticeTitle;
    private String systemNoticeAuthor;
    private String systemNoticeTheme;
    private String systemNoticeContent;
    private Date systemNoticeTime;
    private short deleteStatus;

    public SystemNotice() {
    }

    public SystemNotice(int systemNoticeId, String systemNoticeTitle, String systemNoticeAuthor, String systemNoticeTheme, String systemNoticeContent, Date systemNoticeTime, short deleteStatus) {
        this.systemNoticeId = systemNoticeId;
        this.systemNoticeTitle = systemNoticeTitle;
        this.systemNoticeAuthor = systemNoticeAuthor;
        this.systemNoticeTheme = systemNoticeTheme;
        this.systemNoticeContent = systemNoticeContent;
        this.systemNoticeTime = systemNoticeTime;
        this.deleteStatus = deleteStatus;
    }

    public int getSystemNoticeId() {
        return systemNoticeId;
    }

    public void setSystemNoticeId(int systemNoticeId) {
        this.systemNoticeId = systemNoticeId;
    }

    public String getSystemNoticeTitle() {
        return systemNoticeTitle;
    }

    public void setSystemNoticeTitle(String systemNoticeTitle) {
        this.systemNoticeTitle = systemNoticeTitle;
    }

    public String getSystemNoticeAuthor() {
        return systemNoticeAuthor;
    }

    public void setSystemNoticeAuthor(String systemNoticeAuthor) {
        this.systemNoticeAuthor = systemNoticeAuthor;
    }

    public String getSystemNoticeTheme() {
        return systemNoticeTheme;
    }

    public void setSystemNoticeTheme(String systemNoticeTheme) {
        this.systemNoticeTheme = systemNoticeTheme;
    }

    public String getSystemNoticeContent() {
        return systemNoticeContent;
    }

    public void setSystemNoticeContent(String systemNoticeContent) {
        this.systemNoticeContent = systemNoticeContent;
    }

    public Date getSystemNoticeTime() {
        return systemNoticeTime;
    }

    public void setSystemNoticeTime(Date systemNoticeTime) {
        this.systemNoticeTime = systemNoticeTime;
    }

    public short getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(short deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    @Override
    public String toString() {
        return "SystemNotice{" +
                "systemNoticeId=" + systemNoticeId +
                ", systemNoticeTitle='" + systemNoticeTitle + '\'' +
                ", systemNoticeAuthor='" + systemNoticeAuthor + '\'' +
                ", systemNoticeTheme='" + systemNoticeTheme + '\'' +
                ", systemNoticeContent='" + systemNoticeContent + '\'' +
                ", systemNoticeTime=" + systemNoticeTime +
                ", deleteStatus=" + deleteStatus +
                '}';
    }
}
