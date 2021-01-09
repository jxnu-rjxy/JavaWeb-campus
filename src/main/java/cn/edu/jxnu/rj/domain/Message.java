package cn.edu.jxnu.rj.domain;

import java.util.Date;

public class Message {
    private int message_id;
    private int user_id1;
    private int user_id2;
    private int message_type;
    private String message_content;
    private Date gmt_creat;

    public Message(int message_id, int user_id1, int user_id2, int message_type, String message_content, Date gmt_creat) {
        this.message_id = message_id;
        this.user_id1 = user_id1;
        this.user_id2 = user_id2;
        this.message_type = message_type;
        this.message_content = message_content;
        this.gmt_creat = gmt_creat;
    }

    public Message( int user_id1, int user_id2,int message_type, String messageContent) {
        this.message_id=message_id;
        this.message_type=message_type;
        this.user_id1=user_id1;
        this.user_id2=user_id2;
        this.message_content=messageContent;
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
    public void setGmt_creat(Date gmt_creat) {
        this.gmt_creat = gmt_creat;
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
