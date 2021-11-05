package view;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import controller.Postgre.*;
import model.Postgre.*;
import controller.SQLserver.*;
import model.SQLserver.*;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		ApplicationContext appContext = new AnnotationConfigApplicationContext(SQLserverKonfigurazioa.class);
		
		ApplicationContext appContext1 = new AnnotationConfigApplicationContext(PostgreKonfigurazioa.class);
		
		
		
		//Produktuak pasatzea
		
		ProduktuaDao produktuaSql = appContext.getBean(ProduktuaDao.class);
		ProductDao productPostgre = appContext1.getBean(ProductDao.class);
		
		ArrayList<ProductTemplate> plist = new ArrayList<ProductTemplate>();
		plist = (ArrayList<ProductTemplate>) productPostgre.getAll();
		
		for(ProductTemplate i : plist) {
			Produktuak p = new Produktuak();
			p.setId(i.getId());
			p.setIzena(i.getName());
			p.setDeskripzioa(i.getDescriptionSale());
			p.setBolumena(i.getVolume().floatValue());
			p.setPisua(i.getWeight().floatValue());
			p.setPrezioa(i.getListPrice().floatValue());
			produktuaSql.update(p);
		}
		
		//Bezeroak pasatzea
		
		BezeroaDao bezeroSql = appContext.getBean(BezeroaDao.class);
		ResPartnerDao bezeroPostgre = appContext1.getBean(ResPartnerDao.class);
		
		ArrayList<ResPartner> bezerolist = new ArrayList<ResPartner>();
		bezerolist = (ArrayList<ResPartner>) bezeroPostgre.getAll();
		
		for(ResPartner i : bezerolist) {
			Bezeroak p = new Bezeroak();
			p.setId(i.getId());
			p.setIzena(i.getName());
			p.setEmaila(i.getEmail());
			bezeroSql.update(p);
		}
		
		//Salmentak pasatzea
		
		SalmentaDao salmentakSql = appContext.getBean(SalmentaDao.class);
		SaleOrderDao salmentakPostgre = appContext1.getBean(SaleOrderDao.class);
		BezeroaDao bezDao = appContext.getBean(BezeroaDao.class);
		
		ArrayList<SaleOrder> salmetalist = new ArrayList<SaleOrder>();
		salmetalist = (ArrayList<SaleOrder>) salmentakPostgre.getAll();
		
		for(SaleOrder i : salmetalist) {
			Salmentak p = new Salmentak();
			p.setId(i.getId());
			p.setZenbakia(i.getName());
			p.setData(i.getDateOrder().toString());
			p.setGuztira(i.getAmountTotal().floatValue());
			p.setEgoera(i.getState());
			p.setBezeroak1(bezDao.getById(i.getPartnerId()));
			
			salmentakSql.update(p);
		}
		
		((AnnotationConfigApplicationContext) appContext).close();

	}

}
