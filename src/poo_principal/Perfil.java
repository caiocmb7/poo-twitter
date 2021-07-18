package poo_principal;

import java.util.Vector;

import poo_twitter.Tweet;

public abstract class Perfil {
	protected String usuario;
    protected Vector<Perfil> seguido;
    protected Vector<Perfil> seguidores;
    protected Vector<Tweet> timeline;
    protected boolean ativo;

	public Perfil() {
	}

	public Perfil(String usuario) {
		this.usuario = usuario;
		seguido = new Vector<Perfil>();
        seguidores = new Vector<Perfil>();
        timeline = new Vector<Tweet>();
		ativo = true;
	}

	public void addSeguido(Perfil usuario) {
		if (usuario != null) {
			seguido.add(usuario);
		}
		else {
			
		}
	}
	
	public void addSeguidor(Perfil usuario) {
		if (usuario != null) {
			seguidores.add(usuario);
		}
		else {
			
		}
	}
	
	public void addTweet(Tweet tweet) {
		if(usuario != null) {
			if(tweet != null) {
				timeline.add(tweet);
			}
		}			
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Vector<Perfil> getSeguido() {
		return seguido;
	}

	public void setSeguido(Vector<Perfil> seguido) {
		this.seguido = seguido;
	}

	public Vector<Perfil> getSeguidores() {
		return seguidores;
	}

	public void setSeguidores(Vector<Perfil> seguidores) {
		this.seguidores = seguidores;
	}

	public Vector<Tweet> getTimeline() {
		return timeline;
	}

	public void setTimeline(Vector<Tweet> timeline) {
		this.timeline = timeline;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
