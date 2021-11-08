package controller.SQLserver;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import model.SQLserver.*;
@Repository
@Transactional
public class BezeroaDao {
	@PersistenceContext
    private EntityManager entityManager;

    /**
     * Devuelve todos los usuarios de la base de datos.
     */
    @SuppressWarnings("unchecked")
    public List<Bezeroak> getAll() {
    	return entityManager.createQuery("from Bezeroa").getResultList();
    }
    
    public Bezeroak getById(int id) {
        return entityManager.find(Bezeroak.class, id);
    }

    /**
     * Actualiza el us...uario proporcionado
     */
    public void update(Bezeroak film) {
        entityManager.merge(film);
        return;
    }
}
