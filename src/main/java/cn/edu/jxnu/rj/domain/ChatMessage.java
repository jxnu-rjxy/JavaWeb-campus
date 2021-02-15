package cn.edu.jxnu.rj.domain;

import java.util.Date;

public class ChatMessage {
    private String name;
    private String content;
    private String time;

    public ChatMessage(String name, String content, String time) {
        this.name = name;
        this.content = content;
        this.time = time;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
