package com.github.marcoresende.testepraticodev.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "incrementoPopulacional", "nascimento", "obito" })
public class PeriodoMedio {

	@JsonProperty("incrementoPopulacional")
	private Integer incrementoPopulacional;
	
	@JsonProperty("nascimento")
	private Integer nascimento;
	
	@JsonProperty("obito")
	private Integer obito;

	@JsonProperty("incrementoPopulacional")
	public Integer getIncrementoPopulacional() {
		return incrementoPopulacional;
	}

	@JsonProperty("incrementoPopulacional")
	public void setIncrementoPopulacional(Integer incrementoPopulacional) {
		this.incrementoPopulacional = incrementoPopulacional;
	}

	@JsonProperty("nascimento")
	public Integer getNascimento() {
		return nascimento;
	}

	@JsonProperty("nascimento")
	public void setNascimento(Integer nascimento) {
		this.nascimento = nascimento;
	}

	@JsonProperty("obito")
	public Integer getObito() {
		return obito;
	}

	@JsonProperty("obito")
	public void setObito(Integer obito) {
		this.obito = obito;
	}

}