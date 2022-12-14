package tp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import common.Directory;
import common.Error;
import common.Status;
import tp.Request.CreateLibroRequest;
import tp.Request.UpdateLibroRequest;
import tp.dominio.Autor;
import tp.dominio.Biblioteca;
import tp.dominio.Genero;
import tp.dominio.Libro;
import tp.servicio.IAutorService;
import tp.servicio.IBibliotecaService;
import tp.servicio.IGeneroService;
import tp.servicio.ILibroService;

@Controller
@SessionAttributes({"newLibro"})
public class LibroController {
	
	private ILibroService _libroService;
	private IAutorService _autorService;
	private IGeneroService _generoService;
	private IBibliotecaService _bibliotecaService;
	
	@Autowired
	public LibroController(
			@Qualifier("libroService") ILibroService libroService,
			@Qualifier("autorService") IAutorService autorService,
			@Qualifier("generoService") IGeneroService generoService,
			@Qualifier("bibliotecaService") IBibliotecaService bibliotecaService
			) {
		_libroService = libroService;
		_autorService = autorService;
		_generoService = generoService;
		_bibliotecaService = bibliotecaService;
	}
	
	@RequestMapping(value="crear_Libro.html", method=RequestMethod.GET)
	public ModelAndView getLibroCrear(@ModelAttribute("libro") Libro libro)
	{
		ModelAndView MV = new ModelAndView();
		try {
			MV.addObject("autor", _autorService.selectList());
			MV.addObject("genero", _generoService.selectList());
			MV.setViewName(getPath("libro_create"));
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping(value="create_libro.html", method=RequestMethod.POST)
	public ModelAndView postLibroCrear(CreateLibroRequest request) 
	{
		ModelAndView MV = new ModelAndView();
		try {
			 System.out.print(request);
			MV.setViewName(getPath("lista_biblioteca"));
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping(value="editar_Libro.html", method=RequestMethod.GET)
	public ModelAndView getEditarLibro(int id) 
	{
		ModelAndView MV = new ModelAndView();
		try {
			MV.addObject("libro", _libroService.readOne(id));
			MV.addObject("autor", _autorService.selectList());
			MV.addObject("genero", _generoService.selectList());
			MV.setViewName(getPath("libro-update"));
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping(value="editar_libro.html", method=RequestMethod.POST)
	public ModelAndView updateLibro(UpdateLibroRequest request) 
	{
		ModelAndView MV = new ModelAndView();
		try {
			Genero genero = _generoService.readOne(request.getIdGeneros());
			Autor autor = _autorService.readOne(request.getIdAutor());
			Libro libro = _libroService.readOne(request.getId());
			
			libro.update(request, genero, autor);
			
			MV.addObject("status", Status.getUpdateStatus(_libroService.update1(libro)));
			List<Biblioteca> lista = _bibliotecaService.selectList();
			MV.addObject("bibliotecaList", lista);
			MV.setViewName("Biblioteca/biblioteca");
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping(value="eliminar_libro.html", method=RequestMethod.GET)
	public ModelAndView getEliminar(String id) 
	{
		ModelAndView MV = new ModelAndView();
		try {
			Libro libro = _libroService.readOne(Integer.parseInt(id));
			
			//Tengo que eliminar libros por generos
			_libroService.delete(libro);
			
			List<Biblioteca> lista = _bibliotecaService.selectList();
			MV.addObject("bibliotecaList", lista);
			
			MV.setViewName("Biblioteca/biblioteca");
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping(value="detalle_libro.html", method=RequestMethod.GET)
	public ModelAndView getDetalle(String id) 
	{
		ModelAndView MV = new ModelAndView();
		try {
			MV.addObject("libro", _libroService.readOne(Integer.parseInt(id)));
			MV.setViewName(getPath("libro"));
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	private String getPath(String jsp) {
		return Directory.LIBRO + jsp;
	}
}
