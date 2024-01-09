package com.ping.homeschool.model;

import java.util.Date;

public class Message {
    private int messageId;
    private String sender;
    private String recipient;
    private int classId;
    private String messageTitle;
    private String messageContent;
    private Date sendTime;
    private short isRead;

    public Message() {
    }

    public Message(int messageId, String sender, String recipient, int classId, String messageTitle, String messageContent, Date sendTime, Short isRead) {
        this.messageId = messageId;
        this.sender = sender;
        this.recipient = recipient;
        this.classId = classId;
        this.messageTitle = messageTitle;
        this.messageContent = messageContent;
        this.sendTime = sendTime;
        this.isRead = isRead;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public short getIsRead() {
        return isRead;
    }

    public void setIsRead(short isRead) {
        this.isRead = isRead;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", classId=" + classId +
                ", messageTitle='" + messageTitle + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", sendTime=" + sendTime +
                ", isRead=" + isRead +
                '}';
    }
}
