package br.com.camed.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AplicacaoDTO {

	private Long id;
    private Long clienteId;
    private Long medicamentoId;
    private ClienteDTO clienteDTO;
    private MedicamentoDTO medicamentoDTO;
    private Double dose;
    private Double valorPago;
    private LocalDate data;
    private Double quantidadeDisponivelAposAplicacao; 
	
}
