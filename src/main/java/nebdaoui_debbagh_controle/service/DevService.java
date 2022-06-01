package nebdaoui_debbagh_controle.service;

import java.util.List;

import nebdaoui_debbagh_controle.model.Developpeur;


public interface DevService {

	List<Developpeur> getDevs();

	void ajouter(Developpeur dev);

	void supprimer(int idDev);

	void modifier(Developpeur dev);

	Developpeur getDeveloppeur(int idDev);
	
}
