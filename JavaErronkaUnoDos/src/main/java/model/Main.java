package model;

import java.util.Scanner;

import javax.xml.bind.JAXBException;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) throws JAXBException {

		Scanner sc = new Scanner(System.in);

		String auk = "";

		System.out.println("Taulak pasatzea nahi dituzu? (b/e)");
		auk = sc.next();
		if (auk.equals("b")) {

			if (Funtzioak.denaPasatu()) {
				System.out.println("Taula denak ondo pasatu dira.");
				if (Funtzioak.xmlAukeratuTaulak()) {
					System.out.println("Taulak ondo aukeratu dira");
				} else {
					System.out.println("Taulak aukeratzean arazoren bat gertatu da");
				}
			} else {
				System.out.println("Arazoren bat egon da datuak pasatzean.");
			}

		} else if (auk.equals("e")) {

			auk = "";
			System.out.println("XML erregistru bat sortzea nahi duzu? (b/e)");
			auk = sc.next();
			if (auk.equals("b")) {
				if (Funtzioak.xmlAukeratuTaulak()) {
					System.out.println("Taulak ondo aukeratu dira");
				} else {
					System.out.println("Taulak aukeratzean arazoren bat gertatu da");
				}
			}
		}

		System.out.println("Programa amaitu da.");
		System.exit(0);
	}
}
