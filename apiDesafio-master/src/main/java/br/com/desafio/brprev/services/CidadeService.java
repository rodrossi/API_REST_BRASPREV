package br.com.desafio.brprev.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.brprev.entity.Cidade;
import br.com.desafio.brprev.repositories.CidadeRepository;
import br.com.desafio.brprev.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repoCidade;

    public Cidade find(Integer id) {
    	Optional<Cidade> obj = repoCidade.findById(id);
    	return obj.orElseThrow(() -> new ObjectNotFoundException(
    		"Objeto não encontrado ! Id: " + id + ", Tipo: " + Cidade.class.getName()));
    }
}
