package com.gustavo.gestao_api_rest.repositories;

import com.gustavo.gestao_api_rest.entities.Demanda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandaRepository extends JpaRepository<Demanda, Long> {
}
