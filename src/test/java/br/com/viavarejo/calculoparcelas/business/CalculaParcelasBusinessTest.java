package br.com.viavarejo.calculoparcelas.business;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.viavarejo.calculoparcelas.dto.CondicaoPagamentoDTO;
import br.com.viavarejo.calculoparcelas.dto.ProdutoDTO;
import br.com.viavarejo.calculoparcelas.dto.RequestConsultarCondicaoPagamento;
import br.com.viavarejo.calculoparcelas.dto.ResponseParcela;

@SpringBootTest
public class CalculaParcelasBusinessTest {

	@Autowired
	private CalculaParcelasBusiness business;
	
	@DisplayName("Test CalculaParcelasBusinessTest:calcularParcelaCondicao1")
	@Test
	void calcularParcelaCondicao1() {
		RequestConsultarCondicaoPagamento request = new RequestConsultarCondicaoPagamento();
		request.setCondicaoPagamento(new CondicaoPagamentoDTO(BigDecimal.ZERO, 1));
		request.setProduto(new ProdutoDTO(1, "Geladeira", new BigDecimal(1000)));
		ResponseParcela[] response = business.calcularParcelas(request);
		System.out.println("Response 1: " + response.toString());
		assertTrue(response.length == request.getCondicaoPagamento().getQtdeParcelas());
	}

	@DisplayName("Test CalculaParcelasBusinessTest:calcularParcelaCondicao2")
	@Test
	void calcularParcelaCondicao2() {
		RequestConsultarCondicaoPagamento request = new RequestConsultarCondicaoPagamento();
		request.setCondicaoPagamento(new CondicaoPagamentoDTO(new BigDecimal(100), 5));
		request.setProduto(new ProdutoDTO(1, "Geladeira", new BigDecimal(1000)));
		ResponseParcela[] response = business.calcularParcelas(request);
		System.out.println("Response 2: " + response.toString());
		assertTrue(response.length == request.getCondicaoPagamento().getQtdeParcelas());
	}
	
	
	@DisplayName("Test CalculaParcelasBusinessTest:calcularParcelaCondicao3")
	@Test
	void calcularParcelaCondicao3() {
		RequestConsultarCondicaoPagamento request = new RequestConsultarCondicaoPagamento();
		request.setCondicaoPagamento(new CondicaoPagamentoDTO(BigDecimal.ZERO, 6));
		request.setProduto(new ProdutoDTO(1, "Geladeira", new BigDecimal(1000)));
		ResponseParcela[] response = business.calcularParcelas(request);
		System.out.println("Response 3: " + response.toString());
		assertTrue(response.length == request.getCondicaoPagamento().getQtdeParcelas());
	}
	
	@DisplayName("Test CalculaParcelasBusinessTest:calcularParcelaCondicao4")
	@Test
	void calcularParcelaCondicao4() {
		RequestConsultarCondicaoPagamento request = new RequestConsultarCondicaoPagamento();
		request.setCondicaoPagamento(new CondicaoPagamentoDTO(BigDecimal.ZERO, 7));
		request.setProduto(new ProdutoDTO(1, "Geladeira", new BigDecimal(1000)));
		ResponseParcela[] response = business.calcularParcelas(request);
		System.out.println("Response 4: " + response.toString());
		assertTrue(response.length == request.getCondicaoPagamento().getQtdeParcelas());
	}
}
