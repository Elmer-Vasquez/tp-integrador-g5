package tp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tp.dominio.Usuario;
import tp.servicio.IUsuarioService;

@Controller
public class UserController {
	private ModelAndView MV;
	
	private IUsuarioService _usuarioService;

	@Autowired
	public UserController(@Qualifier("usuarioService") IUsuarioService usuarioService) {
		MV = new ModelAndView();
		_usuarioService = usuarioService;
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
		try {
			Usuario usuario = _usuarioService.login(email, password);
			MV.addObject("usuario", usuario);
			MV.setViewName("principal");
		}
		catch(Exception e) {
			MV.addObject("error", true);
			MV.setViewName("index");
		}
		return MV;
	}

}
