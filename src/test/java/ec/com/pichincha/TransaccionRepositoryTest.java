package ec.com.pichincha;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import ec.com.pichincha.models.Transaccion;
import ec.com.pichincha.repositories.TransaccionRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TransaccionRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TransaccionRepository repository;
    
    @Test
    public void saveTransaccion() {
    	Date date = new Date(1641608987);
        Transaccion transaccion = new Transaccion(date,1);
        entityManager.persistAndFlush(transaccion);
        assertThat(transaccion.getId_transaccion()).isNotNull();
    }
    
    @Test
    public void deleteTransaccion() {
    	Date date = new Date(1641608987);
        entityManager.persistAndFlush(new Transaccion(date,1));
        entityManager.persistAndFlush(new Transaccion(date, 1));

        repository.deleteAll();
        assertThat(repository.findAll()).isEmpty();
    }
}
