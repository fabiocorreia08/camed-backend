package br.com.camed.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.camed.entity.Medicamento;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long>{

	 boolean existsByIdentificadorIgnoreCase(String identificador);

	
}
