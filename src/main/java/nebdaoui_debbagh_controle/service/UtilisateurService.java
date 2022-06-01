package nebdaoui_debbagh_controle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nebdaoui_debbagh_controle.model.Utilisateur;
import nebdaoui_debbagh_controle.repository.UtilisateurRepository;

import java.util.Optional;


@Service
public class UtilisateurService implements IUtilisateurService  {
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
 

	@Override
	public List<Utilisateur> liste() {
		return utilisateurRepository.findAll();
	}

	@Override
	public void supprimer(Long id) {
		utilisateurRepository.deleteById(id);;
	}

	@Override
	public void ajouter(Utilisateur user) {
		utilisateurRepository.save(user);
		
	}

	@Override
	public void modifier(Utilisateur user) {
		Utilisateur util = getUser(user.getIdUtil());
		if(util!=null) {
			utilisateurRepository.save(util);
		}
		
	}
	
	@Override
	public Utilisateur getUser(Long idProjet) {
		if (utilisateurRepository.existsById(idProjet))
			return utilisateurRepository.findById(idProjet).get();
		else
			return null;

	}

 

}
