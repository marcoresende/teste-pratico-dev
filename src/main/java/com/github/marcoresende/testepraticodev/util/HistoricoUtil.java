package com.github.marcoresende.testepraticodev.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Component;

import com.github.marcoresende.testepraticodev.model.PopulacaoCalculada;

@Component
public class HistoricoUtil {
	
	private final int LIMITE = 10;
	
	private ConcurrentLinkedQueue<PopulacaoCalculada> cacheHistorico = new ConcurrentLinkedQueue<>();
	
	public void addHistorico(PopulacaoCalculada obj) {
		cacheHistorico.add(obj);
		
		if(cacheHistorico.size() > LIMITE) {
			cacheHistorico.remove();
		}
		
	}
	
	
	public List<PopulacaoCalculada> getHistoricoList() {
		return new ArrayList<>(cacheHistorico);
	}
	
}
