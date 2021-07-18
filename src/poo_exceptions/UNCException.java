package poo_exceptions;
import poo_principal.Perfil;

public class UNCException extends Exception {
	
	public UNCException(Perfil usuario) {
		super("Erro! Usuario" + " " + usuario.getUsuario() + " " +  "nao cadastrado\n");
	}
}
