package com.example;


import java.sql.*;


/**
 * @ClassName MysqlALiYun
 * @Description That's the purpose of the class
 * @Author yin.zhh
 * @Date 2018-04-18 11:40
 * @Version v.1.0.0
 */
public class MysqlALiYun {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://47.106.137.210:3306/mydata","root","123456");
            System.out.println("远程Mysql连接测试：" + conn);

            PreparedStatement prepareStatement = conn.prepareStatement("select * from t_export_inventory where guid = ? ");

            prepareStatement.setString(1,"0E5DABAE187844E3939F5747827E280F");//0E5DABAE187844E3939F5747827E280F

            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("app_time = " + resultSet.getString("app_time"));
                System.out.println("logistics_no = " + resultSet.getString("logistics_no"));
            }

            conn.close();
            prepareStatement.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally{
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
