package br.com.camed.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoDTO {
	
	private Long id;
	private String nome;
	private String identificador;
	private Double quantidadeInicial;
	private Double preco;
	private Double quantidadeDisponivel;  

}
