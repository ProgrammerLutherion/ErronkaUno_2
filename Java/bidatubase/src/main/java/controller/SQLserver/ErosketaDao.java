package controller.SQLserver;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import model.SQLserver.*;

@Repository
@Transactional
public class ErosketaDao {

    // A través de la anotación @PersistenceContext, se inyectará automáticamente
    // un EntityManager producido desde el entityManagerFactory definido en la clase
    // DatabaseConfig.
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Devuelve todos los usuarios de la base de datos.
     */
    @SuppressWarnings("unchecked")
    public List<Erosketak> getAll() {
    	return entityManager.createQuery("from Erosketa").getResultList();
    }

    public Erosketak getById(long id) {
        return entityManager.find(Erosketak.class, id);
    }

    /**
     * Actualiza el us...uario proporcionado
     */
    public void update(Erosketak film) {
        entityManager.merge(film);
        return;
    }
    
}