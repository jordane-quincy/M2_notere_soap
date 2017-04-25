package run;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import config.CustomUserDetail;
import entity.Role;
import entity.User;
import service.GestionService;
import service.OperationCompteService;

/**
 * Unique controlleur (MVC2) de l'application.
 */
@Controller
public class UniqueController {

	@Autowired
	GestionService gestionService;

	@Autowired
	OperationCompteService operationCompteService;

	/**
	 * Retrouve l'utilisateur actuellement connecté.
	 *
	 * @return l'utilisateur connecté sinon null.
	 */
	public static User getConnectedUser() {
		User user = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof CustomUserDetail) {
			user = ((CustomUserDetail) principal).getUser();
		}
		return user;
	}

	@RequestMapping("/")
	public String goToAcceuil(Model model) {
		User user = getConnectedUser();

		if (user != null) {
			model.addAttribute("nomPrenomClient", user.getPrenom() + " " + user.getNom());

			// pour mettre en évidence sa supériorité
			if (Role.ROLE_ADMIN.equals(user.getRole())) {
				model.addAttribute("role", " (administrateur) ");
			} else {
				model.addAttribute("role", "");
			}
		}

		return "index";
	}

	@RequestMapping("/init")
	public String init(Model model) {
		gestionService.init();
		// une fois la db initilialisé, affichons le template init.html
		return "init";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		// une fois deconnecté, redirection vers la page de login.
		return "redirect:/login?logout";
	}

	@RequestMapping("/getCompteClient")
	public String getCompteClient(Model model) {
		model.addAttribute("comptes", gestionService.getCompteClient(getConnectedUser()));
		return "listeCompteClient";
	}

	@RequestMapping("/operationSurCompte")
	public String operationSurCompte(@RequestParam(required = true) String compteId,
			@RequestParam(required = true) String typeOperation, @RequestParam(required = true) String montant,
			Model model) {
		User client = getConnectedUser();
		operationCompteService.operationSurCompteClient(client, compteId, typeOperation, montant);

		return "redirect:/getCompteClient";
	}

	@RequestMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("clients", gestionService.findClients());

		return "admin";
	}

}