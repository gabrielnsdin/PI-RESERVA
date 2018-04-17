package br.com.cartorio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cartorio.entity.Servico;
import br.com.cartorio.entity.SubServico;
import br.com.cartorio.service.AtendimentoService;
import br.com.cartorio.service.SenhaService;
import br.com.cartorio.service.ServicoService;
import br.com.cartorio.service.SubServicoService;

@RestController
public class AtendimentoRest {
	private ServicoService servicoService;
	private SenhaService senhaService;
	private SubServicoService subServicoService;
	private AtendimentoService atendimentoService;

	@Autowired
	public AtendimentoRest(ServicoService servicoService, SenhaService senhaService,
			SubServicoService subServicoService, AtendimentoService atendimentoService) {

		this.servicoService = servicoService;
		this.senhaService = senhaService;
		this.subServicoService = subServicoService;
		this.atendimentoService = atendimentoService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "rest/subServicoByServico/{id}")
	public @ResponseBody ArrayList<SubServico> listaSubServicoByServico(@PathVariable("id") int id) {
		List<SubServico> subServicos = null;
		try {
			Servico servico = servicoService.listarServico(id);
			subServicos = subServicoService.listarSubServicosByServico(servico);

			// return new ResponseEntity<List<SubServico>>(subServicos,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// return new
			// ResponseEntity<List<SubServico>>(subServicos,HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return (ArrayList<SubServico>) subServicos;
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.GET, value = "rest/Teste/{id}")
	public ResponseEntity<ArrayList<String>> teste(@PathVariable("id") int id){
		ArrayList<String> palavras = new ArrayList<>();
		palavras.add("ola");
		palavras.add("osda");
		palavras.add("olds");
		
		return new ResponseEntity<ArrayList<String>>((ArrayList<String>) palavras, HttpStatus.OK);
		
	}
	
	
	
	
	
	

}
