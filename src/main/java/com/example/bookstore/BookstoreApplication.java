package com.example.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.bookstore.domain.Categoria;
import com.example.bookstore.domain.Livro;
import com.example.bookstore.repositories.CategoriaRepository;
import com.example.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository catRepo;

	@Autowired
	private LivroRepository livroRepo;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "INFORMATICA", "LIVROS JAVA");

		Livro l1 = new Livro(null, "clean code", "robert martin", "nada", cat1);

		cat1.getLivros().addAll(Arrays.asList(l1));

		this.catRepo.saveAll(Arrays.asList(cat1));
		this.livroRepo.saveAll(Arrays.asList(l1));

	}

}
