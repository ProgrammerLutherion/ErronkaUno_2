package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the produktuak database table.
 * 
 */
@Entity
@NamedQuery(name = "Produktuak.findAll", query = "SELECT p FROM Produktuak p")
public class Produktuak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private float bolumena;

	private String deskripzioa;

	private String izena;

	private float pisua;

	private float prezioa;

	// bi-directional many-to-one association to Erosketak
	@OneToMany(mappedBy = "produktuak")
	private List<Erosketak> erosketaks;

	// bi-directional many-to-one association to Erosketak
	@OneToMany(mappedBy = "produktuak")
	private List<Salmentak> salmentaks;

	public Produktuak() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getBolumena() {
		return this.bolumena;
	}

	public void setBolumena(float bolumena) {
		this.bolumena = bolumena;
	}

	public String getDeskripzioa() {
		return this.deskripzioa;
	}

	public void setDeskripzioa(String deskripzioa) {
		this.deskripzioa = deskripzioa;
	}

	public String getIzena() {
		return this.izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public float getPisua() {
		return this.pisua;
	}

	public void setPisua(float pisua) {
		this.pisua = pisua;
	}

	public float getPrezioa() {
		return this.prezioa;
	}

	public void setPrezioa(float prezioa) {
		this.prezioa = prezioa;
	}

	public List<Erosketak> getErosketaks() {
		return this.erosketaks;
	}

	public void setErosketaks(List<Erosketak> erosketaks) {
		this.erosketaks = erosketaks;
	}

	public Erosketak addErosketak(Erosketak erosketak) {
		getErosketaks().add(erosketak);
		erosketak.setProduktuak(this);

		return erosketak;
	}

	public Erosketak removeErosketak(Erosketak erosketak) {
		getErosketaks().remove(erosketak);
		erosketak.setProduktuak(null);

		return erosketak;
	}
	
	public List<Salmentak> getSalmentaks() {
		return this.salmentaks;
	}

	public void setSalmentaks(List<Salmentak> erosketaks) {
		this.salmentaks = erosketaks;
	}
	
	public Salmentak addSalmentak(Salmentak erosketak) {
		getSalmentaks().add(erosketak);
		erosketak.setProduktuak(this);

		return erosketak;
	}

	public Salmentak removeSalmentak(Salmentak erosketak) {
		getSalmentaks().remove(erosketak);
		erosketak.setProduktuak(null);

		return erosketak;
	}

}