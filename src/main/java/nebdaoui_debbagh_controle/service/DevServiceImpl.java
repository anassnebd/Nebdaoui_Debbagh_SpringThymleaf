package nebdaoui_debbagh_controle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import nebdaoui_debbagh_controle.model.Developpeur;
import nebdaoui_debbagh_controle.repository.DevRepository;


@Service
public class DevServiceImpl implements DevService {

	@Autowired
	DevRepository devRepository;

	@Override
	public void ajouter(Developpeur dev) {
		devRepository.save(dev);

		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		String username=auth.getName();



	}

	@Override
	public List<Developpeur> getDevs() {
		return devRepository.findAll();

	}

	@Override
	public void supprimer(int idDev) {
		devRepository.deleteById(idDev);

	}

	@Override
	public void modifier(Developpeur dev) {
		
		if (devRepository.existsById(dev.getIdDev())) {
			Developpeur d = devRepository.getById(dev.getIdDev());
			d.setNom(dev.getNom());
			d.setDateEmbauche(dev.getDateEmbauche());
			d.setEmail(dev.getEmail());
			devRepository.save(d);
			
		}
		else
			devRepository.save(dev);

	}

	@Override
	public Developpeur getDeveloppeur(int idDev) {
		return devRepository.getById(idDev);
	}

}
