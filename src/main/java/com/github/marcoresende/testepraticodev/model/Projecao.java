package com.github.marcoresende.testepraticodev.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "populacao", "periodoMedio" })
public class Projecao {

	@JsonProperty("populacao")
	private Integer populacao;
	@JsonProperty("periodoMedio")
	private PeriodoMedio periodoMedio;

	@JsonProperty("populacao")
	public Integer getPopulacao() {
		return populacao;
	}

	@JsonProperty("populacao")
	public void setPopulacao(Integer populacao) {
		this.populacao = populacao;
	}

	@JsonProperty("periodoMedio")
	public PeriodoMedio getPeriodoMedio() {
		return periodoMedio;
	}

	@JsonProperty("periodoMedio")
	public void setPeriodoMedio(PeriodoMedio periodoMedio) {
		this.periodoMedio = periodoMedio;
	}

}