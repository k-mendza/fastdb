import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.DatabaseService;

import java.sql.Connection;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Program start");
        try (Connection connection = DatabaseService.openConnection()) {
            DatabaseService.closeConnection(connection);
        } catch (Exception e) {
            logger.error("Error: ");
            logger.error(e.getMessage());
        }
        logger.info("Program stop");
    }
}
