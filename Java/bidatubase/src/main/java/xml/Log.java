package xml;

import java.time.LocalDate;
import java.util.Arrays;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Log {
	private int id;
	private LocalDate data;
	private String[] datuak;

	public Log() {

	}

	public Log(int id, LocalDate data, String[] datuak) {
		super();
		this.id = id;
		this.data = data;
		this.datuak = datuak;
	}

	public int getId() {
		return id;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	@XmlAttribute
	public void setData(LocalDate data) {
		this.data = data;
	}

	
	public String[] getDatuak() {
		return datuak;
	}
	
	@XmlElementWrapper(name = "datuak")
	@XmlElement
	public void setDatuak(String[] datuak) {
		this.datuak = datuak;
	}
	
	@Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", name='" + data + '\'' +
                ", roles=" + Arrays.toString(datuak) + '}';
    }

}
