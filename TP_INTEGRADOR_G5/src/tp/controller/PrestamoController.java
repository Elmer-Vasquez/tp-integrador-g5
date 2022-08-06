package tp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import common.Error;
import tp.dominio.Prestamo;
import tp.servicio.IPrestamoService;
import tp.servicioImpl.PrestamoService;

@Controller
public class PrestamoController {
	private IPrestamoService _prestamoService;
	
	@Autowired
	public PrestamoController(@Qualifier("prestamoService") IPrestamoService PrestamoService)
	{
		_prestamoService = PrestamoService;
	}
	
	@RequestMapping("lista_prestamo.html")
	public ModelAndView getMenuPrincipal() {
		ModelAndView MV = new ModelAndView();
		try {
			List<Prestamo> lista = _prestamoService.selectList();
			//MV.addObject("prestamoList", lista);
			MV.setViewName("prestamo");
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	
}
