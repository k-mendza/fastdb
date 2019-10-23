package service;

import config.DatabaseConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
    private static Logger logger = LoggerFactory.getLogger(DatabaseService.class);

    public static Connection openConnection() throws SQLException {
        return DriverManager.getConnection(DatabaseConfig.getConnectionURL(), DatabaseConfig.DATABASE_USER, DatabaseConfig.DATABASE_PASSWORD);
    }

    public static void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (Exception e) {
            logger.error("Error while closing connection to database");
            logger.error(e.getMessage());
        }

    }
}
