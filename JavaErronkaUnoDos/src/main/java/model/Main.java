package model;

import javax.xml.bind.JAXBException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) throws JAXBException {

		if (Funtzioak.denaPasatu()) {
			System.out.println("Taula denak ondo pasatu dira.");
		} else {
			System.out.println("Arazoren bat egon da datuak pasatzean.");
		}

		if (Funtzioak.xmlAukeratuTaulak()) {
			System.out.println("Taulak ondo aukeratu dira");
		} else {
			System.out.println("Taulak aukeratzean arazoren bat gertatu da");
		}

		System.exit(0);
	}
}
