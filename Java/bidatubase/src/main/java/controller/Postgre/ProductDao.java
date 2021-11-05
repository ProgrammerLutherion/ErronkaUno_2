package controller.Postgre;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import model.Postgre.ProductTemplate;

@Repository
@Transactional
public class ProductDao {

    // A través de la anotación @PersistenceContext, se inyectará automáticamente
    // un EntityManager producido desde el entityManagerFactory definido en la clase
    // DatabaseConfig.
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Devuelve todos los usuarios de la base de datos.
     */
    @SuppressWarnings("unchecked")
    public List<ProductTemplate> getAll() {
    	return entityManager.createQuery("from ProductTemplate").getResultList();
    }

    /**
     * Devuelve un usuario en base a su Id
     */
    public ProductTemplate getById(long id) {
        return entityManager.find(ProductTemplate.class, id);
    }

    /**
     * Actualiza el usuario proporcionado
     */
    public void update(ProductTemplate peli) {
        entityManager.merge(peli);
        return;
    }
    
}