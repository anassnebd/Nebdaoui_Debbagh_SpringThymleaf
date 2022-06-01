package nebdaoui_debbagh_controle.controller;

import java.util.List;
 

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nebdaoui_debbagh_controle.model.Ticket;
import nebdaoui_debbagh_controle.model.Utilisateur;
import nebdaoui_debbagh_controle.repository.UtilisateurRepository;
import nebdaoui_debbagh_controle.service.TicketService;
import nebdaoui_debbagh_controle.service.UtilisateurService;

@RestController
@RequestMapping
public class UtilisateurController {
	 @Autowired
	 TicketService ticketService ;
	 
	
	

	
	

}
