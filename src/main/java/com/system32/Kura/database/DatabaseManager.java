package com.system32.Kura.database;

import com.system32.Kura.utils.Color;
import com.system32.Kura.utils.Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private Connection connection;
    private String host;
    private int port;
    private String database;
    private String username;
    private String password;

    public DatabaseManager(String host, int port, String database, String username, String password) throws ClassNotFoundException {
        this.host = host;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
        try{
            synchronized (this) {
                if (connection != null && !connection.isClosed()) {
                    Console.sendCustomLog(Color.BLUE_BRIGHT, "DB", Color.RED , "Already connected!");
                }

                Class.forName("com.mysql.cj.jdbc.Driver");
                this.connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.username, this.password);
                Console.sendCustomLog(Color.BLUE_BRIGHT, "DB", Color.GREEN_BRIGHT, "Database connected!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            Console.sendCustomLog(Color.BLUE_BRIGHT, "DB", Color.RED, "Error trying to connect!");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
    public void closeConnection() throws SQLException {
        connection.close();
    }
}
