package nebdaoui_debbagh_controle.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import nebdaoui_debbagh_controle.model.Developpeur;



@Repository
public interface DevRepository extends JpaRepository<Developpeur, Integer> {

	public Developpeur findByNom(String name);

	public Developpeur findByEmail(String email);


}
