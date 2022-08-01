package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import servicio.IMenuService;

@Controller
public class MenuController {
	
	IMenuService _menuService;
	
	public MenuController(IMenuService menuService) {
		_menuService = menuService;
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
