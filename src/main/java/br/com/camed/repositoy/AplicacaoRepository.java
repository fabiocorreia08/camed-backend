package br.com.camed.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.camed.entity.Aplicacao;

@Repository
public interface AplicacaoRepository extends JpaRepository<Aplicacao, Long>{
}
