package br.com.doacoesapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.doacoesapp.models.Doacao;
import br.com.doacoesapp.repository.DoacaoRepository;

@Controller
public class DoacaoController {
	
	@Autowired
	private DoacaoRepository dr;
	
	@RequestMapping(value="/cadastrarDoacao", method=RequestMethod.GET)
	public String form() {
		return "doacao/formDoacao";
	}
	
	@RequestMapping(value="/cadastrarDoacao", method=RequestMethod.POST)
	public String form(Doacao doacao) {
		
		dr.save(doacao);
		
		return "redirect:/cadastrarDoacao";
	}
	
	@RequestMapping("/doacoes")
	public ModelAndView listaDoacoes() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Doacao> doacoes = dr.findAll();
		mv.addObject("doacoes", doacoes);
		return mv;
	}
	
	@RequestMapping("/{codigo}")
	public ModelAndView detalhesDoacao(@PathVariable("codigo") long codigo) {
		Doacao doacao = dr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("doacao/detalhesDoacao");
		mv.addObject("doacao", doacao);
		System.out.println("doacao" + doacao);
		return mv;
	}
	
}
