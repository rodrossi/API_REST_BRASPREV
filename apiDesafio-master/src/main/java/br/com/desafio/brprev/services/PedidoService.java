package br.com.desafio.brprev.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.brprev.entity.Pedido;
import br.com.desafio.brprev.repositories.PedidoRepository;
import br.com.desafio.brprev.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido find(Integer id) {
	Optional<Pedido> obj = repo.findById(id);
	return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));

    }

}
