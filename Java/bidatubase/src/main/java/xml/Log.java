package xml;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.time.LocalDateTime;    

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="log")
public class Log {
	private int id;
	private String data;
	private String[] datuak;

	public Log() {

	}

	public Log(String[] datuak) {
		super();
		this.id = 0;
		
		 LocalDateTime now = LocalDateTime.now();  
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		 dtf.format(now);  
		
		this.data = dtf.format(now);
		this.datuak = datuak;
	}

	public int getId() {
		return id;
	}

	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	@XmlAttribute
	public void setData(String data) {
		this.data = data;
	}

	
	public String[] getDatuak() {
		return datuak;
	}
	
	@XmlElementWrapper(name = "datuak")
	@XmlElement(name = "datuak")
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
