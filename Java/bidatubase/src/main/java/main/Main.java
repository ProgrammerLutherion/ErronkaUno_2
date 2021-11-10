package main;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import model.Funtzioak;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		if (Funtzioak.denaPasatu()) {
			System.out.println("Taula denak ondo pasatu dira.");
		} else {
			System.out.println("Arazoren bat egon da datuak pasatzean.");
		}

		Funtzioak.xmlAukeratuTaulak();
		
		//Funtzioak.xmlIrakurri();
		
	}
}
