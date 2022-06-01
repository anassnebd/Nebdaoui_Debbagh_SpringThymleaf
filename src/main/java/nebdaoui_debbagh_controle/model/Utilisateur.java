package nebdaoui_debbagh_controle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String identifier;
	private String email;

	public long getIdUtil() {
		return id;
	}

	public void setIdUtil(long idUtil) {
		this.id = idUtil;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtil=" + id + ", identifier=" + identifier + ", email=" + email + "]";
	}

}
