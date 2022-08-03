package tp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tp.servicio.IClienteService;

@Controller
public class ClienteController {
	
	private IClienteService _clienteService;
	
	@Autowired
	public ClienteController(@Qualifier("clienteService") IClienteService clienteService)
	{
		_clienteService = clienteService;
	}
	
	@RequestMapping("lista_clientes.html")
	public ModelAndView getMenuPrincipal() 
	{
		ModelAndView MV = new ModelAndView();
		MV.addObject("clientesList", false);
		MV.setViewName("cliente");
		return MV;
	}
	
//	@RequestMapping("login.html")
//	public ModelAndView postLogin(String email, String password) {
//		// Buscamos email y Password
//		// De coincidir seguimos la ruta
//		//if(true) MV.setViewName("siguente");
//		// de no coincidir volvemos al inicio
//		MV.addObject("error", true);
//		MV.setViewName("index");
//		return MV;
//	}

}
