package service;

import config.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {

    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection(DatabaseConfig.getConnectionURL(), DatabaseConfig.DATABASE_USER, DatabaseConfig.DATABASE_PASSWORD);
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
