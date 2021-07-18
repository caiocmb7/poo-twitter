package poo_exceptions;

import poo_principal.Perfil;

public class PDException extends Exception {
	
	public PDException(String usuario) {
		super("Erro! Perfil" + " " + usuario + " " + "ja esta desativado\n");
	}
}
