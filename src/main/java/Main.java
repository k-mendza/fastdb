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
            Client client = new Client();
            client.setId(1L);
            client.setFirstName("Bob");
            client.setLastName("Kowalsky");
            client.setEmail("mail@mail.com");
            client.setPhone("111222333");

            Client client2 = new Client();
            client2.setId(2L);
            client2.setFirstName("John");
            client2.setLastName("Smith");
            client2.setEmail("cl2@cl2.com");
            client2.setPhone("333222111");

            ClientService.saveClientList(List.of(client, client2));

        } catch (Exception e) {
            logger.error("Error: ");
            logger.error(e.getMessage());
        }
        logger.info("Program stop");
    }
}
