package com.gustavo.gestao_api_rest.repositories;

import com.gustavo.gestao_api_rest.entities.Setor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SetorRepository extends JpaRepository<Setor, Long> {
}
