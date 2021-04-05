package ahmims.BasmaOnlineStore.controller;

import ahmims.BasmaOnlineStore.model.Client;
import ahmims.BasmaOnlineStore.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class Test {

	@Autowired
	private ClientService clientService;

	@GetMapping("/user")
	public String loginSuccess() {
		/*Client client = new Client("XX","XX","XX","XX",new Date(),"");
		client = clientService.save(client);
		return client.getIdUtilisateur();*/
		return "good";
	}

}
