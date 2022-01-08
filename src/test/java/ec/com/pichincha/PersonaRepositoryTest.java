package ec.com.pichincha;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import ec.com.pichincha.models.Persona;
import ec.com.pichincha.repositories.PersonaRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonaRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonaRepository repository;
    
    @Test
    public void savePersona() {
        Persona persona = new Persona("Jose Obando","Masculino","1718552365",1);
        entityManager.persistAndFlush(persona);
        assertThat(persona.getId_persona()).isNotNull();
    }
    
    @Test
    public void deletePersona() {
        entityManager.persistAndFlush(new Persona("Jose Obando", "Masculino", "1718552365",1));
        entityManager.persistAndFlush(new Persona("Bronco Perez", "Masculino", "1102196705", 1));

        repository.deleteAll();
        assertThat(repository.findAll()).isEmpty();
    }
}
