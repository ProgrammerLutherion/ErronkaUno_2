package entity.SQLserver;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bezeroak database table.
 * 
 */
@Entity
@NamedQuery(name="Bezeroak.findAll", query="SELECT b FROM Bezeroak b")
public class Bezeroak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String emaila;

	private String izena;

	//bi-directional many-to-one association to Erosketak
	@OneToMany(mappedBy="bezeroak1")
	private List<Erosketak> erosketaks1;

	//bi-directional many-to-one association to Erosketak
	@OneToMany(mappedBy="bezeroak2")
	private List<Erosketak> erosketaks2;

	//bi-directional many-to-one association to Fakturak
	@OneToMany(mappedBy="bezeroak")
	private List<Fakturak> fakturaks;

	//bi-directional many-to-one association to Salmentak
	@OneToMany(mappedBy="bezeroak1")
	private List<Salmentak> salmentaks1;

	//bi-directional many-to-one association to Salmentak
	@OneToMany(mappedBy="bezeroak2")
	private List<Salmentak> salmentaks2;

	public Bezeroak() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmaila() {
		return this.emaila;
	}

	public void setEmaila(String emaila) {
		this.emaila = emaila;
	}

	public String getIzena() {
		return this.izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public List<Erosketak> getErosketaks1() {
		return this.erosketaks1;
	}

	public void setErosketaks1(List<Erosketak> erosketaks1) {
		this.erosketaks1 = erosketaks1;
	}

	public Erosketak addErosketaks1(Erosketak erosketaks1) {
		getErosketaks1().add(erosketaks1);
		erosketaks1.setBezeroak1(this);

		return erosketaks1;
	}

	public Erosketak removeErosketaks1(Erosketak erosketaks1) {
		getErosketaks1().remove(erosketaks1);
		erosketaks1.setBezeroak1(null);

		return erosketaks1;
	}

	public List<Erosketak> getErosketaks2() {
		return this.erosketaks2;
	}

	public void setErosketaks2(List<Erosketak> erosketaks2) {
		this.erosketaks2 = erosketaks2;
	}

	public Erosketak addErosketaks2(Erosketak erosketaks2) {
		getErosketaks2().add(erosketaks2);
		erosketaks2.setBezeroak2(this);

		return erosketaks2;
	}

	public Erosketak removeErosketaks2(Erosketak erosketaks2) {
		getErosketaks2().remove(erosketaks2);
		erosketaks2.setBezeroak2(null);

		return erosketaks2;
	}

	public List<Fakturak> getFakturaks() {
		return this.fakturaks;
	}

	public void setFakturaks(List<Fakturak> fakturaks) {
		this.fakturaks = fakturaks;
	}

	public Fakturak addFakturak(Fakturak fakturak) {
		getFakturaks().add(fakturak);
		fakturak.setBezeroak(this);

		return fakturak;
	}

	public Fakturak removeFakturak(Fakturak fakturak) {
		getFakturaks().remove(fakturak);
		fakturak.setBezeroak(null);

		return fakturak;
	}

	public List<Salmentak> getSalmentaks1() {
		return this.salmentaks1;
	}

	public void setSalmentaks1(List<Salmentak> salmentaks1) {
		this.salmentaks1 = salmentaks1;
	}

	public Salmentak addSalmentaks1(Salmentak salmentaks1) {
		getSalmentaks1().add(salmentaks1);
		salmentaks1.setBezeroak1(this);

		return salmentaks1;
	}

	public Salmentak removeSalmentaks1(Salmentak salmentaks1) {
		getSalmentaks1().remove(salmentaks1);
		salmentaks1.setBezeroak1(null);

		return salmentaks1;
	}

	public List<Salmentak> getSalmentaks2() {
		return this.salmentaks2;
	}

	public void setSalmentaks2(List<Salmentak> salmentaks2) {
		this.salmentaks2 = salmentaks2;
	}

	public Salmentak addSalmentaks2(Salmentak salmentaks2) {
		getSalmentaks2().add(salmentaks2);
		salmentaks2.setBezeroak2(this);

		return salmentaks2;
	}

	public Salmentak removeSalmentaks2(Salmentak salmentaks2) {
		getSalmentaks2().remove(salmentaks2);
		salmentaks2.setBezeroak2(null);

		return salmentaks2;
	}

}