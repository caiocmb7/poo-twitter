package poo_twitter;

import java.util.Vector;
import java.lang.Math;

import poo_exceptions.MFPException;
import poo_exceptions.PDException;
import poo_exceptions.PEException;
import poo_exceptions.PIException;
import poo_exceptions.SIException;
import poo_exceptions.UJCException;
import poo_interfaces.ITwitter;
import poo_principal.Perfil;
import poo_principal.Repositorio;

public class myTwitter implements ITwitter {
	
	Repositorio repos = new Repositorio();
	Vector<Tweet> aux = new Vector<>();
	Vector<Perfil> auxUsuario = new Vector<>();
	
	public myTwitter(Repositorio repos) {
		this.repos = repos;
	}

	@Override
	public void criarPerfil(Perfil usuario) throws PEException, UJCException {
		if(repos.buscar(usuario.getUsuario()) == null) {
			repos.cadastrar(usuario);
		}
		else {
			throw new PEException(usuario);
		}	
	}

	@Override
	public void cancelarPerfil(String usuario) throws PIException, PDException{
        Perfil perfilUsuario = repos.buscar(usuario);
        if(perfilUsuario != null) {
            if(perfilUsuario.isAtivo()) {
            	perfilUsuario.setAtivo(false);
            }
            else {
                throw new PDException(usuario);
            }
        }
        else {
            throw new PIException(usuario);
        }
    }

	@Override
	public void tweetar(String usuario, String mensagem) throws PIException, MFPException {
		Perfil perfilUsuario = repos.buscar(usuario);
		if(perfilUsuario == null){
			throw new PIException(usuario);
		}
		if(mensagem.length() < 1 || mensagem.length() > 140) {
			throw new MFPException(mensagem);
		}
		Tweet tweet = new Tweet(usuario, mensagem);
		perfilUsuario.addTweet(tweet);
		
		for(Perfil p : perfilUsuario.getSeguidores()) {
			if(p.isAtivo()) {
				p.addTweet(tweet);
			}
		}
	}

	@Override
	public Vector<Tweet> timeline(String usuario) throws PIException, PDException {
		Perfil perfilUsuario = repos.buscar(usuario);
		if(perfilUsuario == null) {
			throw new PIException(usuario);
		}
		else {
			if(perfilUsuario.isAtivo()) {
				return perfilUsuario.getTimeline();
			}
			else {
				throw new PDException(usuario);
			}
		}
		
	}

	@Override
	public Vector<Tweet> tweets(String usuario) throws PIException, PDException {
		Perfil perfilUsuario = repos.buscar(usuario);
		if(perfilUsuario != null) {
			if(perfilUsuario.isAtivo()) {
				Perfil perfil = repos.buscar(usuario);
				Vector<Tweet> tl = perfil.getTimeline();
				Vector<Tweet> tw = new Vector<Tweet>();
				
				for(Tweet tweet : tl) {
					if(tweet.getUsuario().equals(usuario)) {
						tw.add(tweet);
					}
				}
				return tw;
			}
			else {
				throw new PDException(usuario);
			}
		}
		else {
			throw new PIException(usuario);
		}
	}
		
	@Override
	public void seguir(String seguidor, String seguido) throws PIException, PDException, SIException{
		Perfil usuarioPadrao = repos.buscar(seguido);
		Perfil usuarioSeguidor = repos.buscar(seguidor);
		
		if (usuarioSeguidor == usuarioPadrao) {
			throw new SIException();
		}
		if (usuarioSeguidor == null) {
			throw new PIException(seguidor);
		}
		else {
			if (usuarioSeguidor.isAtivo() == false) {
				throw new PDException(seguidor);
			}
		}
		if (usuarioPadrao == null) {
			throw new PIException(seguido);
		}
		else {
			if (usuarioPadrao.isAtivo() == false) {
				throw new PDException(seguido);
			}
		}
		
		if (!(usuarioPadrao.getSeguidores().contains(usuarioSeguidor))) {
			usuarioSeguidor.addSeguidor(usuarioPadrao);
		    usuarioPadrao.addSeguido(usuarioSeguidor);
		}
		
	}

	@Override
	public int numeroSeguidores(String usuario) throws PIException, PDException {
		Perfil perfilUsuario = repos.buscar(usuario);
		if(perfilUsuario == null){
			throw new PIException(usuario);
		}
		else {
			if(perfilUsuario.isAtivo() == false) {
				throw new PDException(usuario);
			}
		return perfilUsuario.getSeguidores().size();
		}
	}	

	@Override
	public Vector<Perfil> seguidores(String usuario) throws PIException, PDException {
		Perfil perfilUsuario = repos.buscar(usuario);
		if(perfilUsuario == null){
			throw new PIException(usuario);
		}
		else {
			if (perfilUsuario.isAtivo() == false) {
				throw new PDException(usuario);
			}
		}
		return perfilUsuario.getSeguidores();	
	}

	@Override
	public Vector<Perfil> seguidos(String usuario) throws PIException, PDException {
		Perfil perfilUsuario = repos.buscar(usuario);
		if(perfilUsuario == null){
			throw new PIException(usuario);
		}
		else {
			if (perfilUsuario.isAtivo() == false) {
				throw new PDException(usuario);
			}
		}
		return perfilUsuario.getSeguido();
	}
	
	
	}
