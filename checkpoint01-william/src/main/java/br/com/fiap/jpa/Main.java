package br.com.fiap.jpa;

import java.time.LocalDate;

import br.com.fiap.jpa.entity.Livro;
import br.com.fiap.jpa.service.impl.LivroServiceImpl;

public class Main {

	public static void main(String[] args) {
		
		LivroServiceImpl livroService = LivroServiceImpl.getInstance();
	
		Livro livro1 = new Livro("Bozzato", "Carvalho", "Aurelia", LocalDate.of(2002, 11, 7));
		Livro livro2 = new Livro("George Orwell", "Carvalho", "Aurelia", LocalDate.of(1903, 6, 21));
		Livro livro3 = new Livro("William",  "Carvalho", "Aurelia", LocalDate.of(2002, 11, 7));
		
		livroService.inserir(livro1);
		livroService.inserir(livro2);
		livroService.inserir(livro3);
		
		livroService.listar().forEach(System.out::println);
		
		livroService.remover(2L);
		livroService.atualizar(livro1 = new Livro("Bozzato", "Carvalho", "Aurelia", LocalDate.of(2016, 1, 7)));
		livroService.atualizar(livro3 = new Livro("William",  "Carvalho", "Aurelia", LocalDate.of(2016, 1, 7)));
	}
}
