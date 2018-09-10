package com.cskaoyan.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Utils {
    static DataSource dataSource=null;
    static Connection connection=null;
    static {
        //ComboPooledDataSource("mysql")这个函数可以指定参数,这里指定mysql类型数据库,就去xml配置里面
        //找<named-config name="mysql">这个标签中name为mysql的的配置,表示连接的是这个数据库,如果
        //ComboPooledDataSource()不写参数,则去xml文件中找默认的数据库配置：<default-config>
        //只需要这一步就完成了数据库驱动,连接池的创建,现在只需要从连接池子里面拿出连接就行
        dataSource = new ComboPooledDataSource("mysql");
    }
    public static Connection getConnection()
    {
        try {
            connection=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void close()
    {
        try {
            if (connection!=null)
            {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static  DataSource getDataSource(){

        return  dataSource;
    }
}
