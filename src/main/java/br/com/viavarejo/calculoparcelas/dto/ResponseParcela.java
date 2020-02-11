package br.com.viavarejo.calculoparcelas.dto;

import java.math.BigDecimal;

public class ResponseParcela {

	private int numeroParcela;
	private BigDecimal valor;
	private double taxaJurosAoMes;
	
	public ResponseParcela() {
	}
	
	public ResponseParcela(int numeroParcela, BigDecimal valor, double taxaJurosAoMes) {
		super();
		this.numeroParcela = numeroParcela;
		this.valor = valor;
		this.taxaJurosAoMes = taxaJurosAoMes;
	}
	public int getNumeroParcela() {
		return numeroParcela;
	}
	public void setNumeroParcela(int numeroParcela) {
		this.numeroParcela = numeroParcela;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public double getTaxaJurosAoMes() {
		return taxaJurosAoMes;
	}
	public void setTaxaJurosAoMes(double taxaJurosAoMes) {
		this.taxaJurosAoMes = taxaJurosAoMes;
	}

	@Override
	public String toString() {
		return "ParcelaDTO [numeroParcela=" + numeroParcela + ", valor=" + valor + ", taxaJurosAoMes=" + taxaJurosAoMes
				+ "]";
	}
}
