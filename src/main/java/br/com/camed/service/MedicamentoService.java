package br.com.camed.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.camed.dto.MedicamentoDTO;
import br.com.camed.entity.Medicamento;
import br.com.camed.mapper.MedicamentoMapper;
import br.com.camed.repositoy.MedicamentoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicamentoService {
	
	@Autowired
    private MedicamentoRepository repository;
	
	@Autowired
    private MedicamentoMapper mapper;

    public List<MedicamentoDTO> buscarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public MedicamentoDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public MedicamentoDTO salvar(MedicamentoDTO dto) {
    	
    	if (repository.existsByIdentificadorIgnoreCase(dto.getIdentificador())) {
            throw new RuntimeException("Identificador já cadastrado.");
        }
    	
        Medicamento medicamento = mapper.toEntity(dto);
        medicamento.setQuantidadeDisponivel(dto.getQuantidadeInicial()); // ✅ sincroniza os dois
        Medicamento salvo = repository.save(medicamento);
        return mapper.toDTO(salvo);
    }

    public MedicamentoDTO atualizar(Long id, MedicamentoDTO dto) {
        Medicamento existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        dto.setId(id);
        Medicamento atualizado = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(atualizado));
    }

    public void remover(Long id) {
        Medicamento medicamento = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Medicamento com ID " + id + " não encontrado"));

        try {
            repository.delete(medicamento);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Não é possível excluir o medicamento. Ele está vinculado a outras entidades.");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir medicamento: " + e.getMessage());
        }
    }

}
