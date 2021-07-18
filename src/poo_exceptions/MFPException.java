package poo_exceptions;

import poo_principal.Perfil;

public class MFPException extends Exception {
	
	public MFPException(String mensagem) {
		super("Erro! Mensagem" + " " + mensagem + " " + "fora do padrao exigido\n");
	}

}
