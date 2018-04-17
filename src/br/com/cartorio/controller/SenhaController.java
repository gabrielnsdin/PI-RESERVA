package br.com.cartorio.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cartorio.entity.Senha;
import br.com.cartorio.entity.Servico;
import br.com.cartorio.service.SenhaService;
import br.com.cartorio.service.ServicoService;

@Transactional
@Controller
public class SenhaController {
	private SenhaService senhaService;
	private ServicoService servicoService;
	
	@Autowired
	public SenhaController(SenhaService senhaService, ServicoService servicoService) {
		this.senhaService = senhaService;
		this.servicoService = servicoService;
	}
	
	@RequestMapping("/painel")
	public String painel(Model model) {
		try {
			model.addAttribute("senhas", senhaService.listarSenhasPainel());
			return "Painel";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro";
		}
	}
	
	@RequestMapping("/inserir_senha")
	public String inserirSenha(@ModelAttribute Senha senha,Model model) {
		try {
			Servico servico  = servicoService.listarServico(senha.getServico().getId());
			senha.setServico(servico);
			int ultimoNumero = senhaService.ultimoNumeroByServico(servico); 
			senha.setNumero(ultimoNumero + 1);
			senhaService.inserirSenha(senha);
			return"index";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro";
		}
		
	}
	
	@RequestMapping("/carregar_formulario_senha")
	public String carregarForm(Model model) {
		try {
			Senha senha = new Senha();
			model.addAttribute("senha", senha);
			model.addAttribute("servicos", servicoService.listarServicos());
			return"FormSenha";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro";
		}
	}

}
