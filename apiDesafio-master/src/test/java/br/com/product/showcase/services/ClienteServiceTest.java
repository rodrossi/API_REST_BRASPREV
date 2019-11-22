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

import br.com.desafio.brprev.entity.Cliente;
import br.com.desafio.brprev.repositories.ClienteRepository;
import br.com.desafio.brprev.services.ClienteService;
import br.com.desafio.brprev.services.exceptions.ObjectNotFoundException;

public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

	@Test
    public void findSuccess() {
        final Cliente clienteMock = new Cliente();
        final String nomeCliente = "Leonardo";
        final String emailCliente = "leo@gmail.com";
        final String senha = "xxxxxxxxx";
        final String rua = "av proxima da rua";
        final String bairro = "bairro conhecido";
        final String cep = "05711-900";
        
        clienteMock.setNome(nomeCliente);
        clienteMock.setEmail(emailCliente);
        clienteMock.setSenha(senha);
        clienteMock.setRua(rua);
        clienteMock.setBairro(bairro);
        clienteMock.setCep(cep);
        when(this.clienteRepository.findById(1)).thenReturn(Optional.of(clienteMock));

        Cliente cliente = this.clienteService.find(1);
        assertTrue(clienteMock.getNome().equals(cliente.getNome()));
    }

    @Test
    public void findNotFound() {
    	final Cliente clienteMock = new Cliente();
        final String nomeCliente = "Leonardo";
        
        clienteMock.setNome(nomeCliente);
        when(this.clienteRepository.findById(1)).thenReturn(Optional.of(clienteMock));

        try {
            this.clienteService.find(2);
        } catch (ObjectNotFoundException ex) {
            assertEquals("Objeto não encontrado! Id: " + 2 + ", Tipo: " + Cliente.class.getName(), ex.getMessage());
        }
    }

}
