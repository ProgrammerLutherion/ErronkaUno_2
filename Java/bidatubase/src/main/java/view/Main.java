package view;

import java.text.Format;
import java.text.SimpleDateFormat;
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

		// Produktuak pasatzea
		Funtzioak.produktuakPasatu();

		// Bezeroak pasatzea
		Funtzioak.bezeroakPasatu();

		// Salmentak pasatzea
		Funtzioak.salmentakPasatu();

		// Erosketak pasatzea
		Funtzioak.erosketakPasatu();

		// Fakturak pasatzea
		Funtzioak.fakturakPasatu();

	}

}
