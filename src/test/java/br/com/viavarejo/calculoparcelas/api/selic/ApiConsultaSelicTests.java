package br.com.viavarejo.calculoparcelas.api.selic;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApiConsultaSelicTests {

	@Autowired
	private ApiConsultaSelic api;

	@DisplayName("Test ApiConsultarSelic:consultarValorSelic")
	@Test
	void consultarValorSelic() {
		assertTrue(api.consultarValorSelic().length > 0);
	}
	
	@DisplayName("Test ApiConsultarSelic:consultarValorSelic(data)")
	@Test
	void consultarValorSelicData() {
		final Calendar c = Calendar.getInstance();
		
		assertTrue(api.consultarValorSelic(c.getTime()) == null);
		
		c.add(Calendar.DAY_OF_MONTH, -1);
		assertTrue(api.consultarValorSelic(c.getTime()) != null);
	}
}
