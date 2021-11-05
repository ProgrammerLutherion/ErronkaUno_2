package controller.SQLserver;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import model.SQLserver.*;
@Repository
@Transactional
public class FakturaDao {
	@PersistenceContext
    private EntityManager entityManager;

    /**
     * Devuelve todos los usuarios de la base de datos.
     */
    @SuppressWarnings("unchecked")
    public List<Fakturak> getAll() {
    	return entityManager.createQuery("from Faktura").getResultList();
    }
    
    public Fakturak getById(long id) {
        return entityManager.find(Fakturak.class, id);
    }

    /**
     * Actualiza el us...uario proporcionado
     */
    public void update(Fakturak film) {
        entityManager.merge(film);
        return;
    }
}
