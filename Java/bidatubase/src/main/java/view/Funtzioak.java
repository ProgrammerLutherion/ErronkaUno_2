package view;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import controller.Postgre.AccountMoveDao;
import controller.Postgre.PostgreKonfigurazioa;
import controller.Postgre.ProductDao;
import controller.Postgre.PurchaseOrderDao;
import controller.Postgre.PurchaseOrderLineDao;
import controller.Postgre.ResPartnerDao;
import controller.Postgre.SaleOrderDao;
import controller.SQLserver.BezeroaDao;
import controller.SQLserver.ErosketaDao;
import controller.SQLserver.FakturaDao;
import controller.SQLserver.ProduktuaDao;
import controller.SQLserver.SQLserverKonfigurazioa;
import controller.SQLserver.SalmentaDao;
import model.Postgre.AccountMove;
import model.Postgre.ProductTemplate;
import model.Postgre.PurchaseOrder;
import model.Postgre.PurchaseOrderLine;
import model.Postgre.ResPartner;
import model.Postgre.SaleOrder;
import model.SQLserver.Bezeroak;
import model.SQLserver.Erosketak;
import model.SQLserver.Fakturak;
import model.SQLserver.Produktuak;
import model.SQLserver.Salmentak;

public class Funtzioak {

	static // Produktuak pasatzea
	ApplicationContext appContext = new AnnotationConfigApplicationContext(SQLserverKonfigurazioa.class);
	static ApplicationContext appContext1 = new AnnotationConfigApplicationContext(PostgreKonfigurazioa.class);

	public static boolean produktuakPasatu() {

		try {
			ProduktuaDao produktuaSql = appContext.getBean(ProduktuaDao.class);
			ProductDao productPostgre = appContext1.getBean(ProductDao.class);

			ArrayList<ProductTemplate> plist = new ArrayList<ProductTemplate>();
			plist = (ArrayList<ProductTemplate>) productPostgre.getAll();

			for (ProductTemplate i : plist) {
				Produktuak p = new Produktuak();
				p.setId(i.getId());
				p.setIzena(i.getName());
				p.setDeskripzioa(i.getDescriptionSale());
				p.setBolumena(i.getVolume().floatValue());
				p.setPisua(i.getWeight().floatValue());
				p.setPrezioa(i.getListPrice().floatValue());
				produktuaSql.update(p);
			}
			((AnnotationConfigApplicationContext) appContext).close();
			((AnnotationConfigApplicationContext) appContext1).close();
			return true;
		} catch (Exception E) {
			return false;
		}
	}

	// Bezeroak pasatzea

	public static boolean bezeroakPasatu() {
		try {
			BezeroaDao bezeroSql = appContext.getBean(BezeroaDao.class);
			ResPartnerDao bezeroPostgre = appContext1.getBean(ResPartnerDao.class);

			ArrayList<ResPartner> bezerolist = new ArrayList<ResPartner>();
			bezerolist = (ArrayList<ResPartner>) bezeroPostgre.getAll();

			for (ResPartner i : bezerolist) {
				Bezeroak p = new Bezeroak();
				p.setId(i.getId());
				p.setIzena(i.getName());
				p.setEmaila(i.getEmail());
				bezeroSql.update(p);
			}
			((AnnotationConfigApplicationContext) appContext).close();
			((AnnotationConfigApplicationContext) appContext1).close();
			return true;
		} catch (Exception E) {
			return false;
		}
	}

	// Salmentak pasatzea

	public static boolean salmentakPasatu() {
		try {

			SalmentaDao salmentakSql = appContext.getBean(SalmentaDao.class);
			SaleOrderDao salmentakPostgre = appContext1.getBean(SaleOrderDao.class);
			BezeroaDao bezDao = appContext.getBean(BezeroaDao.class);

			ArrayList<SaleOrder> salmetalist = new ArrayList<SaleOrder>();
			salmetalist = (ArrayList<SaleOrder>) salmentakPostgre.getAll();

			for (SaleOrder i : salmetalist) {
				Salmentak p = new Salmentak();
				p.setId(i.getId());
				p.setZenbakia(i.getName());
				p.setData(i.getDateOrder().toString());
				p.setGuztira(i.getAmountTotal().floatValue());
				p.setEgoera(i.getState());
				p.setBezeroak1(bezDao.getById(Math.toIntExact(i.getPartnerId())));

				salmentakSql.update(p);

			}
			((AnnotationConfigApplicationContext) appContext).close();
			((AnnotationConfigApplicationContext) appContext1).close();
			return true;
		} catch (Exception E) {
			return false;
		}

	}

	// Erosketak pasatzea

	public static boolean erosketakPasatu() {
		try {

			ErosketaDao erosketakSql = appContext.getBean(ErosketaDao.class);
			PurchaseOrderDao erosketakPostgre = appContext1.getBean(PurchaseOrderDao.class);
			PurchaseOrderLineDao erosketaLinePostgre = appContext1.getBean(PurchaseOrderLineDao.class);
			ProduktuaDao produktuaSql = appContext.getBean(ProduktuaDao.class);
			BezeroaDao bezDao = appContext.getBean(BezeroaDao.class);

			ArrayList<PurchaseOrder> eroslist = new ArrayList<PurchaseOrder>();
			eroslist = (ArrayList<PurchaseOrder>) erosketakPostgre.getAll();
			ArrayList<PurchaseOrderLine> eroslinelist = new ArrayList<PurchaseOrderLine>();
			eroslinelist = (ArrayList<PurchaseOrderLine>) erosketaLinePostgre.getAll();

			for (PurchaseOrder i : eroslist) {
				Erosketak p = new Erosketak();
				p.setErreferentzia(i.getName());
				p.setBezeroak1(bezDao.getById(Math.toIntExact(i.getPartnerId())));
				p.setBezeroak2(bezDao.getById(Math.toIntExact(i.getUserId())));
				p.setGuztira(i.getAmountTotal());
				p.setEgoera(i.getState());

				PurchaseOrderLine purline = new PurchaseOrderLine();
				for (PurchaseOrderLine j : eroslinelist) {
					if (j.getPurchaseOrder().getId() == i.getId()) {
						purline = j;
						Produktuak prod = produktuaSql.getById(Math.toIntExact(j.getProductId()));
						System.out.println(prod);
						p.setProduktuak(prod);

						p.setKopurua(purline.getProductQty());
						p.setId(purline.getId());
						erosketakSql.update(p);
					}
				}
			}
			((AnnotationConfigApplicationContext) appContext).close();
			((AnnotationConfigApplicationContext) appContext1).close();
			return true;
		} catch (Exception E) {
			return false;
		}
	}

	// Fakturak pasatzea

	public static boolean fakturakPasatu() {
		try {
			FakturaDao fakturakSql = appContext.getBean(FakturaDao.class);
			AccountMoveDao fakturakPostgre = appContext1.getBean(AccountMoveDao.class);
			BezeroaDao bezDao = appContext.getBean(BezeroaDao.class);

			ArrayList<AccountMove> faklist = new ArrayList<AccountMove>();
			faklist = (ArrayList<AccountMove>) fakturakPostgre.getAll();

			for (AccountMove i : faklist) {
				Fakturak p = new Fakturak();
				p.setId(i.getId());
				p.setIzena(i.getName());

				Format formatter = new SimpleDateFormat("yyyy-MM-dd");
				String sdata = formatter.format(i.getDate());

				p.setData(sdata);

				p.setBezeroak(bezDao.getById(Math.toIntExact(i.getPartnerId())));
				p.setBez(i.getAmountTax());
				p.setGuztira(i.getAmountTotal());
				p.setEgoera(i.getPaymentState());
				fakturakSql.update(p);
			}
			((AnnotationConfigApplicationContext) appContext).close();
			((AnnotationConfigApplicationContext) appContext1).close();
			return true;
		} catch (Exception E) {
			return false;
		}
	}
}
