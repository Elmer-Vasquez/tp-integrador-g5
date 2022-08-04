package tp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tp.dominio.Biblioteca;
import tp.dominio.Cliente;
import tp.servicio.IBibliotecaService;

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
	
	@RequestMapping("detalle_biblioteca.html")
	public void getDetalleBiblioteca(int id) 
	{
		System.out.println(id+ "Detalle");
		this.getListar();
	}
	
	@RequestMapping("modificar_biblioteca.html")
	public void getModificar(int id) 
	{
		System.out.println(id+ "Modificar");
		this.getListar();
	}
	
	@RequestMapping("eliminar_biblioteca.html")
	public void getEliminar(int id) 
	{
		System.out.println(id+ "Eliminar");
		this.getListar();
	}

}
