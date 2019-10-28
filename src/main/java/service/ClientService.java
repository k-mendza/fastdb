package service;

import domain.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientService {

    private static Logger logger = LoggerFactory.getLogger(ClientService.class);

    public static void saveClient(Client client) {
        try (Connection connection = DatabaseService.openConnection()) {
            StringBuilder query = new StringBuilder();
            query.append("INSERT INTO client ");
            query.append("(id, firstName, lastName, email, phone) ");
            query.append("VALUES ");
            query.append("(?, ?, ?, ?, ?);");
            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());
            preparedStatement.setLong(1, client.getId());
            preparedStatement.setString(2, client.getFirstName());
            preparedStatement.setString(3, client.getLastName());
            preparedStatement.setString(4, client.getEmail());
            preparedStatement.setString(5, client.getPhone());
            preparedStatement.executeUpdate();
            logger.info("Executed method saveClient successfully");
        } catch (Exception e) {
            logger.error("Error while saving client");
            logger.error(e.getMessage());
        }
    }
}
