package tp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import common.Dictionary;
import common.Directory;
import common.Error;
import common.Status;
import tp.Request.CreateBibliotecaRequest;
import tp.Request.UpdateBibliotecaRequest;
import tp.dominio.Biblioteca;
import tp.dominio.Libro;
import tp.servicio.IBibliotecaService;
import tp.servicio.ILibroService;

@Controller
@SessionAttributes({"newBiblioteca"})
public class BibliotecaController {
	
	private IBibliotecaService _bibliotecaService;
	private ILibroService _libroService;
	
	@Autowired
	public BibliotecaController(
			@Qualifier("bibliotecaService") IBibliotecaService bibliotecaService, 
			@Qualifier("libroService") ILibroService libroService
			)
	{
		_bibliotecaService = bibliotecaService;
		_libroService = libroService;
	}
	
	@RequestMapping(value="lista_biblioteca.html")
	public ModelAndView getListar() 
	{
		ModelAndView MV = new ModelAndView();
		try {
			List<Biblioteca> lista = _bibliotecaService.selectList();
			MV.addObject("bibliotecaList", lista);
			MV.setViewName(getPath("bilbioteca"));
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping(value="create_biblioteca.html", method=RequestMethod.GET)
	public ModelAndView getBibliotecaCreate(@ModelAttribute("biblioteca") Biblioteca biblioteca) {
		ModelAndView MV = new ModelAndView();
		try {
			MV.addObject("libroList", _libroService.selectList());
			MV.addObject("bibliotecaList", _bibliotecaService.selectList());
			MV.setViewName(getPath("biblioteca-create"));
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}

	@RequestMapping(value="create_biblioteca.html", method=RequestMethod.POST)
	public ModelAndView postBibliotecaCreate(CreateBibliotecaRequest request) {
		ModelAndView MV = new ModelAndView();
		try {
			
			Libro libro = _libroService.readOne(request.getId());

			MV.addObject("status", Status.getGenerateStatus(_bibliotecaService.create(new Biblioteca(request, libro))));
			MV.addObject("bibliotecaList", _bibliotecaService.selectList());
			MV.setViewName(getPath("biblioteca"));
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@ModelAttribute("newBiblioteca")
	public Biblioteca postEmptyBiblioteca() {
		Biblioteca emptyBiblioteca = new Biblioteca();
		return emptyBiblioteca;
	}
	
	@RequestMapping("delete_biblioteca.html")
	public ModelAndView deleteBiblioteca(String bibliotecaId) {
		ModelAndView MV = new ModelAndView();
		try {
			MV.addObject("status", Status.getDeleteStatus(_bibliotecaService.delete(Integer.parseInt(bibliotecaId))));
			MV.addObject("bibliotecaList", _bibliotecaService.selectList());
			MV.setViewName(getPath("biblioteca"));
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping(value="update_biblioteca.html", method=RequestMethod.GET)
	public ModelAndView updateBiblioteca(@RequestParam int id) {
		ModelAndView MV = new ModelAndView();
		try {
			MV.addObject("libroList", _libroService.selectList());
			MV.addObject("biblioteca", _bibliotecaService.readOne(id));
			MV.setViewName(getPath("biblioteca-update"));
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping(value="update_biblioteca.html", method=RequestMethod.POST)
	public ModelAndView updateBiblioteca(UpdateBibliotecaRequest request) {
		ModelAndView MV = new ModelAndView();
		try {
			Libro libro = _libroService.readOne(request.getId());
			Biblioteca biblioteca = _bibliotecaService.readOne(request.getId());
			
			biblioteca.update(libro, request);

			MV.addObject("status", Status.getUpdateStatus(_bibliotecaService.update(biblioteca)));
			
			MV.addObject("bibliotecaList", _bibliotecaService.selectList());
			MV.setViewName(getPath("biblioteca"));
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping(value="search_biblioteca.html", method=RequestMethod.GET)
	public ModelAndView selectListByProperty(String inputText, String propertySelect) {
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
	
	private String getPath(String jsp) {
		return Directory.Biblioteca + jsp;
	}

}
