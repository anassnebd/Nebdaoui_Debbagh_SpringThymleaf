package nebdaoui_debbagh_controle.ControllerMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import nebdaoui_debbagh_controle.model.User;
import nebdaoui_debbagh_controle.repository.RoleRepository;
import nebdaoui_debbagh_controle.service.TicketService;
import nebdaoui_debbagh_controle.service.UserService;


@Controller
@RequestMapping("/admin")
public class AdminControllerMVC {

	@Autowired
	private UserService userService;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	TicketService ticketService ;

	@GetMapping("/users")
	public ModelAndView liste() {
		ModelAndView m = new ModelAndView("admin/users");
		m.addObject("users", userService.liste());
		return m;
	}
	@GetMapping("/tickets")
	public ModelAndView listeNa() {
		ModelAndView m = new ModelAndView("tickets/tickets");
		m.addObject("tickets", ticketService.getTicketNA());
		return m;
	}

	@GetMapping("users/add")
	public String ajout(Model model) {
		User u = new User();
		model.addAttribute("user", u);
		model.addAttribute("roles", roleRepository.findAll());
		return "admin/ajout";

	}

	@PostMapping("users/add")
	public String enregistrer(@ModelAttribute("user") User user) {
		User u = userService.getUser(user.getId());
		if (u != null)
			userService.modifier(user);
		else
			userService.ajouter(user);
		return "redirect:admin";
	}

	@PostMapping("users/addDev")
	public String enregistrer2(@ModelAttribute("user") User user) {
		User u = userService.getUser(user.getId());
		if (u != null)
			userService.modifier(user);
		else
			userService.saveDev(user);
		return "redirect:admin/users";
	}
	@GetMapping("users/edit/{id}")
	public String modifier(@PathVariable int id, Model model) {
		User u = userService.getUser(id);
		if (u != null) {
			model.addAttribute("user", u);
			model.addAttribute("roles", roleRepository.findAll());
			return "admin/ajout";
		}

		return "redirect:admin";
	}

	@GetMapping("users/delete/{id}")
	public String suppr(@PathVariable int id) {
		userService.supprimer(id);
		return "redirect:admin";
	}
}
