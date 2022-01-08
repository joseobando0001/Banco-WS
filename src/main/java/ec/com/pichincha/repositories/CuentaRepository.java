package ec.com.pichincha.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ec.com.pichincha.models.Cuenta;

public interface CuentaRepository extends CrudRepository<Cuenta, Long> {
	List<Cuenta> findById(long id);
	List<Cuenta> findByPersona(int persona);
}
