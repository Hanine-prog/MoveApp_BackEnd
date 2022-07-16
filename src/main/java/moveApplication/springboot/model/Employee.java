package moveApplication.springboot.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")

public class Employee {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@Column(name ="first_name")
	private String firstName;
	
	@Column(name ="last_name")
	private String lastName;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="matricule")
	private String matricule;
	
	@Column(name ="grade")
	private String grade;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Deplacement> deplacements;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public List<Deplacement> getDeplacements() {
		return deplacements;
	}

	public void setDeplacements(List<Deplacement> deplacements) {
		this.deplacements = deplacements;
	}

	public Employee(long id, String firstName, String lastName, String email, String matricule, String grade,
			List<Deplacement> deplacements) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.matricule = matricule;
		this.grade = grade;
		this.deplacements = deplacements;
	}

	public Employee() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(deplacements, email, firstName, grade, id, lastName, matricule);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(deplacements, other.deplacements) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(grade, other.grade) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(matricule, other.matricule);
	}
	
	
	

}
