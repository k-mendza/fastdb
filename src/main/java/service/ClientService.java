package service;

import domain.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class ClientService {

    private static Logger logger = LoggerFactory.getLogger(ClientService.class);
    public static final int BATCH_SIZE = 2048;
    public static final String SAVE_CLIENT_QUERY = "INSERT INTO client (id, firstName, lastName, email, phone) VALUES (?, ?, ?, ?, ?);";

    public static void saveClient(Client client) {
        try (Connection connection = DatabaseService.openConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CLIENT_QUERY);
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

    public static void saveClientList(List<Client> clientList) {
        int recordCount = 0;
        try (Connection connection = DatabaseService.openConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_CLIENT_QUERY);
            for (Client client : clientList) {
                preparedStatement.setLong(1, client.getId());
                preparedStatement.setString(2, client.getFirstName());
                preparedStatement.setString(3, client.getLastName());
                preparedStatement.setString(4, client.getEmail());
                preparedStatement.setString(5, client.getPhone());
                preparedStatement.addBatch();

                recordCount++;

                if (recordCount % BATCH_SIZE == 0) {
                    preparedStatement.executeBatch();
                }
            }
            preparedStatement.executeBatch();
            logger.info("Executed method saveClientList successfully");
        } catch (Exception e) {
            logger.error("Error while saving client list");
            logger.error(e.getMessage());
        }
    }
}
