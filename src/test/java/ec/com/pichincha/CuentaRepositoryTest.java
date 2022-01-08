package ec.com.pichincha;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import ec.com.pichincha.models.Cuenta;
import ec.com.pichincha.repositories.CuentaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CuentaRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CuentaRepository crepository;
    
    @Test
    public void saveCuenta() {
        Cuenta cuenta = new Cuenta("AHORROS1","Ahorros",1,5);
        entityManager.persistAndFlush(cuenta);
        assertThat(cuenta.getId_cuenta()).isNotNull();
    }
    
    @Test
    public void deleteCuenta() {
        entityManager.persistAndFlush(new Cuenta("AHORROS1","Ahorros",1,1));
        entityManager.persistAndFlush(new Cuenta("CORRIENTE2","Corriente",1,1));

        crepository.deleteAll();
        assertThat(crepository.findAll()).isEmpty();
    }
}