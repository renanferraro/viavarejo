package br.com.viavarejo.calculoparcelas.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.viavarejo.calculoparcelas.api.selic.ApiConsultaSelic;
import br.com.viavarejo.calculoparcelas.api.selic.dto.SelicResponse;
import br.com.viavarejo.calculoparcelas.dto.ParcelaDTO;
import br.com.viavarejo.calculoparcelas.dto.RequestConsultarCondicaoPagamento;
import br.com.viavarejo.calculoparcelas.dto.ResponseConsultarCondicaoPagamento;
import br.com.viavarejo.calculoparcelas.service.CalulaParcelasService;

@Service
public class CalculaParcelasBusiness {

	@Autowired
	private ApiConsultaSelic apiConsultaSelic;
	
	@Autowired
	private CalulaParcelasService service;
	
	public ResponseConsultarCondicaoPagamento calcularParcelas(final RequestConsultarCondicaoPagamento request) {
		final SelicResponse selicResponse = apiConsultaSelic.obterUltimoValorSelic();
		final ParcelaDTO[] parcelaDTOs = service.calcularParcelas(selicResponse.getValor(), request);
		
		return new ResponseConsultarCondicaoPagamento(parcelaDTOs);
	}
	
}
