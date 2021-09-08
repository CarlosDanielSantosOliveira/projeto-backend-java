package com.cursoangular.projetoangular;

import com.cursoangular.projetoangular.domain.Categoria;
import com.cursoangular.projetoangular.domain.Cidade;
import com.cursoangular.projetoangular.domain.Estado;
import com.cursoangular.projetoangular.domain.Produto;
import com.cursoangular.projetoangular.repositories.CategoriaRepository;
import com.cursoangular.projetoangular.repositories.CidadeRepository;
import com.cursoangular.projetoangular.repositories.EstadoRepository;
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

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

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

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade cid1 = new Cidade(null, "Uberlândia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);

		//Agora nos temos que associar os produtos com as categorias
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		//Agora as categorias conhecem quais os produtos que estao associados com elas

		//Agora vamos fazer a mesma coisa para que o produto associe seus produtos com as categorias
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); //Arrays.asList serve para criar uma lista automatica.
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
	}
}
