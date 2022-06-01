package nebdaoui_debbagh_controle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nebdaoui_debbagh_controle.model.Ticket;
import nebdaoui_debbagh_controle.repository.TicketRepository;
import nebdaoui_debbagh_controle.service.TicketService;

@RestController
@RequestMapping("")
public class ClientController {

	
	
}
