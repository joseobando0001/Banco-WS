package ec.com.pichincha;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ec.com.pichincha.controllers.CuentaController;
import ec.com.pichincha.controllers.PersonaController;
import ec.com.pichincha.controllers.TransaccionController;

@RunWith(SpringRunner.class)
@SpringBootTest
class PichinchaApplicationTests {
	@Autowired
	private PersonaController controller;
	
	@Autowired
	private CuentaController ccontroller;
	
	@Autowired
	private TransaccionController tcontroller;

	@Test
	void contextLoadPersona() {
		assertThat(controller).isNotNull();
	}
	
	@Test
	void contextLoadCuenta() {
		assertThat(ccontroller).isNotNull();
	}
	
	@Test
	void contextLoadTransaccion() {
		assertThat(tcontroller).isNotNull();
	}

}
