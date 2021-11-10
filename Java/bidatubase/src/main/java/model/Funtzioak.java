package model;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dao.Postgre.AccountMoveDao;
import dao.Postgre.PostgreKonfigurazioa;
import dao.Postgre.ProductDao;
import dao.Postgre.PurchaseOrderDao;
import dao.Postgre.PurchaseOrderLineDao;
import dao.Postgre.ResPartnerDao;
import dao.Postgre.SaleOrderDao;
import dao.SQLserver.BezeroaDao;
import dao.SQLserver.ErosketaDao;
import dao.SQLserver.FakturaDao;
import dao.SQLserver.ProduktuaDao;
import dao.SQLserver.SQLserverKonfigurazioa;
import dao.SQLserver.SalmentaDao;
import entity.Postgre.AccountMove;
import entity.Postgre.ProductTemplate;
import entity.Postgre.PurchaseOrder;
import entity.Postgre.PurchaseOrderLine;
import entity.Postgre.ResPartner;
import entity.Postgre.SaleOrder;
import entity.SQLserver.Bezeroak;
import entity.SQLserver.Erosketak;
import entity.SQLserver.Fakturak;
import entity.SQLserver.Produktuak;
import entity.SQLserver.Salmentak;
import xml.Options;
import xml.User;

public class Funtzioak {

	static ApplicationContext appContext = new AnnotationConfigApplicationContext(SQLserverKonfigurazioa.class);
	static ApplicationContext appContext1 = new AnnotationConfigApplicationContext(PostgreKonfigurazioa.class);

	// Produktuak pasatzea
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

			return true;
		} catch (Exception E) {
			return false;
		}
	}

	public static boolean denaPasatu() {
		boolean ondo = true;

		if (!produktuakPasatu()) {
			ondo = false;
			System.out.println("Produktuak ez dira pasatu");
		}

		if (!bezeroakPasatu()) {
			ondo = false;
			System.out.println("Bezeroak ez dira pasatu");
		}

		if (!salmentakPasatu()) {
			ondo = false;
			System.out.println("Salmentak ez dira pasatu");
		}

		if (!erosketakPasatu()) {
			ondo = false;
			System.out.println("Erosketak ez dira pasatu");
		}

		if (!fakturakPasatu()) {
			ondo = false;
			System.out.println("Fakturak ez dira pasatu");
		}

		return ondo;
	}

	public static boolean xmlAukeratuTaulak() {
		
		try {
		    // create XML file
		    File file = new File("options.xml");

		    // create an instance of `JAXBContext`
		    JAXBContext context = JAXBContext.newInstance(Options.class);

		    // create an instance of `Marshaller`
		    Marshaller marshaller = context.createMarshaller();

		    // enable pretty-print XML output
		    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		    // create user object
		    String[] taulak = {"Bezeroak", "Salmentak","Erosketak"};
		    
		    
		    Options optns = new Options(taulak);

		    // convert user object to XML file
		    marshaller.marshal(optns, file);

		} catch (JAXBException ex) {
		    ex.printStackTrace();
		}
		
		return true;
	}
	
	public static boolean xmlIrakurri() {
		try {
		    // XML file path
		    File file = new File("proba.xml");

		    // create an instance of `JAXBContext`
		    JAXBContext context = JAXBContext.newInstance(User.class);

		    // create an instance of `Unmarshaller`
		    Unmarshaller unmarshaller = context.createUnmarshaller();

		    // convert XML file to user object
		    User user = (User) unmarshaller.unmarshal(file);

		    // print user object
		    System.out.println(user);

		} catch (JAXBException ex) {
		    ex.printStackTrace();
		}
		
		return true;
	}

}
