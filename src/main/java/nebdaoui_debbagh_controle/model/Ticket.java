package nebdaoui_debbagh_controle.model;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;



@Entity
public class Ticket {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String descr;
	private String urgence;
	private Boolean status;
	private String etat;
	
	@ManyToOne
	User client;
	
	@ManyToOne
	User dev;
	
	public User getDev() {
		return dev;
	}

	public void setDev(User dev) {
		this.dev = dev;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long idTicket) {
		id = idTicket;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String desc) {
		this.descr = desc;
	}

	public String getUrgence() {
		return urgence;
	}

	public void setUrgence(String urgence) {
		this.urgence = urgence;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", descr=" + descr + ", urgence=" + urgence + ", status=" + status + ", etat="
				+ etat + ", client=" + client + ", dev=" + dev + "]";
	}


	

	
	
	

}
