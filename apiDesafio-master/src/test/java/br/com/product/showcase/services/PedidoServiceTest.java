package br.com.product.showcase.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.desafio.brprev.entity.Pedido;
import br.com.desafio.brprev.repositories.PedidoRepository;
import br.com.desafio.brprev.services.PedidoService;
import br.com.desafio.brprev.services.exceptions.ObjectNotFoundException;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class PedidoServiceTest {

    @InjectMocks
    private PedidoService pedidoService;

    @Mock
    private PedidoRepository pedidoRepository;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findSuccess() {
        final Pedido pedidoMock = new Pedido();
        pedidoMock.setSessao("teste");
        when(this.pedidoRepository.findById(1)).thenReturn(Optional.of(pedidoMock));

        Pedido pedido = this.pedidoService.find(1);
        assertTrue(pedidoMock.getSessao().equals(pedido.getSessao()));
    }

    @Test
    public void findNotFound() {
        final Pedido pedidoMock = new Pedido();
        pedidoMock.setSessao("teste");
        when(this.pedidoRepository.findById(1)).thenReturn(Optional.of(pedidoMock));

        try {
            this.pedidoService.find(2);
        } catch (ObjectNotFoundException ex) {
            assertEquals("Objeto não encontrado! Id: " + 2 + ", Tipo: " + Pedido.class.getName(), ex.getMessage());
        }
    }
}
