package com.wanglei.business.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class MyJdbc {

//    private static String driverClassName = "com.mysql.jdbc.Driver";
//    private static String url = "jdbc:mysql://127.0.0.1:3306/rice?characterEncoding=utf8&useSSL=false";
//    private static String username = "root";
//    private static String password = "xinxin946946";

    private static String driverClassName = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://10.36.125.151:5002/myshow_mis?characterEncoding=utf8&useSSL=false";
    private static String username = "myshow_mis";
    private static String password = "myshow_mis";

    private static List convertList(ResultSet rs) throws SQLException{
        List list = new ArrayList();
        ResultSetMetaData md = rs.getMetaData();//获取键名
        int columnCount = md.getColumnCount();//获取行的数量
        while (rs.next()) {
            Map rowData = new HashMap();//声明Map
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(md.getColumnName(i), rs.getObject(i));//获取键名及值
            }
            list.add(rowData);
        }
        return list;
    }

    public static void main(String[] args) {

        try {
            Class<?> mysqlClass = Class.forName(driverClassName);
            Properties properties = new Properties();
            properties.setProperty("user", username);
            properties.setProperty("password", password);
            Connection connection = DriverManager.getConnection(url, properties);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from Profession_Index ");
            ResultSet rs = preparedStatement.executeQuery();
            ResultSet resultSet1 = preparedStatement.executeQuery("select * from Profession_Index ");
            List list = MyJdbc.convertList(resultSet1);
            System.out.println(list.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
