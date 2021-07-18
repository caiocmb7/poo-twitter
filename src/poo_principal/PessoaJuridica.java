package poo_principal;

import java.util.Vector;

import poo_twitter.Tweet;

public class PessoaJuridica extends Perfil {
	private long cnpj;
	
	public PessoaJuridica(String usuario) {
		super(usuario);
	}

	public long getcnpj() {
		return cnpj;
	}

	public void setcnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
