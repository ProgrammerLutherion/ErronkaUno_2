package model;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import xml.*;

public class Funtzioak {

	static ApplicationContext appContext = new AnnotationConfigApplicationContext(DbKonfigSQL.class);
	static ApplicationContext appContext1 = new AnnotationConfigApplicationContext(DbKonfigPostgre.class);
	
	static PostgreDao pd = appContext1.getBean(PostgreDao.class);
	static SqlServerDao sd = appContext.getBean(SqlServerDao.class);

	static Scanner sc = new Scanner(System.in);

	// Produktuak pasatzea
	public static boolean produktuakPasatu() {

		try {

			ArrayList<ProductTemplate> plist = new ArrayList<ProductTemplate>();
			plist = (ArrayList<ProductTemplate>) pd.getAllProductTemplate();

			for (ProductTemplate i : plist) {
				Produktuak p = new Produktuak();
				p.setId(i.getId());
				p.setIzena(i.getName());
				p.setDeskripzioa(i.getDescriptionSale());
				p.setBolumena(i.getVolume().floatValue());
				p.setPisua(i.getWeight().floatValue());
				p.setPrezioa(i.getListPrice().floatValue());
				sd.update(p);
			}

			return true;
		} catch (Exception E) {
			return false;
		}
	}

	// Bezeroak pasatzea

	public static boolean bezeroakPasatu() {
		try {

			ArrayList<ResPartner> bezerolist = new ArrayList<ResPartner>();
			bezerolist = (ArrayList<ResPartner>) pd.getAllResPartner();

			for (ResPartner i : bezerolist) {
				Bezeroak p = new Bezeroak();
				p.setId(i.getId());
				p.setIzena(i.getName());
				p.setEmaila(i.getEmail());
				sd.update(p);
			}

			return true;
		} catch (Exception E) {
			return false;
		}
	}

	// Salmentak pasatzea

	public static boolean salmentakPasatu() {
		try {

			ArrayList<SaleOrder> salmetalist = new ArrayList<SaleOrder>();
			salmetalist = (ArrayList<SaleOrder>) pd.getAllSaleOrder();

			for (SaleOrder i : salmetalist) {
				Salmentak p = new Salmentak();
				p.setId(i.getId());
				p.setZenbakia(i.getName());
				p.setData(i.getDateOrder().toString());
				p.setGuztira(i.getAmountTotal().floatValue());
				p.setEgoera(i.getState());
				p.setBezeroak1(sd.getBezeroakById(Math.toIntExact(i.getPartnerId())));

				sd.update(p);

			}

			return true;
		} catch (Exception E) {
			return false;
		}

	}

	// Erosketak pasatzea

	public static boolean erosketakPasatu() {
		try {

			ArrayList<PurchaseOrder> eroslist = new ArrayList<PurchaseOrder>();
			eroslist = (ArrayList<PurchaseOrder>) pd.getAllPurchaseOrder();
			ArrayList<PurchaseOrderLine> eroslinelist = new ArrayList<PurchaseOrderLine>();
			eroslinelist = (ArrayList<PurchaseOrderLine>) pd.getAllPurchaseOrderLine();

			for (PurchaseOrder i : eroslist) {
				Erosketak p = new Erosketak();
				p.setErreferentzia(i.getName());
				p.setBezeroak1(sd.getBezeroakById(Math.toIntExact(i.getPartnerId())));
				p.setBezeroak2(sd.getBezeroakById(Math.toIntExact(i.getUserId())));
				p.setGuztira(i.getAmountTotal());
				p.setEgoera(i.getState());

				PurchaseOrderLine purline = new PurchaseOrderLine();
				for (PurchaseOrderLine j : eroslinelist) {
					if (j.getPurchaseOrder().getId() == i.getId()) {
						purline = j;
						Produktuak prod = sd.getProduktuakById(Math.toIntExact(j.getProductId()));
						System.out.println(prod);
						p.setProduktuak(prod);

						p.setKopurua(purline.getProductQty());
						p.setId(purline.getId());
						sd.update(p);
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

			ArrayList<AccountMove> faklist = new ArrayList<AccountMove>();
			faklist = (ArrayList<AccountMove>) pd.getAllAccountMove();

			for (AccountMove i : faklist) {
				Fakturak p = new Fakturak();
				p.setId(i.getId());
				p.setIzena(i.getName());

				Format formatter = new SimpleDateFormat("yyyy-MM-dd");
				String sdata = formatter.format(i.getDate());

				p.setData(sdata);

				p.setBezeroak(sd.getBezeroakById(Math.toIntExact(i.getPartnerId())));
				p.setBez(i.getAmountTax());
				p.setGuztira(i.getAmountTotal());
				p.setEgoera(i.getPaymentState());
				sd.update(p);
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
			Options azkTaulak = xmlOptionsIrakurri();
			Options taulak = new Options();

			System.out.println("Hauek dira azkenengoan aukeratutako taulak:");
			System.out.println(azkTaulak);
			System.out.println("Berriz taula horiek nahi dituzu erabiltzea? b/e");
			String auk = sc.nextLine();

			if (auk.equals("b")) {
				xmlLogGehitu(new Log(azkTaulak.getTaula()));
				return true;
			} else {
				taulak = taulaMenua();
			}

			// create XML file
			File file = new File("options.xml");

			// create an instance of `JAXBContext`
			JAXBContext context = JAXBContext.newInstance(Options.class);

			// create an instance of `Marshaller`
			Marshaller marshaller = context.createMarshaller();

			// enable pretty-print XML output
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// convert user object to XML file
			marshaller.marshal(taulak, file);

			xmlLogGehitu(new Log(taulak.getTaula()));

			return true;
		} catch (Exception E) {
			return false;
		}
	}

	public static Options taulaMenua() {
		List<String> taulaZerrenda = new ArrayList<String>();

		Boolean bez = false;
		Boolean pro = false;
		Boolean ero = false;
		Boolean sal = false;
		Boolean fak = false;

		Boolean amaituta = false;

		while (!amaituta) {

			System.out.println("Zein taula nahi dituzu erabiltzea?");
			if (!bez) {
				System.out.println("1- Bezeroak");
			}
			if (!pro) {
				System.out.println("2- Produktuak");
			}
			if (!ero) {
				System.out.println("3- Erosketak");
			}
			if (!sal) {
				System.out.println("4- Salmentak");
			}
			if (!fak) {
				System.out.println("5- Fakturak");
			}

			System.out.println("0- Amaitu");

			int auk = -1;
			auk = sc.nextInt();

			switch (auk) {
			case 1:
				bez = true;
				break;
			case 2:
				pro = true;
				break;
			case 3:
				ero = true;
				break;
			case 4:
				sal = true;
				break;
			case 5:
				fak = true;
				break;
			case 0:
				amaituta = true;
				break;
			default:
				break;
			}

			if (bez && pro && ero && sal && fak) {
				amaituta = true;
			}
		}

		if (bez) {
			taulaZerrenda.add("Bezeroak");
		}
		if (pro) {
			taulaZerrenda.add("Produktuak");
		}
		if (ero) {
			taulaZerrenda.add("Erosketak");
		}
		if (sal) {
			taulaZerrenda.add("Salmentak");
		}
		if (fak) {
			taulaZerrenda.add("Fakturak");
		}

		String[] taulaArray = taulaZerrenda.toArray(new String[0]);

		Options taulak = new Options(taulaArray);

		return taulak;
	}

	public static boolean xmlLogGehitu(Log log) {
		try {
			// create XML file
			File file = new File("Log.xml");

			// create an instance of `JAXBContext`
			JAXBContext context = JAXBContext.newInstance(Logs.class);

			// create an instance of `Marshaller`
			Marshaller marshaller = context.createMarshaller();

			// enable pretty-print XML output
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// create user object

			Logs logs = xmlLogIrakurri();

			List<Log> logList = new ArrayList<Log>();

			if (logs != null) {
				logList = logs.getLogs();

				int idBerria = logList.get(logList.size() - 1).getId() + 1;

				log.setId(idBerria);

				logList.add(log);
			} else {
				logList = new ArrayList<Log>();
				logList.add(log);
			}

			Logs finalLogs = new Logs(logList);

			// convert user object to XML file
			marshaller.marshal(finalLogs, file);
			return true;

		} catch (JAXBException ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static Logs xmlLogIrakurri() {
		// XML file path
		File file = new File("Log.xml");
		try {

			// create an instance of `JAXBContext`
			JAXBContext context = JAXBContext.newInstance(Logs.class);

			// create an instance of `Unmarshaller`
			Unmarshaller unmarshaller = context.createUnmarshaller();

			// convert XML file to user object
			Logs logs = (Logs) unmarshaller.unmarshal(file);

			// print user object
			return logs;

		} catch (Exception E) {
			System.out.println("Ez da logik irakurri");
			return null;
		}
	}

	public static Options xmlOptionsIrakurri() {
		// XML file path
		File file = new File("options.xml");
		try {

			// create an instance of `JAXBContext`
			JAXBContext context = JAXBContext.newInstance(Options.class);

			// create an instance of `Unmarshaller`
			Unmarshaller unmarshaller = context.createUnmarshaller();

			// convert XML file to user object
			Options options = (Options) unmarshaller.unmarshal(file);

			// print user object
			return options;

		} catch (Exception E) {
			System.out.println("Ez da options.xml-rik aurkitu");
			return null;
		}
	}
}
