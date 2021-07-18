package poo_exceptions;

import poo_principal.Perfil;

public class PIException extends Exception {
	
	public PIException(String usuario) {
		super("Erro! Perfil" + " " + usuario + " " + "Inexistente!\n");
	}
}
