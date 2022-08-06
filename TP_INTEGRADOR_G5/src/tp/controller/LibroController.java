package tp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import common.Error;
import tp.dao.IAutorDao;
import tp.daoImpl.AutorDao;
import tp.daoImpl.GeneroDao;
import tp.dominio.Autor;
import tp.dominio.Genero;
import tp.dominio.Libro;
import tp.servicio.IAutorService;
import tp.servicio.IGeneroService;
import tp.servicio.ILibroService;
import tp.servicioImpl.AutorService;
import tp.servicioImpl.GeneroService;

@Controller
public class LibroController {
	
	private ILibroService _libroService;
	private IAutorService _autorService;
	private IGeneroService _generoService;
	
	@Autowired
	public LibroController(@Qualifier("libroService") ILibroService libroService) {
		_libroService = libroService;
	}
	
	
	@RequestMapping("crear_Libro.html")
	public ModelAndView getAgregar()
	{
		ModelAndView MV = new ModelAndView();
		try {
			_autorService = new AutorService( new AutorDao());
			_generoService = new GeneroService( new GeneroDao() );
			List<Autor> autor = _autorService.selectList();
			List<Genero> genero = _generoService.selectList();
			MV.addObject("autor", autor);
			MV.addObject("genero", genero);
			MV.setViewName("crearLibro");
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping("agregar_libro.html")
	public ModelAndView getAgregar(Libro libro) 
	{
		ModelAndView MV = new ModelAndView();
		try {
			MV.setViewName("lista_biblioteca");
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping("editar_Libro.html")
	public ModelAndView getEditarLibro() 
	{
		ModelAndView MV = new ModelAndView();
		try {
			_autorService = new AutorService( new AutorDao());
			_generoService = new GeneroService( new GeneroDao() );
			List<Autor> autor = _autorService.selectList();
			List<Genero> genero = _generoService.selectList();
			MV.addObject("autor", autor);
			MV.addObject("genero", genero);
			MV.setViewName("editarLibro");
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping("modificar_libro.html")
	public ModelAndView getModificar() 
	{
		ModelAndView MV = new ModelAndView();
		try {
			MV.setViewName("lista_biblioteca");
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping("eliminar_libro.html")
	public ModelAndView getEliminar(int id) 
	{
		ModelAndView MV = new ModelAndView();
		try {
			Libro libro = _libroService.readOne(id);
			libro.setEstado(false);
			_libroService.update(_libroService.readOne(id));
			System.out.print(_libroService.readOne(id));
			MV.setViewName("lista_biblioteca");
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
}
