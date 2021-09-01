package com.cursoangular.projetoangular.domain;

import java.io.Serializable;
import java.util.Objects;

public class Categoria implements Serializable {
//Serializable é uma interface que diz que os objetos da classe possam ser gravados em bytes, isso serve para que
//os objetos sejam salvos em arquivos, para trafegar redes e assim por diante.

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;

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
