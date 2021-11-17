package model;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class SqlServerDao {
	@PersistenceContext
    private EntityManager entityManager;

    /**
     * Devuelve todos los usuarios de la base de datos.
     */
    @SuppressWarnings("unchecked")
    public List<Bezeroak> getAllBezeroak() {
    	return entityManager.createQuery("from Bezeroak").getResultList();
    }
    
    public Bezeroak getBezeroakById(int id) {
        return entityManager.find(Bezeroak.class, id);
    }

    /**
     * Actualiza el us...uario proporcionado
     */
    public void update(Bezeroak film) {
        entityManager.merge(film);
        return;
    }
    
    @SuppressWarnings("unchecked")
    public List<Erosketak> getAllErosketak() {
    	return entityManager.createQuery("from Erosketak").getResultList();
    }

    public Erosketak getErosketakById(long id) {
        return entityManager.find(Erosketak.class, id);
    }

    /**
     * Actualiza el us...uario proporcionado
     */
    public void update(Erosketak film) {
        entityManager.merge(film);
        return;
    }
    
    @SuppressWarnings("unchecked")
    public List<Fakturak> getAllFakturak() {
    	return entityManager.createQuery("from Faktura").getResultList();
    }
    
    public Fakturak getFakturakById(long id) {
        return entityManager.find(Fakturak.class, id);
    }

    /**
     * Actualiza el us...uario proporcionado
     */
    public void update(Fakturak film) {
        entityManager.merge(film);
        return;
    }
    
    @SuppressWarnings("unchecked")
    public List<Produktuak> getAllProduktuak() {
    	return entityManager.createQuery("from Produktua").getResultList();
    }
    
    public Produktuak getProduktuakById(int id) {
        return entityManager.find(Produktuak.class, id);
    }

    /**
     * Actualiza el us...uario proporcionado
     */
    public void update(Produktuak film) {
        entityManager.merge(film);
        return;
    }
    
    @SuppressWarnings("unchecked")
    public List<Salmentak> getAllSalmentak() {
    	return entityManager.createQuery("from Salmenta").getResultList();
    }
    
    public Salmentak getSalmentakById(long id) {
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
