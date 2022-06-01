package nebdaoui_debbagh_controle.ControllerMVC;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import nebdaoui_debbagh_controle.model.Ticket;
import nebdaoui_debbagh_controle.model.User;
import nebdaoui_debbagh_controle.repository.UserRepository;
import nebdaoui_debbagh_controle.service.TicketService;
import nebdaoui_debbagh_controle.service.UserService;


@Controller
@RequestMapping("/tickets")
public class TicketContoller {

	@Autowired
	TicketService ticketservice;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;

	
	@GetMapping("/add")
	public ModelAndView ajout() {
		ModelAndView m = new ModelAndView("tickets/ajout");
		Ticket t = new Ticket();
		
		m.addObject("ticket", t);
		return m ;
	}
	

	@PostMapping("/add")
	public String enregistrer(@ModelAttribute("ticket") Ticket ticket) {
		Ticket t = ticketservice.getTicket(ticket.getId());
		if (t != null)
			ticketservice.modifier(ticket);
		else     
			ticketservice.ajouter(ticket);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String username = auth.getName();
		User u = userRepository.findByUserName(username);
		if(u.getRoles().get(0).getNom().equals("CLIENT")) {
			return "redirect:/client/tickets";
		}
		if(u.getRoles().get(0).getNom().equals("ADMIN")) {
			return "redirect:/admin/tickets";
		}
		if(u.getRoles().get(0).getNom().equals("ADMIN")) {
			return "redirect:/dev/tickets";
		}
		return null;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView modifier(@PathVariable long id) {
		ModelAndView m = new ModelAndView("tickets/ajout");
		Ticket t = ticketservice.getTicket(id);
		if (t != null) {
			m.addObject("ticket", t);
			m.addObject("options", userService.getDevs());
			return m;
		}

		return new ModelAndView("redirect:/tickets");
	}

	@GetMapping("/delete/{id}")
	public String suppr(@PathVariable Long id) {
		ticketservice.supprimer(id);
Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		String username = auth.getName();
		User u = userRepository.findByUserName(username);
		if(u.getRoles().get(0).getNom().equals("CLIENT")) {
			return "redirect:/client/tickets";
		}
		if(u.getRoles().get(0).getNom().equals("ADMIN")) {
			return "redirect:/admin/tickets";
		}
		if(u.getRoles().get(0).getNom().equals("ADMIN")) {
			return "redirect:/dev/tickets";
		}
		return null;
	}

}
