package com.cursoangular.projetoangular;

import com.cursoangular.projetoangular.domain.Categoria;
import com.cursoangular.projetoangular.domain.Produto;
import com.cursoangular.projetoangular.repositories.CategoriaRepository;
import com.cursoangular.projetoangular.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ProjetoangularApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoangularApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 300.00 );
		Produto p3 = new Produto(null, "mouse", 89.99);

		//Agora nos temos que associar os produtos com as categorias
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		//Agora as categorias conhecem quais os produtos que estao associados com elas

		//Agora vamos fazer a mesma coisa para que o produto associe seus produtos com as categorias
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); //Arrays.asList serve para criar uma lista automatica.
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
	}
}
