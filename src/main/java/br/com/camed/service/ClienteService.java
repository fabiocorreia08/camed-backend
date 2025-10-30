package br.com.camed.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.camed.dto.ClienteDTO;
import br.com.camed.entity.Cliente;
import br.com.camed.mapper.ClienteMapper;
import br.com.camed.repositoy.ClienteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
	
	@Autowired
    private ClienteRepository repository;
	
	@Autowired
    private ClienteMapper mapper;

    public List<ClienteDTO> buscarTodos() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public ClienteDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public ClienteDTO salvar(ClienteDTO dto) {
    	
    	if (repository.existsByCpf(dto.getCpf())) {
            throw new RuntimeException("CPF já cadastrado.");
        }
    	
        Cliente cliente = mapper.toEntity(dto);
        Cliente salvo = repository.save(cliente);
        return mapper.toDTO(salvo);
    }

    public ClienteDTO atualizar(Long id, ClienteDTO dto) {
        Cliente existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        dto.setId(id);
        Cliente atualizado = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(atualizado));
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }

}
