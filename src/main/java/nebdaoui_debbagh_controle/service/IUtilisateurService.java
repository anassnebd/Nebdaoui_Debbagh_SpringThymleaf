package nebdaoui_debbagh_controle.service;

import java.util.List;

import nebdaoui_debbagh_controle.model.Utilisateur;


public interface IUtilisateurService {

	List<Utilisateur> liste();

	void supprimer(Long id);

	void ajouter(Utilisateur user);

	void modifier(Utilisateur user);

	Utilisateur getUser(Long id);

 

	 

}
