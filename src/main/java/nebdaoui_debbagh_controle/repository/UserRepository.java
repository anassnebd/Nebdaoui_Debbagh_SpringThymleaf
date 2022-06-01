package nebdaoui_debbagh_controle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nebdaoui_debbagh_controle.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	User findByUserName(String name);
	

}
