package ec.com.pichincha.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.pichincha.constants.DominiosConstantes;
import ec.com.pichincha.models.Cuenta;
import ec.com.pichincha.repositories.CuentaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping(DominiosConstantes.context)
public class CuentaController {
	@Autowired
	CuentaRepository crepository;
	
	// Muestra todas las cuentas

		@GetMapping("/cuentas")
		public List<Cuenta> getAllCuentas() {
			System.out.println("Get all Cuentas ...");

			List<Cuenta> cuenta = new ArrayList<>();
			crepository.findAll().forEach(cuenta::add);

			return cuenta;
		}

	// Crea una nueva cuenta o editar
	@PostMapping(value = "/cuenta")
	public Cuenta post(@RequestBody Cuenta Cuenta) {
		Cuenta cuenta = crepository.save(Cuenta);

		return cuenta;
	}
	
	// Obtener datos de una cuenta por cliente 
	@GetMapping(value = "cuenta/{id}")
	public List<Cuenta> findByPersona(@PathVariable int id) {

		List<Cuenta> cuenta = crepository.findByPersona(id);
		return cuenta;
	}
}
