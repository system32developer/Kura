package com.system32.Kura.database;

import com.system32.Kura.utils.Color;
import com.system32.Kura.utils.Console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private Connection connection;

    public DatabaseManager(String host, int port, String database, String username, String password) throws ClassNotFoundException {
        try{
            synchronized (this) {
                if (connection != null && !connection.isClosed()) {
                    Console.sendLog("Database", "ERROR", "Already connected!");
                }

                Class.forName("com.mysql.cj.jdbc.Driver");
                this.connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
                Console.sendLog("Database", "INFO", "Database connected!");
            }
        } catch (SQLException | ClassNotFoundException e) {
            Console.sendLog("Database", "ERROR", "Error trying to connect!");
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
