package br.com.doacoesapp.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.doacoesapp.models.Doacao;
import br.com.doacoesapp.models.Doador;
import br.com.doacoesapp.repository.DoacaoRepository;
import br.com.doacoesapp.repository.RepositoryDoador;

@Controller
public class DoacaoController {
	
	@Autowired
	private DoacaoRepository dr;
	
	@Autowired
	private RepositoryDoador rd;
	
	@RequestMapping(value="/cadastrarDoacao", method=RequestMethod.GET)
	public String form() {
		return "doacao/formDoacao";
	}
	
	@RequestMapping(value="/cadastrarDoacao", method=RequestMethod.POST)
	public String form(@Valid Doacao doacao, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarDoacao";
		}
		
		dr.save(doacao);
		attributes.addFlashAttribute("mensagem", "Doacao cadastrado com sucesso!");
		return "redirect:/cadastrarDoacao";
	}
	
	@RequestMapping("/doacoes")
	public ModelAndView listaDoacoes() {
		ModelAndView mv = new ModelAndView("index");
		
		Iterable<Doacao> doacoes = dr.findAll();
		mv.addObject("doacoes", doacoes);
		
		return mv;
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesDoacao(@PathVariable("codigo") long codigo) {
		Doacao doacao = dr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("doacao/detalhesDoacao");
		mv.addObject("doacao", doacao);
		
		Iterable<Doador> doadores = rd.findByDoacao(doacao);
		mv.addObject("doadores", doadores);
		
		return mv;
	}
	
	@RequestMapping("/deletarDoacao")
	public String deletarDoacao (long codigo) {
		Doacao doacao = dr.findByCodigo(codigo);
		dr.delete(doacao);
		return "redirect:/doacoes";
	}
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.POST)
	public String detalhesDoacaoPost(@PathVariable("codigo") long codigo, @Valid Doador doador,  BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{codigo}";
		}
		Doacao doacao = dr.findByCodigo(codigo);
		doador.setDoacao(doacao);
		rd.save(doador);
		attributes.addFlashAttribute("mensagem", "Doador adicionado com sucesso!");
		return "redirect:/{codigo}";
	}
	
	@RequestMapping("/deletarDoador")
	public String deletarDoador (String rg) {
		Doador doador = rd.findByRg(rg);
		rd.delete(doador);
		
		Doacao doacao = doador.getDoacao();
		long codigoLong = doacao.getCodigo();
		String codigo = "" + codigoLong;
		return "redirect:/" + codigo;
	}
}
