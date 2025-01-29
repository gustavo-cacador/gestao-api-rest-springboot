package com.gustavo.gestao_api_rest.repositories;

import com.gustavo.gestao_api_rest.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
