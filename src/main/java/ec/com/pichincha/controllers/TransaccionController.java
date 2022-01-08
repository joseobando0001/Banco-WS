package ec.com.pichincha.controllers;

import java.sql.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.pichincha.constants.DominiosConstantes;
import ec.com.pichincha.models.Transaccion;
import ec.com.pichincha.repositories.TransaccionRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping(DominiosConstantes.context)
public class TransaccionController {
	public static final Logger logger = LoggerFactory.getLogger(TransaccionController.class);
	@Autowired
	TransaccionRepository repository;

	// Crea una nueva transaccion o edita
	@PostMapping(value = "/transaccion")
	public Transaccion post(@RequestBody Transaccion Transaccion) {
		Transaccion transaccion = repository.save(Transaccion);

		return transaccion;
	}
	
	 //Obtener datos de una transaccion por cuenta 
	@GetMapping(value = "transaccion/{id}")
	public List<Transaccion> findByCuenta(@PathVariable int id) {

		List<Transaccion> transaccion = repository.findByCuenta(id);
		return transaccion;
	}

	 //Obtener datos de una transaccion por fechas
	@GetMapping(value = "transaccionfecha/{id}&{id2}&{id3}")
	public List<Transaccion> findAllByFechaLessThanEqualAndFechaGreaterThanEqualAndCuenta(@PathVariable Date id,@PathVariable Date id2,@PathVariable Integer id3) {

		List<Transaccion> transaccion = repository.findAllByFechaLessThanEqualAndFechaGreaterThanEqualAndCuenta(id,id2,id3);
		return transaccion;
	}

	
	// Funcion Eliminar
		@DeleteMapping(value = "/transaccion/{id}")
		public ResponseEntity deleteById(@PathVariable long id) {
			logger.info("Delete transaccion with id {}", id);
			repository.deleteById(id);
			return new ResponseEntity(true, HttpStatus.OK);
		}
	


}
