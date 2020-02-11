package br.com.viavarejo.calculoparcelas.dto;

import java.util.Arrays;

public class ResponseConsultarCondicaoPagamento {

	private ParcelaDTO[] parcelas;

	public ResponseConsultarCondicaoPagamento() {

	}

	public ResponseConsultarCondicaoPagamento(ParcelaDTO[] parcelas) {
		super();
		this.parcelas = parcelas;
	}

	public ParcelaDTO[] getParcelas() {
		return parcelas;
	}

	public void setParcelas(ParcelaDTO[] parcelas) {
		this.parcelas = parcelas;
	}

	@Override
	public String toString() {
		return "ResponseConsultarCondicaoPagamento [parcelas=" + Arrays.toString(parcelas) + "]";
	}
	
	
	
}
