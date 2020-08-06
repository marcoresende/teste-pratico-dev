package com.github.marcoresende.testepraticodev;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.marcoresende.testepraticodev.controller.ProjecaoPopulacaoController;
import com.github.marcoresende.testepraticodev.core.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
	
	@Autowired
	private ProjecaoPopulacaoController projecaoPopulacaoController;
	
    @TestConfiguration
    static class ProjecaoPopulacaoControllerTestContextConfiguration {
    	

    }
    
	@Test
	public void calculaPopulacaoTest() {
	    
	    Long corrente = 1596744394567L;
	    Long futura = 1628280478000L;
	    Integer incremento = 20039;
	    Integer populacao = 0;
	    
	    Integer result = 1573735;
	    
	    Integer calculo = projecaoPopulacaoController.calculaPopulacao(new Date(corrente), new Date(futura), populacao, incremento);
	 
	    Assert.assertEquals("O cálculo realizado está diferente", result, calculo);
	    
	 }

}
