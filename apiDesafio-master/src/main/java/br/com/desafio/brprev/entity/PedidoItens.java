package br.com.desafio.brprev.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PedidoItens implements Serializable {
	
    private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idItem;
	
    @JsonIgnore
    private ProdutoFK idFkProduto = new ProdutoFK();
    
    @JsonIgnore
    private PedidoFK idFkPedido = new PedidoFK();

    private String nmProduto;
    private Double valor;
    private Integer quantidade;
    private Double subtotal;
    
    public PedidoItens () {
    }

    public PedidoItens(Produto produto, Pedido pedido, String nmProduto, Double valor, Integer quantidade
    		, Double subtotal) {
    	super();
    	idFkProduto.setProduto(produto);
    	idFkPedido.setPedido(pedido);
    	this.nmProduto = nmProduto;
    	this.valor = valor;
    	this.quantidade = quantidade;
    	this.subtotal = subtotal;
    }
    
    @JsonIgnore   
	public String getNmProduto() {
		return nmProduto;
	}

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public ProdutoFK getIdFkProduto() {
		return idFkProduto;
	}

	public void setIdFkProduto(ProdutoFK idFkProduto) {
		this.idFkProduto = idFkProduto;
	}

	public PedidoFK getIdFkPedido() {
		return idFkPedido;
	}

	public void setIdFkPedido(PedidoFK idFkPedido) {
		this.idFkPedido = idFkPedido;
	}

	public void setNmProduto(String nmProduto) {
		this.nmProduto = nmProduto;
	}

	public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
	
}
