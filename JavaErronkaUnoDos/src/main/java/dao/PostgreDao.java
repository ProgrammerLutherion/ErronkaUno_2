package dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import entities.AccountMove;
import entities.Bezeroak;
import entities.PaymentTransaction;
import entities.ProductTemplate;
import entities.PurchaseOrder;
import entities.PurchaseOrderLine;
import entities.ResPartner;
import entities.SaleOrder;
import entities.SaleOrderLine;

@Repository
@Transactional
public class PostgreDao {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Devuelve todos los ... de la base de datos.
	 */
	@SuppressWarnings("unchecked")
	public List<ResPartner> getAllResPartner() {
		return entityManager.createQuery("from ResPartner").getResultList();
	}

	/**
	 * Devuelve un ... en base a su Id
	 */
	public ResPartner getResPartnerById(long id) {
		return entityManager.find(ResPartner.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<AccountMove> getAllAccountMove() {
		return entityManager.createQuery("from AccountMove").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PaymentTransaction> getAllPaymentTransaction() {
		return entityManager.createQuery("from PaymentTransaction").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<ProductTemplate> getAllProductTemplate() {
		return entityManager.createQuery("from ProductTemplate").getResultList();
	}

	/**
	 * Devuelve un usuario en base a su Id
	 */
	public ProductTemplate getProductTemplateById(long id) {
		return entityManager.find(ProductTemplate.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<PurchaseOrder> getAllPurchaseOrder() {
		return entityManager.createQuery("from PurchaseOrder").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<PurchaseOrderLine> getAllPurchaseOrderLine() {
		return entityManager.createQuery("from PurchaseOrderLine").getResultList();
	}

	public Bezeroak getPurchaseOrderLineById(int id) {
		return entityManager.find(Bezeroak.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<SaleOrder> getAllSaleOrder() {
		return entityManager.createQuery("from SaleOrder").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<SaleOrderLine> getAllSaleOrderLine() {
		return entityManager.createQuery("from SaleOrderLine").getResultList();
	}

}