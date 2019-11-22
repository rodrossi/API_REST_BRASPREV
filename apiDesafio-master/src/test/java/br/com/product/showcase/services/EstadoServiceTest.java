package br.com.product.showcase.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.desafio.brprev.entity.Estado;
import br.com.desafio.brprev.repositories.EstadoRepository;
import br.com.desafio.brprev.services.EstadoService;
import br.com.desafio.brprev.services.exceptions.ObjectNotFoundException;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class EstadoServiceTest {

	   @InjectMocks
	    private EstadoService estadoService;

	    @Mock
	    private EstadoRepository estadoRepository;

	    @Before
	    public void init() throws Exception {
	        MockitoAnnotations.initMocks(this);
	    }

		@Test
	    public void findSuccess() {
	        final Estado estadoMock = new Estado();
	        final String nomeEstado = "Sao Paulo - Capital";
	        estadoMock.setNome(nomeEstado);
	        when(this.estadoRepository.findById(1)).thenReturn(Optional.of(estadoMock));

	        Estado estado = this.estadoService.find(1);
	        assertTrue(estadoMock.getNome().equals(estado.getNome()));
	    }

	    @Test
	    public void findNotFound() {
	    	final Estado estadoMock = new Estado();
	        final String nomeEstado = "EUA";
	        estadoMock.setNome(nomeEstado);
	        when(this.estadoRepository.findById(1)).thenReturn(Optional.of(estadoMock));

	        try {
	            this.estadoService.find(2);
	        } catch (ObjectNotFoundException ex) {
	            assertEquals("Objeto não encontrado! Id: " + 2 + ", Tipo: " + Estado.class.getName(), ex.getMessage());
	        }
	    }

}
