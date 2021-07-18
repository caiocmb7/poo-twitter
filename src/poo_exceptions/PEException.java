package poo_exceptions;

import poo_principal.Perfil;

public class PEException extends Exception {
	
	public PEException(Perfil usuario) {
		super("Erro! Perfil"  + " " + usuario.getUsuario() + " " + "j� existente!\n");
	}
}
