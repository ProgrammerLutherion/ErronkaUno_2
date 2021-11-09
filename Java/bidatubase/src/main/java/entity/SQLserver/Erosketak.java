package entity.SQLserver;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the erosketak database table.
 * 
 */
@Entity
@NamedQuery(name="Erosketak.findAll", query="SELECT e FROM Erosketak e")
public class Erosketak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String egoera;

	private String erreferentzia;

	private long guztira;

	private int kopurua;

	//bi-directional many-to-one association to Bezeroak
	@ManyToOne
	@JoinColumn(name="BezeroIdHornitzailea")
	private Bezeroak bezeroak1;

	//bi-directional many-to-one association to Bezeroak
	@ManyToOne
	@JoinColumn(name="BezeroIdEroslea")
	private Bezeroak bezeroak2;

	//bi-directional many-to-one association to Produktuak
	@ManyToOne
	@JoinColumn(name="ProduktuId")
	private Produktuak produktuak;

	public Erosketak() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEgoera() {
		return this.egoera;
	}

	public void setEgoera(String egoera) {
		this.egoera = egoera;
	}

	public String getErreferentzia() {
		return this.erreferentzia;
	}

	public void setErreferentzia(String erreferentzia) {
		this.erreferentzia = erreferentzia;
	}

	public long getGuztira() {
		return this.guztira;
	}

	public void setGuztira(long guztira) {
		this.guztira = guztira;
	}

	public int getKopurua() {
		return this.kopurua;
	}

	public void setKopurua(int kopurua) {
		this.kopurua = kopurua;
	}

	public Bezeroak getBezeroak1() {
		return this.bezeroak1;
	}

	public void setBezeroak1(Bezeroak bezeroak1) {
		this.bezeroak1 = bezeroak1;
	}

	public Bezeroak getBezeroak2() {
		return this.bezeroak2;
	}

	public void setBezeroak2(Bezeroak bezeroak2) {
		this.bezeroak2 = bezeroak2;
	}

	public Produktuak getProduktuak() {
		return this.produktuak;
	}

	public void setProduktuak(Produktuak produktuak) {
		this.produktuak = produktuak;
	}

}