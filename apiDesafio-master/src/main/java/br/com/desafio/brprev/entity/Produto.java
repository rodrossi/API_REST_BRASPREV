package br.com.desafio.brprev.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produto implements Serializable {
	
    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProduto;
	
	private String produto;
	private Double preco;
	private int quantidade;
	private String descricao;
	private byte[] foto;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "PRODUTO_CATEGORIA", joinColumns = @JoinColumn(name = "idProduto"), inverseJoinColumns = @JoinColumn(name = "idCategoria"))
    private List<Categoria> categoria = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "idItem")
    private Set<PedidoItens> itens = new HashSet<>();

    public Produto() {
    }

    public Produto(Integer idProduto, String produto, Double preco, int quantidade, String descricao, byte[] foto) {
    	super();
    	this.idProduto = idProduto;
    	this.produto = produto;
    	this.preco = preco;
    	this.quantidade = quantidade;
    	this.descricao = descricao;
    	this.foto = foto;
    }

    @JsonIgnore
    /*
    public List<Pedido> getPedidos() {
    	List<Pedido> lista = new ArrayList<>();
    	for (PedidoItens x : itens) {
    		lista.add(x.getIdFkPedido());
    		}
    	return lista;
    }
    */

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}

	public Set<PedidoItens> getItens() {
		return itens;
	}

	public void setItens(Set<PedidoItens> itens) {
		this.itens = itens;
	}
	
}
