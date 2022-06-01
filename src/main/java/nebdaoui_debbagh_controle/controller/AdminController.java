package nebdaoui_debbagh_controle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import nebdaoui_debbagh_controle.model.Ticket;
import nebdaoui_debbagh_controle.service.TicketService;

@RestController
@RequestMapping("/admin")
public class AdminController {
		
	@Autowired
	TicketService ticketService;
	
	
	
	
 
	 
}
