package cn.edu.jxnu.rj.util;

import java.sql.*;

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
    ResultSet resultSet = null;
    PreparedStatement preparedStatement=null;


    public Jdbc() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询操作
     * @param sql 查询sql语句
     * @param args 查询参数
     * @return 返回结果集 ResultSet
     */
    public ResultSet executeQuery(String sql,Object...args){
        try {
            preparedStatement = con.prepareStatement(sql);
            int i = 1;
            //遍历参数，插入占位符
            for(Object obj :args){
                preparedStatement.setObject(i++,obj);
            }
            return preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
//            close();
        }
            return null;
    }
    public int executeUpdate(String sql,Object...args){
        try {
            preparedStatement = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            int i = 1;
            //遍历参数，插入占位符
            for(Object obj :args){
                preparedStatement.setObject(i++,obj);
            }
             preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();//获取刚刚插入记录的主键
            if(rs.next()){
                return rs.getInt(1);//返回主键
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return 0;
    }
    public void close(){
        try {
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
