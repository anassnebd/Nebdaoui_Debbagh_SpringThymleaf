package nebdaoui_debbagh_controle.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
public class Developpeur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDev;
	@NotBlank
	@Column(nullable = false)
	private String nom;

	@Email
	@Column(unique = true)
	private String email;
	private LocalDate dateEmbauche;
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	//relation
	@ManyToMany
	@JoinTable(name = "taches_dev", joinColumns = @JoinColumn(name = "dev_id"), inverseJoinColumns = @JoinColumn(name = "tache_id"))
	List<Ticket> tickets;

	public int getIdDev() {
		return idDev;
	}

	public void setIdDev(int idDev) {
		this.idDev = idDev;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Ticket> getTaches() {
		return tickets;
	}

	public void setTaches(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public LocalDate getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(LocalDate dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

}
