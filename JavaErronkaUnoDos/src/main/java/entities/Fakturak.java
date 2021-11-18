package entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fakturak database table.
 * 
 */
@Entity
@NamedQuery(name="Fakturak.findAll", query="SELECT f FROM Fakturak f")
public class Fakturak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private long bez;

	private String data;

	private String egoera;

	private long guztira;

	private String izena;

	//bi-directional many-to-one association to Bezeroak
	@ManyToOne
	@JoinColumn(name="BezeroIdHornitzailea")
	private Bezeroak bezeroak;

	public Fakturak() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getBez() {
		return this.bez;
	}

	public void setBez(long bez) {
		this.bez = bez;
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEgoera() {
		return this.egoera;
	}

	public void setEgoera(String egoera) {
		this.egoera = egoera;
	}

	public long getGuztira() {
		return this.guztira;
	}

	public void setGuztira(long guztira) {
		this.guztira = guztira;
	}

	public String getIzena() {
		return this.izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public Bezeroak getBezeroak() {
		return this.bezeroak;
	}

	public void setBezeroak(Bezeroak bezeroak) {
		this.bezeroak = bezeroak;
	}

}