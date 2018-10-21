package br.com.doacoesapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.doacoesapp.models.Doacao;
import br.com.doacoesapp.repository.DoaçãoRepository;

@Controller
public class DoaçãoController {
	
	@Autowired
	private DoaçãoRepository dr;
	
	@RequestMapping(value="/cadastrarDoacao", method=RequestMethod.GET)
	public String form() {
		return "doacao/formDoacao";
	}
	
	@RequestMapping(value="/cadastrarDoacao", method=RequestMethod.POST)
	public String form(Doacao doacao) {
		
		dr.save(doacao);
		
		return "redirect:/cadastrarDoacao";
	}
	
}
