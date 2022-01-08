package ec.com.pichincha.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ec.com.pichincha.models.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {
	List<Persona> findById(long id);
	List<Persona> findByCedula(Integer cedula);
}
