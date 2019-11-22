package br.com.desafio.brprev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.brprev.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
  
}
