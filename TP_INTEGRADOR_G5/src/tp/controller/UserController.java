package tp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	private ModelAndView MV;
	
	public UserController() {
		MV = new ModelAndView();
	}
	
	@RequestMapping("inicio.html")
	public ModelAndView getMenuPrincipal() 
	{
		MV.addObject("error", false);
		MV.setViewName("index");
		return MV;
	}
	
	@RequestMapping("login.html")
	public ModelAndView postLogin(String email, String password) {
		// Buscamos email y Password
		// De coincidir seguimos la ruta
		//if(true) MV.setViewName("siguente");
		// de no coincidir volvemos al inicio
		MV.addObject("error", true);
		MV.setViewName("index");
		return MV;
	}

}
