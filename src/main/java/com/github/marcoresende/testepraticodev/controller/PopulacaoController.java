package com.github.marcoresende.testepraticodev.controller;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.marcoresende.testepraticodev.core.exception.BusinessException;
import com.github.marcoresende.testepraticodev.core.rest.Message;
import com.github.marcoresende.testepraticodev.core.rest.Message.Severity;
import com.github.marcoresende.testepraticodev.model.PopulacaoCalculada;
import com.github.marcoresende.testepraticodev.model.dto.response.PopulacaoListResponse;
import com.github.marcoresende.testepraticodev.model.dto.response.PopulacaoResponse;
import com.github.marcoresende.testepraticodev.util.DateUtil;
import com.github.marcoresende.testepraticodev.util.HistoricoUtil;

@Service
public class PopulacaoController {
	
	private static final Logger LOG = LogManager.getFormatterLogger(PopulacaoController.class);
	
	@Autowired
	private ProjecaoPopulacaoController calculaProjecaoPopulacao;
	
	@Autowired
	HistoricoUtil historicoUtil;
	
	public PopulacaoResponse getProjecaoPopulacao(String dataHora) throws BusinessException, Exception {
		PopulacaoResponse response = null;
		Date dataProjecao = null;
		
        if (StringUtils.isNotBlank(dataHora)) {
        	dataProjecao = DateUtil.parseDate(dataHora, DateUtil.DATE_TIME_FORMAT_PATTERN_REST, TimeZone.getDefault());
            if (dataProjecao == null || dataProjecao.before(new Date())) {
            	throw new BusinessException("Parâmetro de data/hora informado é inválido.");
            }
        } else {
        	throw new BusinessException("Parâmetro de data/hora é obrigatório.");
        }
		
		try {
			LOG.info("Calculando projeção para a data: %s", dataProjecao);
			PopulacaoCalculada populacaoCalculada = calculaProjecaoPopulacao.getProjecaoPopulacao(dataProjecao);
			
			if(populacaoCalculada != null) {
				historicoUtil.addHistorico(populacaoCalculada);
				LOG.info("Data atual: %s; População atual: %s; Data projeção: %s; População projeção: %s",
						populacaoCalculada.getDataAtual(), populacaoCalculada.getPopulacaoAtual(), dataProjecao,
						populacaoCalculada.getPopulacaoProjetada());
			}
			
			response = new PopulacaoResponse();
			response.setValue(populacaoCalculada);
			
		} catch (Exception e) {
			LOG.error(e);
			throw e;
		}
		
		return response;
		
	}
	
	public PopulacaoListResponse getHistoricoRequisicoes() {
		PopulacaoListResponse response = new PopulacaoListResponse();
		
		List<PopulacaoCalculada> historicos = historicoUtil.getHistoricoList();
		if(historicos == null || historicos.isEmpty()) {
			response.addMessage(new Message(Severity.INFO, "Não foram encontrados registros."));
		}
		response.setValues(historicos);
		
		return response;
	}
}
