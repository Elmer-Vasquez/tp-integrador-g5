package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	private ModelAndView MV;
	
	public UserController() {
		MV = new ModelAndView();
	}
	
	@RequestMapping("login.html")
	public ModelAndView postLogin(String email, String password) {
		// Buscamos email y Password
		// De coincidir seguimos la ruta
		if(true) MV.setViewName("siguente");
		// de no coincidir volvemos al inicio
		if(false) MV.setViewName("index");
		return MV;
	}

}
