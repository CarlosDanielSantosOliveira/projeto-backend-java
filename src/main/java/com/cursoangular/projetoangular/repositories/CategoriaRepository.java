package com.cursoangular.projetoangular.repositories;

import com.cursoangular.projetoangular.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
