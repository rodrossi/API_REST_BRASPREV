package br.com.product.showcase.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.desafio.brprev.entity.Cidade;
import br.com.desafio.brprev.repositories.CidadeRepository;
import br.com.desafio.brprev.services.CidadeService;
import br.com.desafio.brprev.services.exceptions.ObjectNotFoundException;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class CidadeServiceTest {

    @InjectMocks
    private CidadeService cidadeService;

    @Mock
    private CidadeRepository cidadeRepository;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

	@Test
    public void findSuccess() {
        final Cidade cidadeMock = new Cidade();
        final String nomeCidade = "Sao Paulo";
        cidadeMock.setNome(nomeCidade);
        when(this.cidadeRepository.findById(1)).thenReturn(Optional.of(cidadeMock));

        Cidade cidade = this.cidadeService.find(1);
        assertTrue(cidadeMock.getNome().equals(cidade.getNome()));
    }

    @Test
    public void findNotFound() {
    	final Cidade cidadeMock = new Cidade();
        final String nomeCidade = "NY";
        cidadeMock.setNome(nomeCidade);
        when(this.cidadeRepository.findById(1)).thenReturn(Optional.of(cidadeMock));

        try {
            this.cidadeService.find(2);
        } catch (ObjectNotFoundException ex) {
            assertEquals("Objeto não encontrado ! Id: " + 2 + ", Tipo: " + Cidade.class.getName(), ex.getMessage());
        }
    }
}