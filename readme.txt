Para o teste fiz as seguintes suposições.:


1 - Centralizei as informações de entrada em um arquivo txt, assim ao executar faço a leitura do mesmo.
	Caso queira adicionar mais alguma linha de entrada, preciso somente  editar o arquivo "src/main/resources/input_data.txt" que está no caminho da aplicação.

2 - Ao ler os dados no arquivo separei as perguntas, dos valores de informações, para isso eu adicionei algumas classes que armazenam uma lista  com essas informações para que eu pudesse manipular em toda a aplicação. Essas classe contendo as listas de armazenamento ficam no pacotes "br.com.merchants.guide.dao"

3 - Efetuei a separação do que eu chamo de valores simples e especias. Valores simples eu considerei como sendo(glob,prok,pish,tegj) e valores especiais eu considerei (Gold, Silver, Iron), pois o mesmo considerei uma forma diferente para calculo. Para tal valores eu usei o padrão decorator, pois caso apareça algum novo valor, não ira ter grande impacto para a adição do mesmo.

4 - Para o cálculo dos valores especiais, eu considerei que um valor especial era igual ao número decimal informado dividido pelo numero que o antecedia. 


5 - Para isso toda a entrada de dados deve seguir os padrões que foram propostos no problema.

6 - Fiz alguns arquivos com tipos enumerados, que são referenciados em todo o projeto, afim de centralizar as palavras usadas em um unico local.

7 - A minha maior preocupação foi com a expansão do projeto, visando facilidade para adicionar novos tipos de moedas, ou palavras chave para determinada ação.

8 - Mantive as Strings do projeto em caixa baixa.

Abaixo descrevi a estrutura do projeto.

src
	main
		java
			br.com.merchants.guide.dao        ------ pacote onde ficam as classes que fazer o armazenamento temporatorio de informações
			br.com.merchants.guide.decorator  ------ pacote onde ficam os objetos decorados para a conversao do valor em tempo de execução		
			br.com.merchants.guide.execute    ------ pacote onde fica a classe inicial responsavel por iniciar a aplicação
			br.com.merchants.guide.factory    ------ pacote onde fica a fábrica de objetos decorados, responsável por criar as instâncias
			br.com.merchants.guide.process    ------ pacote onde faz o processamento dos dados de entrada, e o processamento da resposta
			br.com.merchants.guide.types      ------ pacotes com os tipos enumerados
			br.com.merchants.guide.utils	   ------ pacote com classes utlitarias
		resources
			input_data.txt    ------ arquivo contendo os dados de entrada da aplicação. 
	
	test
		java  - todos os pacotes abaixo representam os pacotes acima contendo os testes unitarios para suas repectivas classes

		resources
			inpput_test_data.txt    ------ arquivo contendo os dados de entrada usados nos testes unitarios


EXECUCAO DA APLICACAO

Usei o Maven para fazer o build do projeto. http://maven.apache.org/

Acessar o terminal.

1 - Descompactar o zip.
2 - Ir no diretorio do projeto.
3 - Executar o comando:  mvn clean install exec:java 

Utilizando IDE Eclipse

1 - Descompactar o zip.
2 - Importar maven project
3 - Clicar com o direito no pom.xml, e selecionar a opcao maven build.
4 - Na opcao goal colocar o seguinte comando:  mvn clean install exec:java