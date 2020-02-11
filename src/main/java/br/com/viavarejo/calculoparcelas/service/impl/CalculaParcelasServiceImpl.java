package br.com.viavarejo.calculoparcelas.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import br.com.viavarejo.calculoparcelas.dto.ResponseParcela;
import br.com.viavarejo.calculoparcelas.dto.RequestConsultarCondicaoPagamento;
import br.com.viavarejo.calculoparcelas.service.CalulaParcelasService;

@Service
public class CalculaParcelasServiceImpl implements CalulaParcelasService{

	@Override
	public ResponseParcela[] calcularParcelas(double taxaSelic, RequestConsultarCondicaoPagamento condicaoPagamento) {
		
		BigDecimal valorPagar = condicaoPagamento.getProduto().getValor().subtract(condicaoPagamento.getCondicaoPagamento().getValorEntrada()).setScale(2, RoundingMode.HALF_EVEN);
		
		final int qtdeParcelas = condicaoPagamento.getCondicaoPagamento().getQtdeParcelas();
		if(0 == qtdeParcelas || 1 == qtdeParcelas) {
			final ResponseParcela[] parcelas = { new ResponseParcela(qtdeParcelas,
					condicaoPagamento.getProduto().getValor(), 0) };
			return parcelas;
		}else {
			return calcularParcelas(taxaSelic, valorPagar, new BigDecimal(qtdeParcelas).setScale(2, RoundingMode.HALF_EVEN));
		}
	}
	
	private ResponseParcela[] calcularParcelas(double taxaSelic, BigDecimal valorPagar, BigDecimal qtdeParcelas) {
		final ResponseParcela[] parcelas = new ResponseParcela[qtdeParcelas.intValue()];
		final BigDecimal taxa = new BigDecimal(taxaSelic).setScale(6, RoundingMode.HALF_EVEN);
		
		final BigDecimal valorParcela = valorPagar.divide(qtdeParcelas, 2, RoundingMode.HALF_EVEN);
		final BigDecimal valorParcelaJuros = valorParcela.add(valorParcela.multiply(taxa)).setScale(2, RoundingMode.HALF_EVEN);
		
		for(int i = 0; i < qtdeParcelas.intValue(); i++) {
			if(i > 5) {
				parcelas[i] = new ResponseParcela(i + 1, valorParcelaJuros, taxaSelic);
			}else {
				parcelas[i] = new ResponseParcela(i + 1, valorParcela, 0);
			}
		
		}
		
		return parcelas;
	}

	
}
