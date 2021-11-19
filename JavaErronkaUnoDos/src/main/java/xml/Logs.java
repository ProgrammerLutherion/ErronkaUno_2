package xml;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Logs {

	private List<Log> log;

	public Logs() {

	}

	public Logs(List<Log> logs) {
		super();
		this.log = logs;
	}

	public List<Log> getLogs() {
		return log;
	}

	public void setLogs(List<Log> logs) {
		this.log = logs;
	}

	@Override
	public String toString() {
		return "Logs [logs=" + log + "]";
	}

}
