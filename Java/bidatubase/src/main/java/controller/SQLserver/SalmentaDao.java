package controller.SQLserver;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import model.SQLserver.*;
@Repository
@Transactional
public class SalmentaDao {

	private EntityManager entityManager;

    /**
     * Devuelve todos los usuarios de la base de datos.
     */
    @SuppressWarnings("unchecked")
    public List<Salmentak> getAll() {
    	return entityManager.createQuery("from Salmenta").getResultList();
    }
    
    public Salmentak getById(long id) {
        return entityManager.find(Salmentak.class, id);
    }

    /**
     * Actualiza el us...uario proporcionado
     */
    public void update(Salmentak film) {
        entityManager.merge(film);
        return;
    }
}
