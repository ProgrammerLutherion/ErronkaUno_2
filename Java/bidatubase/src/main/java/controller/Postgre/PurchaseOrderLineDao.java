package controller.Postgre;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import model.Postgre.*;
import model.SQLserver.Bezeroak;

@Repository
@Transactional
public class PurchaseOrderLineDao {
    // A través de la anotación @PersistenceContext, se inyectará automáticamente
    // un EntityManager producido desde el entityManagerFactory definido en la clase
    // DatabaseConfig.
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Devuelve todos los usuarios de la base de datos.
     */
    @SuppressWarnings("unchecked")
    public List<PurchaseOrderLine> getAll() {
    	return entityManager.createQuery("from PurchaseOrderLine").getResultList();
    }
    public Bezeroak getById(int id) {
        return entityManager.find(Bezeroak.class, id);
    }
    
}