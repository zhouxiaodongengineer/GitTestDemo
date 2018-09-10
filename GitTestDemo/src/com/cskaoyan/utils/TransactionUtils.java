package com.cskaoyan.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionUtils {
    static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();
    static {
            threadLocal.set(C3P0Utils.getConnection());
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = threadLocal.get();
        if(connection == null){
            threadLocal.set(C3P0Utils.getConnection());
        }
        return threadLocal.get();
    }

    public static void beganTransaction() throws SQLException {
        getConnection().setAutoCommit(false);
    }

    public static void commit() throws SQLException {
        getConnection().commit();
    }

    public static void rollback() throws SQLException {
        getConnection().rollback();
    }
}
