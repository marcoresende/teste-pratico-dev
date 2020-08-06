package com.github.marcoresende.testepraticodev.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.marcoresende.testepraticodev.external.ProjecaoIbgeService;
import com.github.marcoresende.testepraticodev.model.IbgeProjecao;
import com.github.marcoresende.testepraticodev.model.PopulacaoCalculada;

@Service
public class ProjecaoPopulacaoController {
	
	@Autowired
	private ProjecaoIbgeService projecaoIbgeService;
	
	public PopulacaoCalculada getProjecaoPopulacao(Date data) throws Exception {
		PopulacaoCalculada populacaoCalculada = null;
		IbgeProjecao ibgeProjecao = projecaoIbgeService.getProjecaoPopulacao();
		
		if(ibgeProjecao != null && ibgeProjecao.getProjecao() != null) {
			Integer populacaoProjetada = this.calculaPopulacao(ibgeProjecao.getHorario(), data, ibgeProjecao.getProjecao().getPopulacao(), ibgeProjecao.getProjecao().getPeriodoMedio().getIncrementoPopulacional());
			
			populacaoCalculada = new PopulacaoCalculada(ibgeProjecao.getHorario(), ibgeProjecao.getProjecao().getPopulacao(), data, populacaoProjetada);
		}
		
		return populacaoCalculada;
	}
	
	public Integer calculaPopulacao(Date dataAtual, Date dataProjecao, Integer populacaoAtual, Integer incrementoPopulacional) {
		Long diferencaDatas = dataProjecao.getTime() - dataAtual.getTime();
		
		Long quociente = diferencaDatas / incrementoPopulacional;
		
		return populacaoAtual + quociente.intValue();
	}

}
