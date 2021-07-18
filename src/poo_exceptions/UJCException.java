package poo_exceptions;
import poo_principal.Perfil;

public class UJCException extends Exception {

	public UJCException(Perfil usuario) {
		super("Erro! Usuario" + " " +  usuario.getUsuario() + " " + "ja cadastrado\n");
	}
	
	
}
