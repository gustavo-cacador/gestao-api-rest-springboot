package com.gustavo.gestao_api_rest.services;

import com.gustavo.gestao_api_rest.dto.DemandaDTO;
import com.gustavo.gestao_api_rest.dto.SetorDTO;
import com.gustavo.gestao_api_rest.entities.Demanda;
import com.gustavo.gestao_api_rest.entities.Setor;
import com.gustavo.gestao_api_rest.repositories.DemandaRepository;
import com.gustavo.gestao_api_rest.repositories.SetorRepository;
import com.gustavo.gestao_api_rest.services.exceptions.DatabaseException;
import com.gustavo.gestao_api_rest.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DemandaService {

    @Autowired
    public DemandaRepository demandaRepository;

    @Transactional(readOnly = true)
    public DemandaDTO procurarPorId(Long id) {
        Demanda demanda = demandaRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Demanda não encontrada."));
        return new DemandaDTO(demanda);
    }

    @Transactional(readOnly = true)
    public List<DemandaDTO> buscarTodos() {
        List<Demanda> result = demandaRepository.findAll();
        return result.stream()
                .map(x -> new DemandaDTO(x))
                .toList();
    }

    @Transactional
    public DemandaDTO inserirDemanda(DemandaDTO dto) {
        Demanda entity = new Demanda();
        copyDtoToEntity(dto, entity);
        entity = demandaRepository.save(entity);
        return new DemandaDTO(entity);
    }

    @Transactional
    public DemandaDTO atualizarDemanda(Long id, DemandaDTO dto) {
        try {
            Demanda entity = demandaRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = demandaRepository.save(entity);
            return new DemandaDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Demanda não encontrada.");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deletarDemanda(Long id) {
        if(!demandaRepository.existsById(id)) {
            throw new ResourceNotFoundException("Demanda não existe.");
        } try {
            demandaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial.");
        }
        demandaRepository.deleteById(id);
    }

    private void copyDtoToEntity(DemandaDTO dto, Demanda entity) {
        entity.setId(dto.getId());
        entity.setPendencia(dto.getPendencia());
        entity.setServico(dto.getServico());
        entity.setDataAbertura(dto.getDataAbertura());
        entity.setNivel(dto.getNivel());
        entity.setPrazo(dto.getPrazo());
        entity.setCanal(dto.getCanal());
    }
}
