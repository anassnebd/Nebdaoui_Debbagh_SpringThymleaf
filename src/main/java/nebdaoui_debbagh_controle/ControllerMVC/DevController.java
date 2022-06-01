package nebdaoui_debbagh_controle.ControllerMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import antlr.collections.List;
import nebdaoui_debbagh_controle.model.Ticket;
import nebdaoui_debbagh_controle.model.User;
import nebdaoui_debbagh_controle.service.TicketService;
import nebdaoui_debbagh_controle.service.UserService;

@Controller
@RequestMapping("/dev")
public class DevController {

	@Autowired
	TicketService ticketservice ;
	
	@GetMapping("/tickets")
	public ModelAndView listeByDev() {
		ModelAndView m = new ModelAndView("tickets/tickets");
		m.addObject("tickets", ticketservice.listeByDev());
		return m;
	}	
	@GetMapping("tickets/setEncours/{id}")
	public String setE(@PathVariable Long id) {
		ticketservice.setEncours(id);
		return "redirect:/dev/tickets";
	}
	@GetMapping("tickets/setTermine/{id}")
	public String setT(@PathVariable Long id) {
		ticketservice.setTermine(id);
		return "redirect:/dev/tickets";
	}
}
