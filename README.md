<h1> Projeto P2 Java </h1>

<h2>Instruções sobre o projeto em geral</h2>

<p>Instruções de entregas, oque será entregue ou o que deverá estar sendo feito estão no link a seguir:<br><br>
https://github.com/diegoneri/aulas-ds-spring-boot/blob/main/content/exercises/03.1-projeto-pratico.md</p>

<h2> Provaveis tema</h2>
<p></p>Projeto feito com base nas opções de temas disponibilizado pelo professor no link:<br><br>
https://github.com/diegoneri/aulas-ds-spring-boot/blob/main/content/exercises/03.2-proposals.md</p>
<br><p>Nossa tema sendo o de: <b>Gerenciamento de empréstimo de livros em uma biblioteca</b></p>

<h2>A ser feito no tema</h2>

<p>
  Na API uma biblioteca fará uma transformação digital, iniciando pelo processo de empréstimo de livros. Construa uma API que corresponda as operações abaixo:

<h3>/api/customers</h3>
<p>
GET
Encontre um cliente utilizando seu id
Encontre um cliente utilizando seu nome
Encontre um cliente utilizando a data de nascimento
POST - Criar um novo cliente
DELETE - Excluir um cliente, desde que não possua empréstimos
PUT - Atualizar os dados de um cliente, exceto seu status
PATCH - Atualizar o status do cliente (ativo / inativo)
</p><br>
<h3>/api/loans</h3>
<p>
GET
Encontre os empréstimos de um cliente a partir do cliente
Encontre os empréstimos de um período de tempo
POST
Criar um novo empréstimo.
Dois livros podem ser emprestados por vez.
Um cliente não pode ter mais de um empréstimo simultâneo
Atualizar o status dos livros para BORROWED
PATCH
Prorrogar o empréstimo do aluno
Finalizar o empréstimo, atualizando o status dos livros para AVAILABLE
</p><br>
<h3>/api/books</h3>
<p>
GET - Para obter todos os livros ou detalhes de um livro por id.
POST - Criar um novo livro
DELETE - Inativar um livro
PUT - Atualizar os dados de um livro (exceto status)
PATCH - Atualizar o status do livro
</p><br>
<h3>Campos</h3>
<p>
Customer
id (Long)
name (String)
lastname (String)
address (String)
city (String)
state (BigDecimal)
country (String)
birthDate (LocalDate)
</p><br>
<p>
Book
id (Long)
title (String)
author (String)
isbn (String)
publishedDate (LocalDate)
status (Enum [AVAILABLE, BORROWED])
</p><br>
<p>
Loan
id (Long)
customer (Customer)
books (List)
author (String)
isbn (String)
publishedDate (LocalDate)
status (Enum [AVAILABLE, BORROWED])
</p><br>
</p>

<p>Periodo em que eu (Mateus) não vou poder estar 100% com foco nesse trabalho, até essa quinta-feira (10/10/2024). Peço que me auxiliem nesse periodo</p>

<h2 align="left">🖌️ Autores </h2>

| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/125374128?v=4" width=115><br><sub>Mateus da Silva</sub>](https://github.com/Matias5789) |  [<img loading="lazy" src="https://avatars.githubusercontent.com/u/125374126?v=4" width=115><br><sub>Marina Duarte</sub>](https://github.com/maricamano) |  [<img loading="lazy" src="https://avatars.githubusercontent.com/u/112172388?v=4" width=115><br><sub>Bianca Zatorre</sub>](https://github.com/biancazatorre) |  [<img loading="lazy" src="https://avatars.githubusercontent.com/u/112701726?v=4" width=115><br><sub>Danrley Regis</sub>](https://github.com/DanHunterz1) |
:---: | :---: | :---: | :---: |
