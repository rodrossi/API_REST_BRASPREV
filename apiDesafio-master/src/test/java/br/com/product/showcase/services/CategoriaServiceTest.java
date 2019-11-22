package br.com.product.showcase.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.desafio.brprev.entity.Categoria;
import br.com.desafio.brprev.repositories.CategoriaRepository;
import br.com.desafio.brprev.services.CategoriaService;
import br.com.desafio.brprev.services.exceptions.ObjectNotFoundException;

public class CategoriaServiceTest {

    @InjectMocks
    private CategoriaService categoriaService;

    @Mock
    private CategoriaRepository categoriaRepository;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

	@Test
    public void findSuccess() {
        final Categoria categMock = new Categoria();
        final String categoria = "smartphones";
        categMock.setCategoria(categoria);
        when(this.categoriaRepository.findById(1)).thenReturn(Optional.of(categMock));

        Categoria categ = this.categoriaService.find(1);
        assertTrue(categMock.getCategoria().equals(categ.getCategoria()));
    }

    @Test
    public void findNotFound() {
    	final Categoria categMock = new Categoria();
        final String categoria = "smartphones";
        categMock.setCategoria(categoria);
        when(this.categoriaRepository.findById(1)).thenReturn(Optional.of(categMock));

        try {
            this.categoriaService.find(2);
        } catch (ObjectNotFoundException ex) {
            assertEquals("Objeto não encontrado! Id: " + 2 + ", Tipo: " + Categoria.class.getName(), ex.getMessage());
        }
    }
}
