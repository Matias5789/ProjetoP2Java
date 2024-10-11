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
GET<br>
Encontre um cliente utilizando seu id<br>
Encontre um cliente utilizando seu nome<br>
Encontre um cliente utilizando a data de nascimento<br>
POST - Criar um novo cliente<br>
DELETE - Excluir um cliente, desde que não possua empréstimos<br>
PUT - Atualizar os dados de um cliente, exceto seu status<br>
PATCH - Atualizar o status do cliente (ativo / inativo)<br>
</p>
<h3>/api/loans</h3>
<p>
GET<br>
Encontre os empréstimos de um cliente a partir do cliente<br>
Encontre os empréstimos de um período de tempo<br>
POST<br>
Criar um novo empréstimo.<br>
Dois livros podem ser emprestados por vez.<br>
Um cliente não pode ter mais de um empréstimo simultâneo<br>
Atualizar o status dos livros para BORROWED<br>
PATCH<br>
Prorrogar o empréstimo do aluno<br>
Finalizar o empréstimo, atualizando o status dos livros para AVAILABLE<br>
</p>
<h3>/api/books</h3>
<p>
GET - Para obter todos os livros ou detalhes de um livro por id.<br>
POST - Criar um novo livro<br>
DELETE - Inativar um livro<br>
PUT - Atualizar os dados de um livro (exceto status)<br>
PATCH - Atualizar o status do livro<br>
</p>
<h3>Campos</h3>
<p>
Customer<br>
id (Long)<br>
name (String)<br>
lastname (String)<br>
address (String)<br>
city (String)<br>
state (BigDecimal)<br>
country (String)<br>
birthDate (LocalDate)<br>
</p>
<p>
Book<br>
id (Long)<br>
title (String)<br>
author (String)<br>
isbn (String)<br>
publishedDate (LocalDate)<br>
status (Enum [AVAILABLE, BORROWED])<br>
</p>
<p>
Loan<br>
id (Long)<br>
customer (Customer)<br>
books (List)<br>
author (String)<br>
isbn (String)<br>
publishedDate (LocalDate)<br>
status (Enum [AVAILABLE, BORROWED])<br>
</p>
</p>

<h2 align="left">🖌️ Autores </h2>

| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/125374128?v=4" width=115><br><sub>Mateus da Silva</sub>](https://github.com/Matias5789) |  [<img loading="lazy" src="https://avatars.githubusercontent.com/u/125374126?v=4" width=115><br><sub>Marina Duarte</sub>](https://github.com/maricamano) |  [<img loading="lazy" src="https://avatars.githubusercontent.com/u/112172388?v=4" width=115><br><sub>Bianca Zatorre</sub>](https://github.com/biancazatorre) |  [<img loading="lazy" src="https://avatars.githubusercontent.com/u/112701726?v=4" width=115><br><sub>Danrley Regis</sub>](https://github.com/DanHunterz1) |
:---: | :---: | :---: | :---: |
