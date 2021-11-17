package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the salmentak database table.
 * 
 */
@Entity
@NamedQuery(name="Salmentak.findAll", query="SELECT s FROM Salmentak s")
public class Salmentak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String data;

	private String egoera;

	private float guztira;

	private String zenbakia;

	//bi-directional many-to-one association to Bezeroak
	@ManyToOne
	@JoinColumn(name="BezeroIdEroslea")
	private Bezeroak bezeroak1;

	//bi-directional many-to-one association to Bezeroak
	@ManyToOne
	@JoinColumn(name="BezeroIdKomertzial")
	private Bezeroak bezeroak2;

	public Salmentak() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public float getGuztira() {
		return this.guztira;
	}

	public void setGuztira(float guztira) {
		this.guztira = guztira;
	}

	public String getZenbakia() {
		return this.zenbakia;
	}

	public void setZenbakia(String zenbakia) {
		this.zenbakia = zenbakia;
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

}