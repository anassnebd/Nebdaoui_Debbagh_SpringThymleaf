package nebdaoui_debbagh_controle.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import nebdaoui_debbagh_controle.model.User;



public interface UserService extends UserDetailsService {

	void save(User user);
	
	void saveDev(User user);

	List<User> liste();

	void supprimer(int id);

	void ajouter(User user);

	void modifier(User user);

	User getUser(int id);
	
	List<User> getDevs();
}

