package tp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tp.dominio.Cliente;
import tp.servicio.IClienteService;
import common.Error;
import common.Status;

@Controller
public class ClienteController {
	
	private IClienteService _clienteService;
	
	@Autowired
	public ClienteController(@Qualifier("clienteService") IClienteService clienteService)
	{
		_clienteService = clienteService;
	}
	
	@RequestMapping("lista_clientes.html")
	public ModelAndView getMenuPrincipal() {
		ModelAndView MV = new ModelAndView();
		try {
			List<Cliente> lista = _clienteService.selectList();
			List<String> properties = Cliente.getPropertiesToString();
			MV.addObject("clientesList", lista);
			MV.addObject("properties", properties);
			MV.setViewName("cliente");
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping("create_cliente.html")
	public ModelAndView postCliente(Cliente newCliente) {
		ModelAndView MV = new ModelAndView();
		try {
			MV.addObject("status", Status.getGenerateStatus(_clienteService.create(newCliente)));
			MV.setViewName("cliente");
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping("delete_cliente.html")
	public ModelAndView deleteCliente(Cliente cliente) {
		ModelAndView MV = new ModelAndView();
		try {
			MV.addObject("status", Status.getDeleteStatus(_clienteService.delete(cliente)));
			MV.setViewName("cliente");
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping("update_cliente.html")
	public ModelAndView updateCliente(Cliente cliente) {
		ModelAndView MV = new ModelAndView();
		try {
			MV.addObject("status", Status.getUpdateStatus(_clienteService.update(cliente)));
			MV.setViewName("cliente");
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}
	
	@RequestMapping("search_cliente.html")
	public ModelAndView getClienteByProperty(String inputText, String propertySelect) {
		ModelAndView MV = new ModelAndView();
		try {
			List<Cliente> lista = new ArrayList<Cliente>();
			if (inputText.isEmpty()) {
				lista = _clienteService.selectList();
			} else {
				lista = _clienteService.selectListByProperty(propertySelect, inputText);
			}
			MV.addObject("clientesList", lista);
			MV.setViewName("cliente");
		} catch (Exception ex) {
			MV.addObject("error", Error.INTERNAL_CONTROLLER_ERROR);
		}
		return MV;
	}

}
