package br.com.viavarejo.calculoparcelas.dto;

public class RequestConsultarCondicaoPagamento {

	private ProdutoDTO produto;
	private CondicaoPagamentoDTO condicaoPagamento;
	public ProdutoDTO getProduto() {
		return produto;
	}
	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}
	public CondicaoPagamentoDTO getCondicaoPagamento() {
		return condicaoPagamento;
	}
	public void setCondicaoPagamento(CondicaoPagamentoDTO condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}
}
