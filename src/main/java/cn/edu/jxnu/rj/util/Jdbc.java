package cn.edu.jxnu.rj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {
    //  mysql 驱动类
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    //  数据库登录用户名
    private static final String USER = "root";
    //  数据库登录密码
    private static final String PASSWORD = "12345";
    // 数据库连接地址
    private static final String URL = "jdbc:mysql://118.31.173.242:3306/campus?characterEncoding=utf8&useUnicode=true&useSSL=false&serverTimezone=GMT%2B8";

    Connection con = null;
    public Jdbc() {
    }

    public Connection getCon(){
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            return  con;
        }
    }
    //    public User
}
