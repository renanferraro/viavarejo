package br.com.viavarejo.calculoparcelas.dto;

import java.math.BigDecimal;

public class CondicaoPagamentoDTO {

	private BigDecimal valorEntrada;
	private int qtdeParcelas;
	
	public CondicaoPagamentoDTO() {

	}
	
	public CondicaoPagamentoDTO(BigDecimal valorEntrada, int qtdeParcelas) {
		super();
		this.valorEntrada = valorEntrada;
		this.qtdeParcelas = qtdeParcelas;
	}

	public BigDecimal getValorEntrada() {
		return valorEntrada;
	}
	public void setValorEntrada(BigDecimal valorEntrada) {
		this.valorEntrada = valorEntrada;
	}
	public int getQtdeParcelas() {
		return qtdeParcelas;
	}
	public void setQtdeParcelas(int qtdeParcelas) {
		this.qtdeParcelas = qtdeParcelas;
	}
	
	
}
