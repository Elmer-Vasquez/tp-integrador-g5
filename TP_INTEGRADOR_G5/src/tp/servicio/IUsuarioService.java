package tp.servicio;

import tp.dominio.Cliente;
import tp.dominio.Usuario;

public interface IUsuarioService {
	
	public Usuario readOne(int id);
	
	public Usuario login(String email, String password);
}
