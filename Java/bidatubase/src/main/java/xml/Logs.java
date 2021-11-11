package xml;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Logs {

    private List<Log> logs;
	
	public Logs() {
		
	}
	
	public Logs(List<Log> logs) {
		super();
		this.logs = logs;
	}
	
	public List<Log> getLogs() {
		return logs;
	}
	 
	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	@Override
	public String toString() {
		return "Logs [logs=" + logs + "]";
	}


	
	
	
}
