package cn.edu.jxnu.rj.domain;

import java.sql.Timestamp;

public class Message {
    private int messageId;
    private int userId1;
    private int userId2;
    private int messageType;
    private String messageContent;
    private Timestamp gmtCreat;
    private int messageLinkId;
    private int messageLinkType;
    private String userName1;
    private String userName2;
    private Object object;//关联的作品

    public Object getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", userId1=" + userId1 +
                ", userId2=" + userId2 +
                ", messageType=" + messageType +
                ", messageContent='" + messageContent + '\'' +
                ", gmtCreat=" + gmtCreat +
                ", messageLinkId=" + messageLinkId +
                ", messageLinkType=" + messageLinkType +
                ", userName1='" + userName1 + '\'' +
                ", userName2='" + userName2 + '\'' +
                ", object=" + object +
                '}';
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Message() {
    }

    public Message(int messageId, int userId1, int userId2, int messageType, String messageContent, Timestamp gmtCreat, int messageLinkId, int messageLinkType, String userName1, String userName2) {
        this.messageId = messageId;
        this.userId1 = userId1;
        this.userId2 = userId2;
        this.messageType = messageType;
        this.messageContent = messageContent;
        this.gmtCreat = gmtCreat;
        this.messageLinkId = messageLinkId;
        this.messageLinkType = messageLinkType;
        this.userName1 = userName1;
        this.userName2 = userName2;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public int getUserId1() {
        return userId1;
    }

    public void setUserId1(int userId1) {
        this.userId1 = userId1;
    }

    public int getUserId2() {
        return userId2;
    }

    public void setUserId2(int userId2) {
        this.userId2 = userId2;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Timestamp getGmtCreat() {
        return gmtCreat;
    }

    public void setGmtCreat(Timestamp gmtCreat) {
        this.gmtCreat = gmtCreat;
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

    public String getUserName1() {
        return userName1;
    }

    public void setUserName1(String userName1) {
        this.userName1 = userName1;
    }

    public String getUserName2() {
        return userName2;
    }

    public void setUserName2(String userName2) {
        this.userName2 = userName2;
    }

    public Message(int userId1, int userId2, int messageType, String messageContent, int messageLinkId, int messageLinkType, String userName1, String userName2) {
        this.userId1 = userId1;
        this.userId2 = userId2;
        this.messageType = messageType;
        this.messageContent = messageContent;
        this.messageLinkId = messageLinkId;
        this.messageLinkType = messageLinkType;
        this.userName1 = userName1;
        this.userName2 = userName2;
    }
}
