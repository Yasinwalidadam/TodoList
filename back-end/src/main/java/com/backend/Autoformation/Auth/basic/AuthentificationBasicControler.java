package com.backend.Autoformation.Auth.basic;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.PageAccueil.Bean.MessageTransmis;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthentificationBasicControler {

	@GetMapping(path = "/AuthBasic")
	public MessageTransmis hello()
	{
		return new MessageTransmis("Bonjour");
			
	}
	
	
}
