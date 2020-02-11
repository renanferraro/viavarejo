package br.com.viavarejo.calculoparcelas.service;

import br.com.viavarejo.calculoparcelas.dto.ParcelaDTO;
import br.com.viavarejo.calculoparcelas.dto.RequestConsultarCondicaoPagamento;

public interface CalulaParcelasService {

	ParcelaDTO[] calcularParcelas(final double taxaSelic, RequestConsultarCondicaoPagamento condicaoPagamento);
}
