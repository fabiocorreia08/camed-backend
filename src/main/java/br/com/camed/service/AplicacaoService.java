package br.com.camed.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.camed.dto.AplicacaoDTO;
import br.com.camed.entity.Aplicacao;
import br.com.camed.entity.Cliente;
import br.com.camed.entity.Medicamento;
import br.com.camed.mapper.AplicacaoMapper;
import br.com.camed.repositoy.AplicacaoRepository;
import br.com.camed.repositoy.ClienteRepository;
import br.com.camed.repositoy.MedicamentoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AplicacaoService {
	
	@Autowired
    private AplicacaoRepository aplicacaoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private MedicamentoRepository medicamentoRepository;

	
	@Autowired
    private AplicacaoMapper mapper;

    public List<AplicacaoDTO> buscarTodos() {
        return aplicacaoRepository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public AplicacaoDTO buscarPorId(Long id) {
        return aplicacaoRepository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public AplicacaoDTO salvar(AplicacaoDTO dto) {
        if (dto.getClienteId() == null || dto.getMedicamentoId() == null) {
            throw new IllegalArgumentException("IDs de cliente e medicamento são obrigatórios.");
        }

        Medicamento medicamento = medicamentoRepository.findById(dto.getMedicamentoId())
            .orElseThrow(() -> new RuntimeException("Medicamento não encontrado"));

        if (medicamento.getQuantidadeDisponivel() < dto.getDose()) {
            throw new RuntimeException("Estoque insuficiente para aplicação.");
        }

        Cliente cliente = clienteRepository.findById(dto.getClienteId())
            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Aplicacao aplicacao = mapper.toEntity(dto);
        aplicacao.setCliente(cliente);
        aplicacao.setMedicamento(medicamento);
       
        // Atualiza estoque
        medicamento.setQuantidadeDisponivel(medicamento.getQuantidadeDisponivel() - dto.getDose());
        medicamentoRepository.save(medicamento);

        // Atualiza quantidade apos aplicacao
        aplicacao.setQuantidadeDisponivelAposAplicacao(medicamento.getQuantidadeDisponivel());        
        Aplicacao salvo = aplicacaoRepository.save(aplicacao);
        return mapper.toDTO(salvo);
    }


    public AplicacaoDTO atualizar(Long id, AplicacaoDTO dto) {
        Aplicacao existente = aplicacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        dto.setId(id);
        Aplicacao atualizado = mapper.toEntity(dto);
        return mapper.toDTO(aplicacaoRepository.save(atualizado));
    }

    public void remover(Long id) {
    	aplicacaoRepository.deleteById(id);
    }

}
