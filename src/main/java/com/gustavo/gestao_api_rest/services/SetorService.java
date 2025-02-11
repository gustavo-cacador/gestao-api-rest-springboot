package com.gustavo.gestao_api_rest.services;

import com.gustavo.gestao_api_rest.dto.SetorDTO;
import com.gustavo.gestao_api_rest.entities.Funcionario;
import com.gustavo.gestao_api_rest.entities.Setor;
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
public class SetorService {

    @Autowired
    public SetorRepository setorRepository;

    @Transactional(readOnly = true)
    public SetorDTO procurarPorId(Long id) {
        Setor setor = setorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Setor não encontrado."));
        return new SetorDTO(setor);
    }

    @Transactional(readOnly = true)
    public List<SetorDTO> buscarTodos() {
        List<Setor> result = setorRepository.findAll();
        return result.stream()
                .map(x -> new SetorDTO(x))
                .toList();
    }

    @Transactional
    public SetorDTO inserirSetor(SetorDTO dto) {
        Setor entity = new Setor();
        copyDtoToEntity(dto, entity);
        entity = setorRepository.save(entity);
        return new SetorDTO(entity);
    }

    @Transactional
    public SetorDTO atualizarFuncionario(Long id, SetorDTO dto) {
        try {
            Setor entity = setorRepository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = setorRepository.save(entity);
            return new SetorDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Funcionário não encontrado.");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deletarFuncionario(Long id) {
        if(!setorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Funcionário não existe");
        } try {
            setorRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
        setorRepository.deleteById(id);
    }

    private void copyDtoToEntity(SetorDTO dto, Setor entity) {
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
    }
}
