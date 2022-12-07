package tp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="inicio.html", method=RequestMethod.GET)
	public ModelAndView getMenuPrincipal() 
	{
		ModelAndView MV = new ModelAndView();
		MV.addObject("error", false);
		MV.setViewName("index");
		return MV;
	}
	
	@RequestMapping(value="login.html", method=RequestMethod.POST)
	public ModelAndView postLogin(String email, String password) {
		try {
			Usuario usuario = _usuarioService.login(email, password);
			if(usuario == null) throw new Exception();
			MV.addObject("usuario", usuario);
			MV.setViewName("principal");
		}
		catch(Exception e) {
			MV.addObject("error", true);
			MV.setViewName("index");
		}
		return MV;
	}
	
	@RequestMapping(value="principal.html", method=RequestMethod.GET)
	public ModelAndView getPrincipal() 
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("principal");
		return MV;
	}
	
	@RequestMapping(value="index.html", method=RequestMethod.GET)
	public ModelAndView getIndex() 
	{
		ModelAndView MV = new ModelAndView();
		MV.setViewName("index");
		return MV;
	}
	
	public ModelAndView logOut(HttpServletRequest request) {
		HttpSession sesion = request.getSession();
		sesion.invalidate();
		return this.getMenuPrincipal();
	}
 
}
