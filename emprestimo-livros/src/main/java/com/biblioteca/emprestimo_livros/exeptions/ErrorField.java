package com.biblioteca.emprestimo_livros.exeptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorField {
	private String nome;
	private String mensagem;
}
