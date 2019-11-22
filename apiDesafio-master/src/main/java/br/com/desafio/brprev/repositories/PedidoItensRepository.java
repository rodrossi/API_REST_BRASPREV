package br.com.desafio.brprev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.brprev.entity.PedidoItens;

@Repository
public interface PedidoItensRepository extends JpaRepository<PedidoItens, Integer> {
  
  
}
