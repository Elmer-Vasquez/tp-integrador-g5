
package tp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import common.Directory;
import common.Error;
import tp.Request.CreatePrestamoRequest;
import tp.dominio.Biblioteca;
import tp.dominio.Cliente;
import tp.dominio.Prestamo;
import tp.servicio.IBibliotecaService;
import tp.servicio.IClienteService;
import tp.servicio.ILibroService;
import tp.servicio.IPrestamoService;
import tp.servicioImpl.PrestamoService;

@Controller
public class PrestamoController {
	private IPrestamoService _prestamoService;
	private IClienteService _clienteService;
	private ILibroService _libroService;
	private IBibliotecaService _bibliotecaService;
	
	@Autowired
	public PrestamoController(@Qualifier("prestamoService") IPrestamoService PrestamoService,
							  @Qualifier("clienteService") IClienteService clienteService,
							  @Qualifier("libroService") ILibroService libroService,
							  @Qualifier("bibliotecaService") IBibliotecaService bibliotecaService)
	{
		_prestamoService = PrestamoService;
		_clienteService = clienteService;
		_libroService = libroService;
		_bibliotecaService = bibliotecaService;
	}
	
	@RequestMapping("lista_prestamo.html")
	public ModelAndView getMenuPrincipal() {
		ModelAndView MV = new ModelAndView();
		try {
			List<Prestamo> lista = _prestamoService.selectList();
			MV.addObject("prestamoList", lista);
			MV.setViewName(getPath("prestamo"));
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping(value="create_prestamo.html", method=RequestMethod.GET)
	public ModelAndView getPrestamoCreate() {
		ModelAndView MV = new ModelAndView();
		try {
			List<Cliente> lista = _clienteService.selectList();
			MV.addObject("clienteList", lista );
			MV.addObject("libroList", _libroService.selectList());
			MV.addObject("bibliotecaList", _bibliotecaService.selectList());
			MV.setViewName(getPath("prestamo-create"));
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping(value="create_prestamo.html", method=RequestMethod.POST)
	public ModelAndView getPrestamoCreate(CreatePrestamoRequest request) {
		ModelAndView MV = new ModelAndView();
		try {
			
			Biblioteca bib = _bibliotecaService.readOne(request.getBibliotecaId());
			Cliente cli = _clienteService.readOne(request.getClienteId());
			
			MV.addObject("status", _prestamoService.create(new Prestamo(bib, cli, request.getCantDias(), request.getFecha())));
			MV.setViewName(getPath("prestamo"));
			
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	private String getPath(String jsp) {
		return Directory.PRESTAMO + jsp;
	}
	
	
}
