package br.com.camed.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aplicacao {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "medicamento_id")
    private Medicamento medicamento;

    @Column(nullable = false)
    private Double dose;

    @Column(name = "valor_pago", nullable = false)
    private Double valorPago;

    @Column(nullable = false)
    private LocalDate data;
    
    @Column(nullable = false)
    private Double quantidadeDisponivelAposAplicacao; 

}
