import domain.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ClientService;

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
            ClientService.saveClient(client);
        } catch (Exception e) {
            logger.error("Error: ");
            logger.error(e.getMessage());
        }
        logger.info("Program stop");
    }
}
