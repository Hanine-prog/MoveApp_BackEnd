package moveApplication.springboot.model;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name="deplacements")
public class Deplacement {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@Column(name ="startingPoint")
	private String startingPoint;
	
	@Column(name ="arrivalPoint")
	private String arrivalPoint;
	
	@Column(name ="Statuts")
	private String statuts;
	
	@Column(name ="meansOfTransport")
	private String meansOfTransport;
	
	@ManyToOne
	private Employee employee;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}

	public String getArrivalPoint() {
		return arrivalPoint;
	}

	public void setArrivalPoint(String arrivalPoint) {
		this.arrivalPoint = arrivalPoint;
	}

	public String getStatuts() {
		return statuts;
	}

	public void setStatuts(String statuts) {
		this.statuts = statuts;
	}

	public String getMeansOfTransport() {
		return meansOfTransport;
	}

	public void setMeansOfTransport(String meansOfTransport) {
		this.meansOfTransport = meansOfTransport;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public int hashCode() {
		return Objects.hash(arrivalPoint, employee, id, meansOfTransport, startingPoint, statuts);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deplacement other = (Deplacement) obj;
		return Objects.equals(arrivalPoint, other.arrivalPoint) && Objects.equals(employee, other.employee)
				&& id == other.id && Objects.equals(meansOfTransport, other.meansOfTransport)
				&& Objects.equals(startingPoint, other.startingPoint) && Objects.equals(statuts, other.statuts);
	}

	@Override
	public String toString() {
		return "Deplacement [id=" + id + ", startingPoint=" + startingPoint + ", arrivalPoint=" + arrivalPoint
				+ ", statuts=" + statuts + ", meansOfTransport=" + meansOfTransport + ", employee=" + employee + "]";
	}

	public Deplacement(long id, String startingPoint, String arrivalPoint, String statuts, String meansOfTransport,
			Employee employee) {
		super();
		this.id = id;
		this.startingPoint = startingPoint;
		this.arrivalPoint = arrivalPoint;
		this.statuts = statuts;
		this.meansOfTransport = meansOfTransport;
		this.employee = employee;
	}

	public Deplacement() {
		super();
	}
	
	
}