package br.com.viavarejo.calculoparcelas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.viavarejo.calculoparcelas.business.CalculaParcelasBusiness;
import br.com.viavarejo.calculoparcelas.dto.ResponseParcela;
import br.com.viavarejo.calculoparcelas.dto.RequestConsultarCondicaoPagamento;

@RestController
public class ApiController {

	@Autowired
	private CalculaParcelasBusiness calculaParcelasBusiness;

	@PatchMapping(path="/condicoesPagamento", produces = "application/json; charset=UTF-8")
	public ResponseParcela[] consultarCondicoesPagamento(
			@RequestBody(required = true) RequestConsultarCondicaoPagamento request) {
		return calculaParcelasBusiness.calcularParcelas(request);
	}

}
