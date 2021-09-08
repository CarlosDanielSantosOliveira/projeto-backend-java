package com.cursoangular.projetoangular.repositories;

import com.cursoangular.projetoangular.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
