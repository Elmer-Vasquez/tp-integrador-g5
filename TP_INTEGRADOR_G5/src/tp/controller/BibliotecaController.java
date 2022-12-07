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

import common.Directory;
import common.Error;
import common.Status;
import tp.Request.CreateBibliotecaRequest;
import tp.Request.UpdateBibliotecaRequest;
import tp.dominio.Autor;
import tp.dominio.Biblioteca;
import tp.dominio.Genero;
import tp.dominio.Libro;
import tp.servicio.IAutorService;
import tp.servicio.IBibliotecaService;
import tp.servicio.IGeneroService;
import tp.servicio.ILibroService;

@Controller
@SessionAttributes({"newBiblioteca"})
public class BibliotecaController {
	
	private IBibliotecaService _bibliotecaService;
	private ILibroService _libroService;
	private IGeneroService _generoService;
	private IAutorService _autorService;
	
	@Autowired
	public BibliotecaController(
			@Qualifier("bibliotecaService") IBibliotecaService bibliotecaService, 
			@Qualifier("libroService") ILibroService libroService,
			@Qualifier("generoService") IGeneroService generoService,
			@Qualifier("autorService") IAutorService autorService
			)
	{
		_bibliotecaService = bibliotecaService;
		_libroService = libroService;
		_generoService = generoService;
		_autorService = autorService;
	}
	
	@RequestMapping(value="lista_biblioteca.html")
	public ModelAndView getListar() 
	{
		ModelAndView MV = new ModelAndView();
		try {
			List<Biblioteca> lista = _bibliotecaService.selectList();
			MV.addObject("bibliotecaList", lista);
			MV.setViewName(getPath("biblioteca"));
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping(value="create_biblioteca.html", method=RequestMethod.GET)
	public ModelAndView getBibliotecaCreate(@ModelAttribute("biblioteca") Biblioteca biblioteca) {
		ModelAndView MV = new ModelAndView();
		try {
			List<Genero> listaGenero = _generoService.selectList();
			List<Autor> listaAutor = _autorService.selectList();
			MV.addObject("generoList", listaGenero);
			MV.addObject("autorList", listaAutor);
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
			Genero genero = _generoService.readOne(request.getId());
			Autor autor = _autorService.readOne(request.getId());
			
			int id = _libroService.create(new Libro(request, genero, autor));
			Libro libro = _libroService.readOne(id);
			
			MV.addObject("status", Status.getGenerateStatus(_bibliotecaService.create(new Biblioteca(request, libro, genero, autor))));
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
			List<Biblioteca> lista = _bibliotecaService.selectList();
			MV.addObject("bibliotecaList", lista);
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
			List<Genero> listaGenero = _generoService.selectList();
			List<Autor> listaAutor = _autorService.selectList();
			Biblioteca biblioteca = _bibliotecaService.readOne(id);
			MV.addObject("generoList", listaGenero);
			MV.addObject("autorList", listaAutor);
			MV.addObject("biblioteca", biblioteca);
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
			Autor autor = _autorService.readOne(request.getId());
			Genero genero = _generoService.readOne(request.getId());
			Libro libro = _libroService.readOne(request.getId());
			Biblioteca biblioteca = _bibliotecaService.readOne(request.getId());
			
			biblioteca.update(autor, genero, libro, request);

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
			if (propertySelect.equals("default") || inputText.isEmpty()) {
				lista = _bibliotecaService.selectList();
			} else {
				lista = _bibliotecaService.selectListByProperty(propertySelect, inputText);
				MV.addObject("inputValue", inputText);
			}
			MV.addObject("bibliotecaList", lista);
			MV.setViewName(getPath("biblioteca"));
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	private String getPath(String jsp) {
		return Directory.Biblioteca + jsp;
	}

}
