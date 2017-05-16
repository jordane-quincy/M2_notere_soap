package run;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import entity.HistoriqueOperations;

@XmlRootElement(name = "list")
@XmlAccessorType(XmlAccessType.FIELD)
public class RetourWsList {

	private List<HistoriqueOperations> list;

	@XmlElementWrapper(name = "HistoriqueOperations")
	@XmlElement
	public List<HistoriqueOperations> getList() {
		return this.list;
	}

	public void setList(List<HistoriqueOperations> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "RetourWsList [list=" + this.list + "]";
	}

}
