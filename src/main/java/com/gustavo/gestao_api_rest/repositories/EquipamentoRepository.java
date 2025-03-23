package com.gustavo.gestao_api_rest.repositories;

import com.gustavo.gestao_api_rest.entities.Equipamento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipamentoRepository extends JpaRepository<Equipamento, Long> {

    @Query("SELECT obj FROM Equipamento obj " +
            "WHERE UPPER(obj.tipo) LIKE UPPER(CONCAT('%', :tipo, '%'))")
    List<Equipamento> searchByName(String tipo);
}
