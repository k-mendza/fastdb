import domain.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ClientService;

import java.util.List;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Program start");
        try {
            List<Client> clientList = ClientService.getClientListFromCSVFile();
            ClientService.saveClientList(clientList);
        } catch (Exception e) {
            logger.error("Error: ");
            logger.error(e.getMessage());
        }
        logger.info("Program stop");
    }
}
