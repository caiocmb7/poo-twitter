package poo_principal;

import poo_interfaces.IRepositorioUsuario;
import java.util.Vector;
import poo_exceptions.UJCException;
import poo_exceptions.UNCException;


public class Repositorio implements IRepositorioUsuario{

	private Vector<Perfil> ContaPerfil;
	
	public Repositorio() {
		ContaPerfil = new Vector<Perfil>();
	}
	
	@Override
	public void cadastrar(Perfil usuario) throws UJCException {
		if(ContaPerfil.contains(usuario)) {
			throw new UJCException(usuario);
		}
		else {
			ContaPerfil.add(usuario);
		}
	}

	@Override
	public Perfil buscar(String usuario) {
		for(Perfil varredura : ContaPerfil) {
			if(varredura.getUsuario().equals(usuario)) {
				return varredura;
			}
		}
		return null;
	}

	@Override
	public void atualizar(Perfil usuario) throws UNCException {
		for(Perfil varredura : ContaPerfil) {
			if(varredura != null) {
				if(varredura.getUsuario().equals(usuario)) {
					varredura = usuario;
				}
			}
			else {
				throw new UNCException(usuario);
			}
			
		}
	}

}
