package com.gustavo.gestao_api_rest.repositories;

import com.gustavo.gestao_api_rest.entities.Equipamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {
}
