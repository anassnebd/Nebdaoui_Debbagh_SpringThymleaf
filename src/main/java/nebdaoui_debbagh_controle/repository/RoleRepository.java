package nebdaoui_debbagh_controle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nebdaoui_debbagh_controle.model.Role;



@Repository
public interface  RoleRepository  extends JpaRepository<Role,Integer>{
	public Role findByNom(String nom);

}

