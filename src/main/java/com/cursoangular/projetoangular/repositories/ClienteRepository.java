package com.cursoangular.projetoangular.repositories;

import com.cursoangular.projetoangular.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
