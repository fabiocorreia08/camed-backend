package br.com.camed.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.camed.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	boolean existsByCpf(String cpf);


}
