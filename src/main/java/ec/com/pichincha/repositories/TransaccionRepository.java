package ec.com.pichincha.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ec.com.pichincha.models.Transaccion;

public interface TransaccionRepository extends CrudRepository<Transaccion, Long> {
	List<Transaccion> findById(long id);
	List<Transaccion> findByCuenta(int id_cuenta);
	List<Transaccion> findAllByFechaLessThanEqualAndFechaGreaterThanEqualAndCuenta(Date fecha, Date fecha2, int id_cuenta);

}
