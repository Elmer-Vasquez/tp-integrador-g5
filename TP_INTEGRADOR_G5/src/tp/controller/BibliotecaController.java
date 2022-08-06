package tp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import common.Dictionary;
import common.Error;
import tp.dominio.Biblioteca;
import tp.dominio.Cliente;
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
	
	@RequestMapping(value="lista_biblioteca.html", method=RequestMethod.GET)
	public ModelAndView getListar() 
	{
		ModelAndView MV = new ModelAndView();
		try {
			List<Biblioteca> lista = _bibliotecaService.selectList();
			MV.addObject("bibliotecaList", lista);
			MV.setViewName("biblioteca");
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping(value="search_biblioteca.html", method=RequestMethod.GET)
	public ModelAndView getClienteByProperty(String inputText, String propertySelect) {
		ModelAndView MV = new ModelAndView();
		try {
			List<Biblioteca> lista = new ArrayList<Biblioteca>();
			if (propertySelect.equals("default") || inputText.isEmpty() || ((propertySelect.equals("libro.isbn") || propertySelect.equals("libro.cantidadPaginas")) && !Dictionary.isNumeric(inputText))) {
				lista = _bibliotecaService.selectList();
			} else {
				lista = _bibliotecaService.selectListByProperty(propertySelect, inputText);
				MV.addObject("inputValue", inputText);
			}
			MV.addObject("bibliotecaList", lista);
			MV.setViewName("biblioteca");
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}

}
