package cn.edu.jxnu.rj.domain;

public class Follow {
    private int user1;
    private int user2;
    private String remarkName;
    private String userName;
    private String school;
    private String signature;
    private String path;

    public Follow(int user1, int user2, String remarkName, String userName, String school, String signature, String path) {
        this.user1 = user1;
        this.user2 = user2;
        this.remarkName = remarkName;
        this.userName = userName;
        this.school = school;
        this.signature = signature;
        this.path = path;
    }

    public int getUser1() {
        return user1;
    }

    public void setUser1(int user1) {
        this.user1 = user1;
    }

    public int getUser2() {
        return user2;
    }

    public void setUser2(int user2) {
        this.user2 = user2;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
