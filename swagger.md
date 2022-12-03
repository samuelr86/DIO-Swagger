<h3>Apresentação</h3>
	<ul>
		<li>Criar um projeto Web</li>
		<li>Configurar os controllers</li>
		<li>Documentar API com Swagger</li>
		<li>Tratamento de exceções com Handlers</li>
	</ul>

<h1 align="center">Spring Web</h1>

<h3>REST e RESTful</h3>
	<h4>O que é uma API?</h4>
		<p>É um código programável que faz a ponte de comunicação entre duas aplicações distintas.</p>
	<h4>REST e RESTful</h4>
		<p>é como um guia de boas práticas e Restful é a capacidade de determinado sistema aplicar os princípios REST.</p>
	<h4>Princípios</h4>
		<p>Para que uma arquitetura seja RESTful, é necessário ter uma série de princípios ou padrões. Veja quais são eles:
			<ul>
				<li>cliente-servidor: significa aprimorar a portabilidade entre várias plataformas de interface do usuário e do servidor, permitindo uma evolução independente do sistema;</li>
				<li>interface uniforme: representa uma interação uniforme entre cliente e servidor. Para isso, é preciso ter uma interface que identifique e represente recursos, mensagens autodescritivas, bem como hypermedia(HATEOAS);</li>
				<li>stateless: indica que cada interação via API tema cesso a dados completos e compreensíveis;</li>
				<li>cache: necessário para reduzir o tempo médio de resposta, melhorar a eficiência, desempenho e escalabilidade da comunicação;</li>
				<li>camadas: permite que a arquitetura seja menos complexa e altamente flexível.</li>
			</ul>
		</p>
	<h4>Nível de Maturidade</h4>
		<p>Para padronizar e facilitar o desenvolvimento de APIs REST, Leonard Richardson propôs um modelo de maturidade para esse tipo de API definido em 4 níveis.
			<ul>
				<li><em><b>Leve 0 - Ausência de regras</b></em>: Esse é considerado o nível mais básico e uma API que implementa apenas esse nível não pode ser considerada REST pois não segue qualquer padrão.</li>
				<table>
					<tr>
						<td><b>Verbo HTTP</td>
						<td><b>URI</td>
						<td><b>Operação</td>
					</tr>
					<tr>
						<td>POST</td>
						<td>/getUsuario</td>
						<td>Pesquisar Usuário</td>
					</tr>
					<tr>
						<td>POST</td>
						<td>/salvarUsuario</td>
						<td>Salvar</td>
					</tr>
					<tr>
						<td>POST</td>
						<td>/alterarUsuario</td>
						<td>Alterar</td>
					</tr>
					<tr>
						<td>POST</td>
						<td>/excluirUsuario</td>
						<td>Deletar</td>
					</tr>
				</table>
				<li><em><b>Leve 1 - Aplicação de Resources</b></em>: Os recursos foram equalizados e para não gerar ambiguidade é necessário definir o verbo http adequadamente.</li>
				<table>
					<tr>
						<td><b>Verbo HTTP</td>
						<td><b>URI</td>
						<td><b>Operação</td>
					</tr>
					<tr>
						<td>GET</td>
						<td>/usuario/1</td>
						<td>Pesquisar Usuário</td>
					</tr>
					<tr>
						<td>POST</td>
						<td>/usuario</td>
						<td>Salvar</td>
					</tr>
					<tr>
						<td>PUT</td>
						<td>/usuario/1</td>
						<td>Alterar</td>
					</tr>
					<tr>
						<td>DELETE</td>
						<td>/usuario/1</td>
						<td>Deletar</td>
					</tr>
				</table>
				<li><em><b>Leve 2 - Implementação de verbos HTTP</b></em>: Como a definição dos verbos já foi requisitada no Nível 1, o Nível 2 se encarrega de validar a aplicabilidade dos verbos para finalidades específicas.</li>
				<table>
					<tr>
						<td><b>Verbo HTTP</td>
						<td><b>Função</td>	
					</tr>
					<tr>
						<td>GET</td>
						<td>Retorna Dados</td>						
					</tr>
					<tr>
						<td>POST</td>
						<td>Grava Dados</td>
					</tr>
					<tr>
						<td>PUT</td>
						<td>Altera Dados</td>
					</tr>
					<tr>
						<td>DELETE</td>
						<td>Remove Dados</td>
					</tr>
				</table>
				<li><em><b>Leve 3 - HATEOAS</b></em>: significa "Hypermedia As The Engine of Application State. Uma API que implementa esse nível fornece aos seu clientes links que indicarão como poderá ser feita a navegação entre seus recursos, ou seja, quem for consumir precisará saber apenas a rota principal e a resposta dessa requisição terá todas as demais rotas possíveis.</li>
			</ul>
		</p>

<h3>Controllers</h3>
	<h4>Criando nosso primeiro <em>Controller</em></h4>
	<p>Um controller é um recurso que disponibiliza as funcionalidades de negócio da aplicação através do protocolo HTTP.</p>
	<p>Vamos criar nosso primeiro controller:

```java
public class WelcomeController{
	public String welcome(){
		return "Welcome to my Spring Boot Web API";
	}
}
```

... e a partir de agora anotaremos o classe com "RestController", e após esse momento seus métodos serão serviços HTTP...

```java
@RestController
public class WelcomeController{
```

... neste caso o método "welcome()" será um recursos HTTP do tipo <em>GET</em>, então anotaremos com um "@GetMapping"...

```java
@GetMapping
public String welcome(){
```
</p>
	<h4>RestController</h4>
	<p>Um RestController em Spring nada mais é do que uma classe contendo anotações específicas para a disponibilização de recursos HTTP baseados em nossos  serviços e regras de negócio.</p>
	<p>As anotações e configurações mais comuns:
		<ul>
		<li>@RestController: Responsável por designar o bean de component que suporta requisições HTTP com base na arquitetura REST.</li>
		<li>@RequestMapping(prefix): Determina qual a URI comum para todos os recursos disponibilizados pelo Controller.</li>
		<li>@GetMapping: Determina que o método aceitará requisições do tipo GET.</li>
		<li>@PostMapping: Determina que o método aceitará requisições do tipo POST.</li>
		<li>@PutMapping: Determina que o método aceitará requisições do tipo PUT.</li>
		<li>@DeleteMapping: Determina que o método aceitará requisições do tipo DELETE. Para mostrar a exclusão do elemento precisaremos de um ClienteHTTP, o mais utilizado é o POSTMAN.</li>
		<li>@RequestBody: Convert um JSON para o tipo do objeto esperado como parâmetro no método.</li>
		<li>@PathVariable: Consegue determinar que parte da URI será composta por parâmetros recebidos nas requisições.</li>
	</ul></p>

<h3>Swagger</h3>

<p>É uma linguagem de descrição de interface para descrever APIs RESTful expressas usando JSON. O Swagger é usado junto com um conjunto de ferramentas de software de código aberto para projetar, construir, documentar e usar serviços da Web RESTful.</p>
<p>Primeiramente precisamos configurar o Swagger e adicionar as dependências no pom.xml.

```xml
<!-- SWAGGER DOCUMENTAÇÃO -->
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
	<version>2.9.2</version>
</dependency>
<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger-ui</artifactId>
	<version>2.9.2</version>
</dependency>
```
</p>
<p>Após vamos criar um diretório chamada doc ou config e dentro dessa pasta vamos criar uma classe de configuração do Swagger para o Spring...

```java
@Configuration
@EnableSwagger2
public class SwaggerConfig{

}
```
O Swagger tem alguns requisitos que são comuns e outros requisitos que são de escaneamento de onde estarão nossos recursos.</p>
<p>Primeiro vamos criar um método para retornar os dados de o contato da nossa API...

```java
private Contact contato(){
	return new Contact(
		"Seu nome",
		"http://www.seusite.com.br",
		"voce@seusite.com.br");
}
```
... Depois criamos um outro método com as informações da nossa API...

```java
private ApiInfoBuilder informacoesAPI(){
    ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

    apiInfoBuilder.title("Title - Rest API");
    apiInfoBuilder.description("API exemplo de uso de SpringBoot REST API");
    apiInfoBuilder.version("1.0");
    apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
    apiInfoBuilder.license("Licença - Sua Empresa");
    apiInfoBuilder.licenseUrl("http://www.seusite.com.br");
    apiInfoBuilder.contact(this.contato());

    return apiInfoBuilder;
}
```
... como se trata de uma aplicação Springboot, vamos criar um Docket(documento) em forma de @Bean...

```java
@Bean
public Docket detalheAPI(){
    Docket docket = new Docket(DocumentationType.SWAGGER_2);

    docket.select()
        .apis(RequestHandlerSelectors.basePackage("pacote.comseus.controllers"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(this.informacoesAPI().build())
        .consumes(new HashSet<String>(Arrays.asList("application/json")))
        .produces(new HashSet<String>(Arrays.asList("application/json")));

    return docket;
}
```
</p>
<p>Após entrar em "localhost:8080/swagger-ui.html" e teremos acesso a toda documentação criada pelo swagger com as classes, as rotas e o métodos utilizados...
<table>
					<tr>
						<td><b>usuario-controller</td>
						<td><b>User Controller</td>	
					</tr>
					<tr>
						<td>GET</td>
						<td>/users</td>		
						<td>getUser</td>				
					</tr>
					<tr>
						<td>POST</td>
						<td>/users</td>		
						<td>postUser</td>				
					</tr>
					<tr>
						<td>DELETE</td>
						<td>/users/{id}</td>		
						<td>deleteUser</td>				
					</tr>
					<tr>
						<td>GET</td>
						<td>/users/{username}</td>		
						<td>getOne</td>				
					</tr>
				</table>
</p>

<h3>Exception Handler</h3>	

<p>O tratamento de exceções, na ciência da computação, é o mecanismo responsável pelo tratamento da ocorrência de condições que alteram o fluxo normal da execução de programas de computadores. Nossa aplicações precisam ser resilientes a possíveis comportamentos inesperados baseados na proposta de negócio e falando de recursos HTTP, realizando implementações que centralizam e gerenciam este tipo de tratamento de exceção.</p>

<h4>Exception Handler</h4>
<p>Um manipulador de exceção é o código que estipula o que um programa fará quando um evento anômalo interromper o fluxo normal das instruções desse programa. Existem alguns tipos de tratamento de exceções em uma aplicação Spring Web, iremos ilustrar duas delas e focar na <em>ControllerAdvice</em> mais utilizada em nossos projetos.</p>
<ul>
	<li><b>Solução 1</b>: Nível do Controller - @ExceptionHandler
		<p>A primeira solução funciona no nível do @Controller, onde cada método trata um aexceção de forma declarativa com @ExceptionHandler:

```java
public class MeuController{
	//...
	@ExceptionHandler({MinhaException1.class})
	public void meuMetodo(){
		//
	}
}
```	
</p>
</li>
	<li><b>Solução 2</b>: o <em>ResponseStatusExceptionResolver</em>
		<p>Sua principal responsabilidade é usar a anotação @ResponseStatus disponível em exceções personalizadas e mapear essas exceções para códigos de  status HTTP.

```java
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNotFoundException extends RuntimeException {
	public RecursoNotFoundException(){
		super();
	}
	public RecursoNotFoundException(String msg){
		super(msg);
	}
}
```
</p>
	</li>
</ul>
<h4>RestControllerAdvice</h4>
<p>A anotação @ControllerAdvice nos permite consolidar nossos múltiplos @ExceptionHandlers espalhados de antes em um único componente global de tratamento de erros.
<ul>
	<li>Isso nos dá controle total sobre o corpo da resposta, bemcomo o código de status.</li>
	<li>Ele fornece o mapeamento de várias exceções ao mesmo método, para serem tratadas em conjunto.</li>
	<li>Ele faz bom uso da resposta RESTful ResponseEntity masi recente.</li>
</ul></p>
<h4>GlobalExceptionHandler</h4>
<p>Vamos configurar um tratamento de exceções global para interceptar todas as exceções que ocorrem em nossa aplicação, sem precisar tornar declarativo em todos os recursos.</p>
<h5>Customizando nossas mensagens</h5>
<p>Primeiro de tudo uma resposta HTTP mesmo sendo um Erro pode ser considerada um Objeto que será convertido em JSON exponde informãções relacionadas a exceção disparada.

```java
import java.util.Date 
public class ResponseError{
	private Date timstamp = new Date();
	private String status = "error";
	private int statusCode = 400;
	private String error;

	// getters e setters 
}
```
</p>
<ul>
	<li>O campo <b>timestamp</b> é o momento exato da geração da exceção</li>
	<li>O campo <b>status</b> é um campo customizado de acordo com seu domínio de negócio</li>
	<li>O campo <b>statusCode</b> pode ser um dicionário de erro da sua aplicação</li>
	<li>O campo <b>error</b> é a mensagem apresentada ao usuário da aplicação</li>
</ul>

<h5>Definindo uma exceção de negócio</h5>
<p>Algumas de nossas exceções estão relacionadas ao domínio ou negócio da nossa aplicação, sendo assim vamos criar uma classe de exceção que estende RuntimeException que servirá como base para todas as outras exceções do negócio.</p>

```java
public class BusinessException extends RuntimeException {
	
	public BusinessException(String msg){
		super(msg);
	}

	public BusinessException(String msg, Object ... params){
		super(String.format(msg, params));
	}
}
```
<p>A classe BusinessException possui dois construtores, uma para definição de uma mensagem simples e o outro para uma mensagem mais customizada utilizadno o recurso de <b>varargs</b>.</p>

<h5>Configurando o ExceptionHandler</h5>
<p>Vamos criar uma classe que captará todas as exceções do negócio BusinessException para tratar e converter e retornar mensagens mais declarativas ao usuário da aplicação.</p>

```java
import jakarta.annotation.Resource;

import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class GlobalExcpetionHandler {
    @Resource
    private MessageSource messageSource; // capaz de pegar as msg de exceções

    private HttpHeaders headers(){ 
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private ResponseError responseError(String msg, HttpStatus statusCode){ 
        ResponseError responseError = new ResponseError();
        responseError.setStatus("error");
        responseError.setError(msg);
        responseError.setStatusCode(statusCode.value());
        return responseError;
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<Object> handleGeneral(Exception e, WebRequest request){
        if(e.getClass().isAssignableFrom(UndeclaredThrowableException.class)){
            UndeclaredThrowableException exception = (UndeclaredThrowableException) e;
            return handleBusinessException((BusinessException) exception.getUndeclaredThrowable(), request);
        }else{
            String message = messageSource.getMessage("error.server", new Object[]{e.getMessage()}, null);
            ResponseError error = responseError(message, HttpStatus.INTERNAL_SERVER_ERROR);
            return handleExceptionInternal(e, error, headers(), HttpStatus.INTERNAL_SERVER_ERROR, request);
        }
    }

    @ExceptionHandler({BusinessException.class})
    private ResponseEntity<Object> handleBusinessException(BusinessException e, WebRequest request){
        ResponseError error = responseError(e.getMessage(), HttpStatus.CONFLICT);
        return handleExceptionInternal(e, error, headers(), HttpStatus.CONFLICT, request);
    }

  
}

```