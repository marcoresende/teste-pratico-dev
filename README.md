
# teste-pratico-dev
Teste de seleção

## Compatibilidade
1. Java 8 ou superior;

## Ambiente
1. Importar código fonte como um projeto Maven para o ambiente de desenvolvimento.
2. Configurar arquivo de propriedades (opicional):
Se necessário, é possível alterar o contexto, porta e URL da API configurados na aplicação. Basta editar o arquivo "aplication.properties".
	>server.contextPath=/projecoes
	server.port=9599
	server.external.api.ibge=https://servicodados.ibge.gov.br/api/v1/projecoes/populacao
3. Executar "Maven Install" para gerar versão
4. Para iniciar a aplicação basta executar o comando:
	> java -jar teste-pratico-dev-1.0.0.jar

## API

### Consulta Projeção da População
- URL: /projecoes/api/populacao/{data-futura}
- Parâmetros:
	- Nome: data-futura
	- Tipo: String
	- Formato: "dd-MM-yyyy'T'HH:mm:ss
	- Exemplo: /projecoes/api/populacao/10-08-2021T04:00:00
- Retorno
	- dataAtual - String
	- populacaoAtual - Integer
	- dataProjecao - String
	- populacaoProjetada - Integer
	- messages - Array de Objetos
			- severity - String ("INFO", "ERROR", "WARN")
			- description - String
- Exemplo:
	>		
		{
		"dataAtual": "06/08/2020 16:03:07",
		"populacaoAtual": 211877612,
		"dataProjecao": "10/08/2021 04:00:00",
		"populacaoProjetada": 213466424,
		"messages": [{
			"severity": "INFO",
			"description": "OK."
		}]	}

### Consulta Histórico de Requisições
- URL: /projecoes/api/populacao/historico
- Retorno
	- Values - Array de objetos:
		- dataAtual - String
		- populacaoAtual - Integer
		- dataProjecao - String
		- populacaoProjetada - Integer
	- messages - Array de Objetos
			- severity - String ("INFO", "ERROR", "WARN")
			- description - String
- Exemplo:
	>		
		{
			"values": [{
				"dataAtual": "06/08/2020 16:02:19",
				"populacaoAtual": 211877610,
				"dataProjecao": "10/08/2021 13:00:00",
				"populacaoProjetada": 213468041
			}, {
				"dataAtual": "06/08/2020 16:02:23",
				"populacaoAtual": 211877610,
				"dataProjecao": "10/08/2021 12:00:00",
				"populacaoProjetada": 213467861
			}],
			"messages": [{
				"severity": "INFO",
				"description": "OK."
			}]	}