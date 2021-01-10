package cn.edu.jxnu.rj.domain;

import java.sql.Timestamp;
import java.util.Date;

public class Message {
    private int message_id;
    private int user_id1;
    private int user_id2;
    private int message_type;
    private String message_content;
    private Timestamp gmt_creat;
    private int messageLinkId;
    private int messageLinkType;


    public Message() {
    }

    public Message(int user_id1, int user_id2, int message_type, String message_content, int messageLinkId, int messageLinkType) {
        this.user_id1 = user_id1;
        this.user_id2 = user_id2;
        this.message_type = message_type;
        this.message_content = message_content;
        this.messageLinkId = messageLinkId;
        this.messageLinkType = messageLinkType;
    }

    public Message(int message_id, int user_id1, int user_id2, int message_type, String message_content, Timestamp gmt_creat, int messageLinkId, int messageLinkType) {
        this.message_id = message_id;
        this.user_id1 = user_id1;
        this.user_id2 = user_id2;
        this.message_type = message_type;
        this.message_content = message_content;
        this.gmt_creat = gmt_creat;
        this.messageLinkId = messageLinkId;
        this.messageLinkType = messageLinkType;
    }

    public void setGmt_creat(Timestamp gmt_creat) {
        this.gmt_creat = gmt_creat;
    }

    public int getMessageLinkId() {
        return messageLinkId;
    }

    public void setMessageLinkId(int messageLinkId) {
        this.messageLinkId = messageLinkId;
    }

    public int getMessageLinkType() {
        return messageLinkType;
    }

    public void setMessageLinkType(int messageLinkType) {
        this.messageLinkType = messageLinkType;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message_id=" + message_id +
                ", user_id1=" + user_id1 +
                ", user_id2=" + user_id2 +
                ", message_type=" + message_type +
                ", message_content='" + message_content + '\'' +
                ", gmt_creat=" + gmt_creat +
                ", messageLinkId=" + messageLinkId +
                ", messageLinkType=" + messageLinkType +
                '}';
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }
    public void setUser_id1(int user_id1) {
        this.user_id1 = user_id1;
    }
    public void setUser_id2(int user_id2) {
        this.user_id2 = user_id2;
    }
    public void setMessage_type(int message_type) {
        this.message_type = message_type;
    }
    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }
    public int getMessage_id() {
        return message_id;
    }
    public int getUser_id1() {
        return user_id1;
    }
    public int getUser_id2() {
        return user_id2;
    }
    public int getMessage_type() {
        return message_type;
    }
    public String getMessage_content() {
        return message_content;
    }
    public Date getGmt_creat() {
        return gmt_creat;
    }
}
