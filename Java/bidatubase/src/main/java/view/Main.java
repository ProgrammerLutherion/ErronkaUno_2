package view;

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
		
		ProduktuaDao sd = appContext.getBean(ProduktuaDao.class);
		
		Produktuak p = new Produktuak();
		p.setId(1);
		
		sd.update(p);
		
		
		
		
		((AnnotationConfigApplicationContext) appContext).close();

	}

}
