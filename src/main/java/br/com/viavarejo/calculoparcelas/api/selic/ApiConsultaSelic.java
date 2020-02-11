package br.com.viavarejo.calculoparcelas.api.selic;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.viavarejo.calculoparcelas.api.selic.dto.SelicResponse;

@Service
public class ApiConsultaSelic {

	private RestTemplate restTemplate;
	
	@Value("${url.selic}")
	private String url;
	
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public SelicResponse obterUltimoValorSelic() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -1);
		return consultarValorSelic(c.getTime());
	}
	
	public SelicResponse consultarValorSelic(final Date data) {
		final String dataFormatada = sdf.format(data);
		final SelicResponse response = Arrays.asList(consultarValorSelic()).stream().filter(selic -> selic.getData().equals(dataFormatada)).findFirst().orElse(null);
		return response;
	}
	
	public SelicResponse[] consultarValorSelic() {
		final Date dataAtual = new Date();
		//Calcula data inicial de 30 dias atras
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, -30);
		final String dataInicio = sdf.format(calendar.getTime());
		final String dataFim = sdf.format(dataAtual);
		
		restTemplate = new RestTemplate();
		
		final Map<String, String> params = new HashMap<String, String>();
		params.put("dataInicial",dataInicio);
		params.put("dataFinal", dataFim);
		
		final SelicResponse[] response = restTemplate.getForObject(url, SelicResponse[].class, params);
		return response;
	}
}
