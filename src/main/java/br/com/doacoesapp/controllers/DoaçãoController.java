package br.com.doacoesapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DoaçãoController {
	
	@RequestMapping("/cadastrarDoação")
	public String form() {
		return "doação/formDoação";
	}
	
}
