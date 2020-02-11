package br.com.viavarejo.calculoparcelas.dto;

import java.math.BigDecimal;

public class ProdutoDTO {

	private int codigo;
	private String nome;
	private BigDecimal valor;
	
	public ProdutoDTO() {

	}
	
	public ProdutoDTO(int codigo, String nome, BigDecimal valor) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
}
