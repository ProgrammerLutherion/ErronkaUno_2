package dao.SQLserver;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import entity.SQLserver.*;
@Repository
@Transactional
public class ProduktuaDao {
	@PersistenceContext
    private EntityManager entityManager;

    /**
     * Devuelve todos los usuarios de la base de datos.
     */
    @SuppressWarnings("unchecked")
    public List<Produktuak> getAll() {
    	return entityManager.createQuery("from Produktua").getResultList();
    }
    
    public Produktuak getById(int id) {
        return entityManager.find(Produktuak.class, id);
    }

    /**
     * Actualiza el us...uario proporcionado
     */
    public void update(Produktuak film) {
        entityManager.merge(film);
        return;
    }
    
    public void create(Produktuak film) {
        entityManager.persist(film);
        return;
    }
}
