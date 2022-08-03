package tp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tp.servicio.IUsuarioService;

@Controller
public class UserController {
	private ModelAndView MV;
	
	private IUsuarioService _usuarioService;

	@Autowired
	public UserController(@Qualifier("usuarioService") IUsuarioService usuarioService) {
		MV = new ModelAndView();
	}
	
	@RequestMapping("inicio.html")
	public ModelAndView getMenuPrincipal() 
	{
		ModelAndView MV = new ModelAndView();
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
