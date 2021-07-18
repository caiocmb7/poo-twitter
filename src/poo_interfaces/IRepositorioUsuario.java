package poo_interfaces;

import poo_exceptions.UJCException;
import poo_exceptions.UNCException;
import poo_principal.Perfil;

public interface IRepositorioUsuario {
	public void cadastrar(Perfil usuario) throws UJCException;
	public Perfil buscar(String usuario);
	public void atualizar(Perfil usuario) throws UNCException;
}
