package com.github.marcoresende.testepraticodev.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.github.marcoresende.testepraticodev.util.DateTimeJsonDeserializer;
import com.github.marcoresende.testepraticodev.util.DateTimeJsonSerializer;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "localidade", "horario", "projecao" })
public class IbgeProjecao {

	@JsonProperty("localidade")
	private String localidade;
	
	@JsonProperty("horario")
	@JsonDeserialize(using = DateTimeJsonDeserializer.class)
    @JsonSerialize(using = DateTimeJsonSerializer.class)
	private Date horario;
	
	@JsonProperty("projecao")
	private Projecao projecao;

	@JsonProperty("localidade")
	public String getLocalidade() {
		return localidade;
	}

	@JsonProperty("localidade")
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	@JsonProperty("horario")
	public Date getHorario() {
		return horario;
	}

	@JsonProperty("horario")
	public void setHorario(Date horario) {
		this.horario = horario;
	}

	@JsonProperty("projecao")
	public Projecao getProjecao() {
		return projecao;
	}

	@JsonProperty("projecao")
	public void setProjecao(Projecao projecao) {
		this.projecao = projecao;
	}

}