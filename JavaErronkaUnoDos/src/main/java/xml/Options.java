package xml;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Options {
	public String[] taula;

	public Options() {

	}

	public Options(String[] taula) {
		super();
		this.taula = taula;
	}

	public String[] getTaula() {
		return taula;
	}
//
//
//	@XmlAttribute
//	public void setTaula(String[] taula) {
//		this.taulak = taula;
//	}

	@Override
	public String toString() {
		return "Options [taula=" + Arrays.toString(taula) + "]";
	}

}
