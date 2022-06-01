package nebdaoui_debbagh_controle.ControllerMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import nebdaoui_debbagh_controle.model.Ticket;
import nebdaoui_debbagh_controle.service.TicketService;
import nebdaoui_debbagh_controle.service.UserService;

@Controller
@RequestMapping("/client")
public class ClientContoller {
	@Autowired
	TicketService ticketservice;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/tickets")
	public ModelAndView liste() {
		ModelAndView m = new ModelAndView("tickets/tickets");
		m.addObject("tickets", ticketservice.listeByClient());
		return m;
	}
	
	
}
