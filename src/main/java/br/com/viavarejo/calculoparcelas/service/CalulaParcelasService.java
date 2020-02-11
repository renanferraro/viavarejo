package br.com.viavarejo.calculoparcelas.service;

import br.com.viavarejo.calculoparcelas.dto.ResponseParcela;
import br.com.viavarejo.calculoparcelas.dto.RequestConsultarCondicaoPagamento;

public interface CalulaParcelasService {

	ResponseParcela[] calcularParcelas(final double taxaSelic, RequestConsultarCondicaoPagamento condicaoPagamento);
}
