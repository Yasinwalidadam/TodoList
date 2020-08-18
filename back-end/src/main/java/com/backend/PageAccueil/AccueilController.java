package com.backend.PageAccueil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.PageAccueil.Bean.AcceueilBean;


//controler
@CrossOrigin(origins = "http://localhost:4200")
@RestController
// handl rest request
public class AccueilController {
	
//	@GetMapping(path = "/Acceuil")
//	public AcceueilBean hello()
//	{
//		//throw new RuntimeException("Some Error happend! Contact support at 00337676068584 ");
//		return new AcceueilBean(");
//			
//	}
	
	@GetMapping(path = "/Acceuil/{name}")
	public AcceueilBean hello(@PathVariable String name)
	{
		//throw new RuntimeException("Some Error happend! Contact support at 00337676068584 ");
		return new AcceueilBean(String.format("hello costimzeer dyalna, %s",name));
			
	}
}
