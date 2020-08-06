package com.github.marcoresende.testepraticodev.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.marcoresende.testepraticodev.util.DateTimeJsonDeserializer;
import com.github.marcoresende.testepraticodev.util.DateTimeJsonSerializer;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dataAtual", "populacaoAtual", "dataProjecao", "populacaoProjetada" })
public class PopulacaoCalculada {
	
	@JsonProperty("dataAtual")
	@JsonDeserialize(using = DateTimeJsonDeserializer.class)	
    @JsonSerialize(using = DateTimeJsonSerializer.class)
	private Date dataAtual;
	
	@JsonProperty("populacaoAtual")
	private Integer populacaoAtual;

	@JsonProperty("dataProjecao")
	@JsonDeserialize(using = DateTimeJsonDeserializer.class)
    @JsonSerialize(using = DateTimeJsonSerializer.class)
	private Date dataProjecao;
		
	@JsonProperty("populacaoProjetada")
	private Integer populacaoProjetada;
	
	public PopulacaoCalculada () {}
	
	public PopulacaoCalculada (Date dataAtual, Integer populacaoAtual, Date dataProjecao, Integer populacaoProjetada) {
		this.dataAtual = dataAtual;
		this.populacaoAtual = populacaoAtual;
		this.dataProjecao = dataProjecao;
		this.populacaoProjetada = populacaoProjetada;
	}

	public Date getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}

	public Integer getPopulacaoAtual() {
		return populacaoAtual;
	}

	public void setPopulacaoAtual(Integer populacaoAtual) {
		this.populacaoAtual = populacaoAtual;
	}

	public Date getDataProjecao() {
		return dataProjecao;
	}

	public void setDataProjecao(Date dataProjecao) {
		this.dataProjecao = dataProjecao;
	}

	public Integer getPopulacaoProjetada() {
		return populacaoProjetada;
	}

	public void setPopulacaoProjetada(Integer populacaoProjetada) {
		this.populacaoProjetada = populacaoProjetada;
	}


}
