package com.github.marcoresende.testepraticodev.web.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.github.marcoresende.testepraticodev.controller.PopulacaoController;
import com.github.marcoresende.testepraticodev.core.exception.BusinessException;
import com.github.marcoresende.testepraticodev.core.rest.AbstractResource;
import com.github.marcoresende.testepraticodev.core.rest.Message;
import com.github.marcoresende.testepraticodev.core.rest.Message.Severity;
import com.github.marcoresende.testepraticodev.model.dto.response.PopulacaoListResponse;
import com.github.marcoresende.testepraticodev.model.dto.response.PopulacaoResponse;

@Service
@Path("/populacao")
public class PopulacaoResource extends AbstractResource {
	
	@Autowired
	private PopulacaoController populacaoController;

	
	@GET
	@Path("/{dataHora}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response read(@PathParam("dataHora") String dataHora) {
		PopulacaoResponse response = new PopulacaoResponse();
		try {
			response = populacaoController.getProjecaoPopulacao(dataHora);
		} catch (BusinessException be) {
			response.addMessage(new Message(Severity.ERROR, be.getMessage()));
			return toRestResponse(response, Status.BAD_REQUEST);
		} catch (Exception e) {
			response.addMessage(new Message(Severity.ERROR, "Erro inesperado."));
			return toRestResponse(response, Status.INTERNAL_SERVER_ERROR);
		}
		
		return toRestResponse(response, Status.OK);

	}
	
	@GET
	@Path("/historico")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response list() {
		PopulacaoListResponse response = new PopulacaoListResponse();
		try {
			response = populacaoController.getHistoricoRequisicoes();
		} catch (Exception e) {
			response.addMessage(new Message(Severity.ERROR, "Erro inesperado."));
			return toRestResponse(response, Status.INTERNAL_SERVER_ERROR);
		}
		
		return toRestResponse(response, Status.OK);

	}
	
}
