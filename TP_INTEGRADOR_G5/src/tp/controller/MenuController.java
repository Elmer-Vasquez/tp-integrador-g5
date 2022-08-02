package tp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tp.servicio.IUsuarioService;

@Controller
public class MenuController {
	
	private IUsuarioService _usuarioService;
	
	@Autowired
	public MenuController(@Qualifier("usuarioService") IUsuarioService usuarioService) {
		_usuarioService = usuarioService;
	}

	@RequestMapping("menu_principal.html")
	public ModelAndView getMenuPrincipal(String usuario, String password) 
	{
		ModelAndView MV = new ModelAndView();
		MV.addObject("usuario", usuario);
		MV.setViewName("MenuPrincipal");
		return MV;
	}
	
	@RequestMapping("menu_inicio.html")
	public ModelAndView getMenuInicio() 
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("MenuInicio");
		return MV;
	}
}
