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
<h3>Swagger</h3>
<h3>Exception Handler</h3>	