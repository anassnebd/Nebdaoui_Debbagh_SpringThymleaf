package nebdaoui_debbagh_controle.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import nebdaoui_debbagh_controle.model.Role;
import nebdaoui_debbagh_controle.model.User;
import nebdaoui_debbagh_controle.repository.RoleRepository;
import nebdaoui_debbagh_controle.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	List<User> devs ;
	
//Utilisée par la page d'inscription pour les utilisateurs.
	@Override
	public void save(User user) {
		Role r= roleRepository.findByNom("CLIENT");
		if (r==null)
		r=new Role("CLIENT");
		user.setRoles(Arrays.asList(r));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	@Override
	public void saveDev(User user) {
		Role r= roleRepository.findByNom("DEV");
		if (r==null)
		r=new Role("DEV");
		user.setRoles(Arrays.asList(r));
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	@Override
	public void supprimer(int id) {
		userRepository.deleteById(id);

	}

	@Override
	public void ajouter(User user) {
		userRepository.save(user);
		SecurityContextHolder.getContext().getAuthentication();

	}

	@Override
	public void modifier(User user) {
		User u = getUser(user.getId());
		if (u != null) {
			u.setUserName(user.getUserName());
			userRepository.save(u);
		}
	}

	@Override
	public User getUser(int id) {
		if (userRepository.existsById(id))
			return userRepository.findById(id).get();
		else
			return null;

	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if (user == null)
			throw new UsernameNotFoundException("Nom d'utilisateur ou mot de passe erroné");
		for (Role r : user.getRoles())
			System.out.println("Role:" + r.getNom());
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				user.getRoles().stream().map(r -> new SimpleGrantedAuthority("ROLE_" + r.getNom())).collect(Collectors.toList()));

	}

	@Override
	public List<User> liste() {
		
		return userRepository.findAll();
	}
	
	public List<User> getDevs(){
		devs = new ArrayList<>() ;
		List<User> users = userRepository.findAll();
		
		for(User u : users) {
			System.out.println(u);
			  
			
			if (u.getRoles().get(0).getNom().equals("DEV")) {
				System.out.println("Ok for:" + u);
				
				this.devs.add(u);
			}
			else{
				System.out.println("No for :"+ u);
			}
		}
		return devs;
	}
	

}
