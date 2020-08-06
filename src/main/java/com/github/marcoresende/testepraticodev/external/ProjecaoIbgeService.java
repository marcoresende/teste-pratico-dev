package com.github.marcoresende.testepraticodev.external;

import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.marcoresende.testepraticodev.model.IbgeProjecao;
import com.github.marcoresende.testepraticodev.util.Constants;

@Service
public class ProjecaoIbgeService extends RestService {
	
	private static final Logger LOG = LogManager.getFormatterLogger(ProjecaoIbgeService.class);
	
	@Autowired
    private Environment env;	
	
	public IbgeProjecao getProjecaoPopulacao() throws Exception {
		try {
			IbgeProjecao response = null;
			String template = env.getProperty(Constants.URL_API_IBGE_PROPERTY, Constants.URL_API_IBGE_VALUE_DEFAULT);

			URL url =  new URL(template);
			ResponseEntity<IbgeProjecao> httpResponse = getRestTemplate(false).exchange(url.toString(), HttpMethod.GET, null, IbgeProjecao.class);

			LOG.info("Realizando requisição ao serviço: %s", template);
			if(httpResponse.getStatusCode().equals(HttpStatus.OK) && httpResponse.hasBody()) {
				response = httpResponse.getBody();
			} else {
				LOG.error("Erro ao consultar serviço: Status: " + httpResponse.getStatusCodeValue());
				throw new Exception("Erro ao consultar serviço: Status: " + httpResponse.getStatusCodeValue());
			}
			
			return response;
		} catch (Exception e) {
			LOG.error(e);
			throw new Exception("Erro ao consultar serviço!", e);
		}
	}
	

}
