package com.cursoangular.projetoangular.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Categoria implements Serializable {
//Serializable é uma interface que diz que os objetos da classe possam ser gravados em bytes, isso serve para que
//os objetos sejam salvos em arquivos, para trafegar redes e assim por diante.

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    //Uma categoria tem varios produtos
    //Como eu fiz o mapeamento na classe produto, aqui vou precisar apenas referenciar o nome do atributo
    //que ficou responsavel pelo relacionamento na classe Produto, utilizando o mappedBy
    @ManyToMany(mappedBy = "categorias")
    private List<Produto> produtos = new ArrayList<>();
    //Usamos o ArrayList porque estamos falando que vamos ter uma coleção d eprodutos

    public Categoria(){

    }

    public Categoria(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    //hashcode e equals. Na linguagem java, para que dois objetos possam ser comparados pelo seu conteudo,
    //e nao pelo ponteiro de memoria, eles precisam ser comaprados pelo hashcode equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;
        Categoria categoria = (Categoria) o;
        return id.equals(categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
