package ahmims.BasmaOnlineStore;

import ahmims.BasmaOnlineStore.dao.ClientDao;
import ahmims.BasmaOnlineStore.model.Client;
import ahmims.BasmaOnlineStore.security.Config;
import ahmims.BasmaOnlineStore.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.util.Date;

@SpringBootApplication
@Import(Config.class)
public class BasmaOnlineStoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(BasmaOnlineStoreApplication.class, args);
	}

}
