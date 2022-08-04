package tp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tp.dominio.Biblioteca;
import tp.servicio.IBibliotecaService;
import tp.servicio.ILibroService;

@Controller
public class BibliotecaController {
	
	private IBibliotecaService _bibliotecaService;
	
	@Autowired
	public BibliotecaController(@Qualifier("bibliotecaService") IBibliotecaService bibliotecaService)
	{
		_bibliotecaService = bibliotecaService;
	}
	
	@RequestMapping("lista_biblioteca.html")
	public ModelAndView getListar() 
	{
		ModelAndView MV = new ModelAndView();
		List<Biblioteca> lista = _bibliotecaService.selectList();
		MV.addObject("bibliotecaList", lista);
		MV.setViewName("biblioteca");
		return MV;
	}

}
