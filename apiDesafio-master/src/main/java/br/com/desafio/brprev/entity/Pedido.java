package br.com.desafio.brprev.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pedido implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;
    
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date data;
	
	@ManyToOne
	@JoinColumn (name = "idCliente")
	private Cliente cliente;

	private boolean status;
	private String sessao;
	
    @OneToMany(mappedBy = "idItem")
    private Set<PedidoItens> itens = new HashSet<>();

    public Pedido() {
    }

    public Pedido(Integer idPedido, Date data, Cliente cliente, Boolean status, String sessao) {
    	super();
    	this.idPedido = idPedido;
    	this.data = data;
    	this.cliente = cliente;
    	this.status = status;
    	this.sessao = sessao;
    }

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getSessao() {
		return sessao;
	}

	public void setSessao(String sessao) {
		this.sessao = sessao;
	}

	public Set<PedidoItens> getItens() {
		return itens;
	}

	public void setItens(Set<PedidoItens> itens) {
		this.itens = itens;
	}
	
}
