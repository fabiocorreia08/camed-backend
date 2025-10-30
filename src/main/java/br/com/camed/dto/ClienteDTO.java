package br.com.camed.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String telefone;    
    private Integer idade;
    private Double altura;
    private Double peso;    
    private LocalDate dataCadastro;

}
