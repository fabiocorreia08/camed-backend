package br.com.camed.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String identificador;
    private Double quantidadeInicial;
    private Double preco;
    private Double quantidadeDisponivel;    
    //@OneToMany(mappedBy = "medicamento", cascade = CascadeType.REMOVE, orphanRemoval = true)
    //private List<Aplicacao> aplicacoes;
    

}
