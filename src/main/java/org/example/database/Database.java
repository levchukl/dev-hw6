package org.example.database;

import org.example.prefs.Prefs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final Database INSTANCE = new Database();
    private Connection connection;
    private Database() {
        try {
            String connectionUrl = new Prefs().getPref(Prefs.DB_JDBC_CONNECTION_URL);
            connection = DriverManager.getConnection(connectionUrl);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Database getInstance(){
        return INSTANCE;
    }
    public Connection getConnection(){
        try {
            if (connection.isClosed()){
                String connectionUrl = new Prefs().getPref(Prefs.DB_JDBC_CONNECTION_URL);
                connection = DriverManager.getConnection(connectionUrl);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
