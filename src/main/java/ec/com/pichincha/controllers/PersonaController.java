package ec.com.pichincha.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.pichincha.constants.DominiosConstantes;
import ec.com.pichincha.models.Persona;
import ec.com.pichincha.repositories.PersonaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping(DominiosConstantes.context)
public class PersonaController {

	@Autowired
	PersonaRepository repository;

	// Crea una nueva persona o editar
	@PostMapping(value = "/persona")
	public Persona post(@RequestBody Persona Persona) {
		Persona persona = repository.save(Persona);

		return persona;
	}
	


}
