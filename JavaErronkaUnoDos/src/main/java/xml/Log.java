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
	private String[] datua;

	public Log() {

	}

	public Log(String[] datuak) {
		super();
		this.id = 0;
		
		 LocalDateTime now = LocalDateTime.now();  
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		 dtf.format(now);  
		
		this.data = dtf.format(now);
		this.datua = datuak;
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
		return datua;
	}
	
	@XmlElementWrapper(name = "datuak")
	@XmlElement(name = "datuak")
	public void setDatuak(String[] datuak) {
		this.datua = datuak;
	}
	
	@Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", name='" + data + '\'' +
                ", roles=" + Arrays.toString(datua) + '}';
    }

}
