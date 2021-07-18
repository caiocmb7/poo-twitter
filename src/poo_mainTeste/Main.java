package poo_mainTeste;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import poo_exceptions.MFPException;
import poo_exceptions.PDException;
import poo_exceptions.PEException;
import poo_exceptions.PIException;
import poo_exceptions.SIException;
import poo_exceptions.UJCException;
import poo_principal.Perfil;
import poo_principal.PessoaFisica;
import poo_principal.PessoaJuridica;
import poo_principal.Repositorio;
import poo_twitter.Tweet;
import poo_twitter.myTwitter;


public class Main {
	public static void main(String[] args)  {	
		try {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("########################\n");
	    System.out.println("Seja Bem Vindo ao meu Twitter!\n");
	    System.out.println("########################\n");
	    System.out.println("Para fins cadastrais, digite a opçao:\n 1) Pessoa Fisica\n 2) Pessoa Juridica\n");
	    int opcao = sc.nextInt();
	    switch(opcao) {
	      case 1: testePessoaFisica();
	              break;
	              
	      case 2: testePessoaJuridica();
	              break;
	               
	      default: System.out.println("Opcao inexistente!");
	              break;
	    }
		}
		catch(InputMismatchException e) {
			System.out.println("Erro! Por favor, digite somente numeros nessa parte");
		}
	  }
	
	private static void testePessoaFisica()  {
		
		try {
			
		/* @@@@@@@@ Variveis e Atribuiçoes @@@@@@@@@*/
	    Scanner sc = new Scanner(System.in);
	    String usuario;
	    String usuarioSeguir;
	    String mensagem;
	    int contDoPrincipal;
	    Repositorio repos = new Repositorio();
	    myTwitter tt = new myTwitter(repos);
	    Vector<Tweet> tw = new Vector<Tweet>();
	    Vector<Perfil> seguidores = new Vector<Perfil>();
	    Vector<Perfil> seguidos = new Vector<Perfil>();
	    /* @@@@@@@@ Variveis e Atribuiçoes @@@@@@@@@*/
	   
		
		do {
			System.out.println("Digite a opçao que deseja fazer:\n");
			System.out.println("1. Criar Perfil");
			System.out.println("2. Desativar Perfil");
			System.out.println("3. Tweetar");
			System.out.println("4. Ver a Timeline");
			System.out.println("5. Ver seu histórico de Tweets");
			System.out.println("6. Seguir outro Perfil");
			System.out.println("7. Ver numero de Seguidores");
			System.out.println("8. Ver quem o segue");
			System.out.println("9. Ver quem você segue");
			System.out.println("10. Sair\n");
			contDoPrincipal = sc.nextInt();
			
			switch(contDoPrincipal) {
			case 1: 
				System.out.println("Digite o nome do usuario a ser cadastrado:\n");
				usuario = sc.next();
				PessoaFisica contaPessoaFisica = new PessoaFisica(usuario);
					
				System.out.println("Digite o cpf referido ao usuario criado:\n");
				long cpf = sc.nextLong();
				contaPessoaFisica.setCpf(cpf);
					
				try {
					tt.criarPerfil(contaPessoaFisica);
					System.out.println("Cadastro realizado!");
				}
				catch (UJCException e) {
					System.out.println(e.getMessage());
				} 
				catch (PEException e) {
					System.out.println(e.getMessage());
				}
				break;
					
			case 2:		
				System.out.println("Digite o nome do usuario a ser cancelado:\n");
				usuario = sc.next();
				
				try {
					tt.cancelarPerfil(usuario);
					System.out.println("Perfil cancelado com sucesso!\n");
				}
				catch (PIException e){
					System.out.println(e.getMessage());
				}
				catch (PDException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 3:
				System.out.println("Faça o login do usuario: ");
				usuario = sc.next();
						
				System.out.println("O que deseja tweetar?");
				sc.nextLine();
				mensagem = sc.nextLine();
				
				try {
					tt.tweetar(usuario, mensagem);
					System.out.println("Tweet realizado!\n");
				}
				catch(PIException e) {
					System.out.println(e.getMessage());
				}
				catch(MFPException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 4:	
				System.out.println("Faça o login do usuario: ");
				usuario = sc.next();
				
				try {
					Vector<Tweet> tl = new Vector<Tweet>();
					tl = tt.timeline(usuario);
					for(int j = 0; tl.size() > j; j++) {
						System.out.println("Usuario: " + tl.elementAt(j).getUsuario() + " Twittou: " + tl.elementAt(j).getMensagem());
					}
					System.out.println("---- Fim da timeline ----");
				}
				catch(PIException e) {
					System.out.println(e.getMessage());
				}
				catch (PDException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 5:	
				System.out.println("Faça o login do usuario: ");
				usuario = sc.next();
				
				try {
					tw = tt.tweets(usuario);
					for(int j = 0; tw.size() > j; j++) {
						System.out.println("Usuario: " + tw.elementAt(j).getUsuario() + " Twittou: " + tw.elementAt(j).getMensagem());
					}
					System.out.println("---- Fim do metodo tweets ----");
				}
				catch(PIException e) {
					System.out.println(e.getMessage());
				}
				catch (PDException e) {
					System.out.println(e.getMessage());
				}	
				break;
				
			case 6:
				System.out.println("Faça o login do usuario: ");
				usuario = sc.next();
				
				System.out.println("Digite o usuario deseja seguir: ");
				usuarioSeguir = sc.next();
				
				try {
					tt.seguir(usuarioSeguir, usuario);
					System.out.println("Usuario: " +  usuario + " " + "acabou de seguir: " + " " + usuarioSeguir);
				}
				catch(PIException e) {
					System.out.println(e.getMessage());
				}
				catch (PDException e) {
					System.out.println(e.getMessage());
				}
				catch (SIException e) {
					System.out.println(e.getMessage());
				}
				break;
			
			case 7:
				System.out.println("Faça o login do usuario: ");
				usuario = sc.next();
				
				try {
					int num = tt.numeroSeguidores(usuario);
					System.out.println("Total de seguidores: " + " " + num);
				}
				catch(PIException e) {
					System.out.println(e.getMessage());
				}
				catch (PDException e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 8:
				System.out.println("Faça o login do usuario: ");
				usuario = sc.next();

				try {
					seguidores = tt.seguidores(usuario);
					
					for(int j = 0; seguidores.size() > j; j++) {
						System.out.println("Seguidor: " + " " + seguidores.elementAt(j).getUsuario());
					}
					
					if(seguidores.size() == 0) {
						System.out.println("Ninguem o segue ainda!");
					}
					System.out.println("Acao -- detalhar Seguidos -- finalizada!");
				}
				catch(PIException e) {
					System.out.println(e.getMessage());
				}
				catch (PDException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 9:
				System.out.println("Faça o login do usuario: ");
				usuario = sc.next();

				try {
					seguidos = tt.seguidos(usuario);
					
					for(int j = 0; seguidos.size() > j; j++) {
						System.out.println("Voce segue o usuario: " + seguidos.elementAt(j).getUsuario());
					}
					if(seguidos.size() == 0) {
						System.out.println("Voce nao segue ninguem!");
					}
					System.out.println("Acao -- detalhar Seguidores -- finalizada!");
				}
				catch(PIException e) {
					System.out.println(e.getMessage());
				}
				catch (PDException e) {
					System.out.println(e.getMessage());
				}
				break;	
			}
		}
		while(contDoPrincipal != 10);
		
		if (contDoPrincipal == 10) {
			System.out.println("Fim!\n");
		}
		
		
		
		}
		catch(InputMismatchException e) {
			System.out.println("Erro! Por favor, digite somente numeros nessa parte");
		}
	}
	
	private static void testePessoaJuridica() {
		try {
			
			/* @@@@@@@@ Variveis e Atribuiçoes @@@@@@@@@*/
		    Scanner sc = new Scanner(System.in);
		    String usuario;
		    String usuarioSeguir;
		    String mensagem;
		    int contDoPrincipal;
		    Repositorio repos = new Repositorio();
		    myTwitter tt = new myTwitter(repos);
		    Vector<Tweet> tw = new Vector<Tweet>();
		    Vector<Perfil> seguidores = new Vector<Perfil>();
		    Vector<Perfil> seguidos = new Vector<Perfil>();
		    /* @@@@@@@@ Variveis e Atribuiçoes @@@@@@@@@*/
		   
			
			do {
				System.out.println("Digite a opçao que deseja fazer:\n");
				System.out.println("1. Criar Perfil");
				System.out.println("2. Desativar Perfil");
				System.out.println("3. Tweetar");
				System.out.println("4. Ver a Timeline");
				System.out.println("5. Ver seu histórico de Tweets");
				System.out.println("6. Seguir outro Perfil");
				System.out.println("7. Ver numero de Seguidores");
				System.out.println("8. Ver quem o segue");
				System.out.println("9. Ver quem você segue");
				System.out.println("10. Sair\n");
				contDoPrincipal = sc.nextInt();
				
				switch(contDoPrincipal) {
				case 1: 
					System.out.println("Digite o nome do usuario a ser cadastrado:\n");
					usuario = sc.next();
					PessoaJuridica contaPessoaJuridica = new PessoaJuridica(usuario);
						
					System.out.println("Digite o cnpj referido ao usuario criado:\n");
					long cnpj = sc.nextLong();
					contaPessoaJuridica.setcnpj(cnpj);
						
					try {
						tt.criarPerfil(contaPessoaJuridica);
						System.out.println("Cadastro realizado!");
					}
					catch (UJCException e) {
						System.out.println(e.getMessage());
					} 
					catch (PEException e) {
						System.out.println(e.getMessage());
					}
					break;
						
				case 2:		
					System.out.println("Digite o nome do usuario a ser cancelado:\n");
					usuario = sc.next();
					
					try {
						tt.cancelarPerfil(usuario);
						System.out.println("Perfil cancelado com sucesso!\n");
					}
					catch (PIException e){
						System.out.println(e.getMessage());
					}
					catch (PDException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 3:
					System.out.println("Faça o login do usuario: ");
					usuario = sc.next();
							
					System.out.println("O que deseja tweetar?");
					sc.nextLine();
					mensagem = sc.nextLine();
					
					try {
						tt.tweetar(usuario, mensagem);
						System.out.println("Tweet realizado!\n");
					}
					catch(PIException e) {
						System.out.println(e.getMessage());
					}
					catch(MFPException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 4:	
					System.out.println("Faça o login do usuario: ");
					usuario = sc.next();
					
					try {
						Vector<Tweet> tl = new Vector<Tweet>();
						tl = tt.timeline(usuario);
						for(int j = 0; tl.size() > j; j++) {
							System.out.println("Usuario: " + tl.elementAt(j).getUsuario() + " Twittou: " + tl.elementAt(j).getMensagem());
						}
						System.out.println("---- Fim da timeline ----");
					}
					catch(PIException e) {
						System.out.println(e.getMessage());
					}
					catch (PDException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 5:	
					System.out.println("Faça o login do usuario: ");
					usuario = sc.next();
					
					try {
						tw = tt.tweets(usuario);
						for(int j = 0; tw.size() > j; j++) {
							System.out.println("Usuario: " + tw.elementAt(j).getUsuario() + " Twittou: " + tw.elementAt(j).getMensagem());
						}
						System.out.println("---- Fim do metodo tweets ----");
					}
					catch(PIException e) {
						System.out.println(e.getMessage());
					}
					catch (PDException e) {
						System.out.println(e.getMessage());
					}	
					break;
					
				case 6:
					System.out.println("Faça o login do usuario: ");
					usuario = sc.next();
					
					System.out.println("Digite o usuario deseja seguir: ");
					usuarioSeguir = sc.next();
					
					try {
						tt.seguir(usuarioSeguir, usuario);
						System.out.println("Voce acabou de seguir: " + " " + usuarioSeguir);
					}
					catch(PIException e) {
						System.out.println(e.getMessage());
					}
					catch (PDException e) {
						System.out.println(e.getMessage());
					}
					catch (SIException e) {
						System.out.println(e.getMessage());
					}
					break;
				
				case 7:
					System.out.println("Faça o login do usuario: ");
					usuario = sc.next();
					
					try {
						int num = tt.numeroSeguidores(usuario);
						System.out.println("Total de seguidores: " + " " + num);
					}
					catch(PIException e) {
						System.out.println(e.getMessage());
					}
					catch (PDException e) {
						System.out.println(e.getMessage());
					}
					break;
					
				case 8:
					System.out.println("Faça o login do usuario: ");
					usuario = sc.next();

					try {
						seguidos = tt.seguidos(usuario);
						
						for(int j = 0; seguidos.size() > j; j++) {
							System.out.println("O usuario: " + " " +  seguidos.elementAt(j).getUsuario() + " " + "te segue");
						}
						if(seguidos.size() == 0) {
							System.out.println("Voce nao segue ninguem!");
						}
						System.out.println("Acao -- detalhar Seguidores -- finalizada!");
					}
					catch(PIException e) {
						System.out.println(e.getMessage());
					}
					catch (PDException e) {
						System.out.println(e.getMessage());
					}
					break;	
					
				case 9:
					System.out.println("Faça o login do usuario: ");
					usuario = sc.next();

					try {
						seguidores = tt.seguidores(usuario);
						
						for(int j = 0; seguidores.size() > j; j++) {
							System.out.println("Voce segue o usuario: " + " " + seguidores.elementAt(j).getUsuario());
						}
						
						if(seguidores.size() == 0) {
							System.out.println("Voce nao segue ninguem!");
						}
						System.out.println("Acao -- detalhar Seguidos -- finalizada!");
					}
					catch(PIException e) {
						System.out.println(e.getMessage());
					}
					catch (PDException e) {
						System.out.println(e.getMessage());
					}
					break;
				}
			}
			while(contDoPrincipal != 10);
			
			if (contDoPrincipal == 10) {
				System.out.println("Fim!\n");
			}
			
			
			
			}
			catch(InputMismatchException e) {
				System.out.println("Erro! Por favor, digite somente numeros nessa parte");
			}
		}
	

	
}
