package br.ufc.quixada.exec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import br.ufc.quixada.model.*;
import br.ufc.quixada.sql.*;


public class Principal {
	public static void Menu1() {
		System.out.println("+----------------MENU-------------+");
        System.out.println("|         1- Cadastre-se          |");
        System.out.println("|         2- Login                |");
        System.out.println("|         0- Sair                 |");
        System.out.println("+---------------------------------+");
	}
	
	public static void Menu() {
	        System.out.println("+----------------MENU-------------+");
	        System.out.println("|         1- Faça sua aposta      |");
	        System.out.println("|         2- Listar Times         |");
	        System.out.println("|         3- Listar Confrontos    |");
	        System.out.println("|         4- Deletar aposta       |");
	        System.out.println("|         5- Soma total de aposta |");
	        System.out.println("|         6- Alterar aposta       |");
	        System.out.println("|         7- Resultado            |");
	        System.out.println("|         0- Finalizar            |");
	        System.out.println("+---------------------------------+");
	}	
		
	public static void main(String[] args) throws IOException{
		Scanner tcl = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int opcao;
		int opcao2;
		do {
			Menu1();
			System.out.println("Digite a opção desejada: ");
			opcao = tcl.nextInt();
			switch(opcao){
			case 1: // cadastro 
				System.out.println("CADASTRO DE USUARIO\n");
				System.out.println("Usuario:");
				String jog_nome = in.readLine();
				System.out.println("Senha:");
				String jog_senha = in.readLine();
				
				Selecionar_jogador joga = new Selecionar_jogador();
				List<Jogador> jog = joga.VerificarJog(jog_nome);
				
				
				while(jog != null && !jog.isEmpty()){
					System.out.println("Usuario ja existe\n");
					System.out.println("Usuario:");
					String jog_nome1 = in.readLine();
					System.out.println("Senha:");
					jog_senha = in.readLine();
					jog = joga.VerificarJog(jog_nome1);
					
				}
				Jogador jogador = new Jogador();
				jogador.setJog_nome(jog_nome);
				jogador.setJog_senha(jog_senha);
				Insercao dao = new Insercao();
				dao.adiciona(jogador);
				
				Selecionar_jogador idJog = new Selecionar_jogador(); 
				int idjoga = idJog.consulta_id(jog_nome);
				System.out.println("Cadastrado com sucessso!!!\n");

				do{
					Menu();
					System.out.println("Digite a opção desejada: ");
					opcao2 = tcl.nextInt();
					switch(opcao2){
					
					case 1:
						System.out.println("Faça sua aposta:");
						System.out.println("Valor da aposta:");
						float apo_valor = tcl.nextFloat();
						System.out.println("Numero de partida");
						int apo_confronto = tcl.nextInt();
						Selecionar_confronto dao_confronto_par = new Selecionar_confronto();
						List<Partida> Partida = dao_confronto_par.confronto(apo_confronto);
						while(Partida == null) {
							System.out.println("Confronto invalido");
							System.out.println("Digite novamente\n");
							apo_confronto = tcl.nextInt();
							Partida = dao_confronto_par.confronto(apo_confronto);
						}
						System.out.println("Confrontos\n");
						System.out.println(Partida);
						System.out.println("Esse é o confronto desejado:\n");
						System.out.println("1 - Sim | 2- Não \n");
						int teste = tcl.nextInt();
						if(teste == 1) {
							System.out.println("Confronto inserido\n");
						}else{
							System.out.println("Digite o numero de partida novamente:");
							apo_confronto = tcl.nextInt();
							Selecionar_confronto dao_confronto_par1 = new Selecionar_confronto();
							System.out.println(dao_confronto_par1.confronto(apo_confronto));
						}
						System.out.println("Numero de identiicação do time");
						int apo_id_time = tcl.nextInt();
						Selecionar dao_time1 = new Selecionar();
						System.out.println(dao_time1.time_aposta(apo_id_time));
						System.out.println("Esse é o time desejado:\n");
						System.out.println("1 - Sim | 2- Não \n");
						teste = tcl.nextInt();
						if(teste == 1){
							System.out.println("Time inserido\n");
						}else{
							System.out.println("Digite o numero do time novamente:");
							apo_confronto = tcl.nextInt();
							System.out.println(dao_time1.time_aposta(apo_id_time));
						}
						int apo_id_jog = idjoga;
						Aposta aposta1 = new Aposta();
						aposta1.setApo_valor(apo_valor);
						aposta1.setApo_confronto(apo_confronto);
						aposta1.setApo_id_time(apo_id_time);
						aposta1.setApo_id_jog(apo_id_jog);
						Insercao dao_aposta = new Insercao();
						dao_aposta.adiciona_aposta(aposta1);
						System.out.println("Aposta realizado com sucesso!!!\n");
					break;
					
					case 2:
						Selecionar dao_selecionar = new Selecionar();
						List<Time_fut> Time_fut = dao_selecionar.getListarTime();
						System.out.println("Times Cadastrados\n");
						System.out.println("***ID***********Time*********");
						System.out.println(Time_fut);
					break;
					
					case 3:
						Selecionar_confronto dao_confronto = new Selecionar_confronto();
						List<Partida> Partida1 = dao_confronto.getListarConfrontos();
						System.out.println("Confrontos\n");
						System.out.println(Partida1);	
					break;
					
					case 4:
						System.out.println("########## DELETE A APOSTA ###########\n");
						System.out.println("ID do jogador...\n");
						System.out.println(idjoga);
						Selecionar_jogador dao_jogador1 = new Selecionar_jogador();
						List<Jogador> apostas = dao_jogador1.ListaJog(idjoga);
						System.out.println(apostas);						
						Funcoes_de_aposta funApo = new Funcoes_de_aposta(); 
						if(apostas != null && !apostas.isEmpty()) {
							System.out.println("Digite um ID valido\n");
							int apo_id = tcl.nextInt();
							funApo.delete(apo_id);
						}else {
							System.out.println("Nao existe aposta\n");
						}
						
					break;
					
					case 5:
						System.out.println("########## VALOR TOTAL APOSTADO EM UM TIME ###########\n");
						System.out.println("Digite o ID do time a ser consultado...\n");
						apo_id_time = tcl.nextInt();
						System.out.println("Valor total de aposta:\n");
						Funcoes_de_aposta funApo1 = new Funcoes_de_aposta(); 
						System.out.println(funApo1.ValorTotal(apo_id_time));
					break;
					
					case 6:
						System.out.println("########## ALTERAR APOSTA ###########\n");
						System.out.println("Digite o ID do usuario a ser consultado...\n");
						System.out.println("Aposta do Jogador\n");
						Selecionar_jogador dao_jogador = new Selecionar_jogador();
						System.out.println( dao_jogador.ListaJog(idjoga));
						System.out.println("Digite o ID da aposta que deseja alterar\n");
						int apo_id = tcl.nextInt();
						System.out.println("Valor da aposta:");
						apo_valor = tcl.nextFloat();
						System.out.println("Numero de partida");
						apo_confronto = tcl.nextInt();
						Selecionar_confronto dao_confronto_par1 = new Selecionar_confronto();
						List<Partida> Partida2 = dao_confronto_par1.confronto(apo_confronto);
						while(Partida2 == null) {
							System.out.println("Confronto invalido");
							System.out.println("Digite novamente\n");
							apo_confronto = tcl.nextInt();
							Partida2 = dao_confronto_par1.confronto(apo_confronto);
						}							
						System.out.println("Confrontos\n");
						System.out.println(Partida2);
						System.out.println("Esse é o confronto desejado:\n");
						System.out.println("1 - Sim | 2- Não \n");
						teste = tcl.nextInt();	
						if(teste == 1) {
							System.out.println("Confronto inserido\n");
						}else{
							System.out.println("Digite o numero de partida novamente:");
							apo_confronto = tcl.nextInt();
							System.out.println(dao_confronto_par1.confronto(apo_confronto));
						}
						System.out.println("Numero de identiicação do time");
						apo_id_time = tcl.nextInt();
						Selecionar dao_time2 = new Selecionar();
						System.out.println(dao_time2.time_aposta(apo_id_time));
						System.out.println("1 - Sim | 2- Não \n");
						teste = tcl.nextInt();
						if(teste == 1) {
							System.out.println("Time inserido com sucesso!!\n");
						}else{
							System.out.println("Digite o numero de partida novamente:");
							apo_confronto = tcl.nextInt();
							System.out.println(dao_time2.time_aposta(apo_id_time));
						}
						Aposta aposta = new Aposta();
						aposta.setApo_id(apo_id);
						aposta.setApo_valor(apo_valor);
						aposta.setApo_confronto(apo_confronto);		
						aposta.setApo_id_time(apo_id_time);	
						Insercao dao_alterar = new Insercao();
						dao_alterar.update(aposta);	
					break;
							
					case 7:
						Selecionar_confronto dao_resultado = new Selecionar_confronto();
						List<Partida> Resultado = dao_resultado.Resultado();
						System.out.println("Resultado\n");
						System.out.println(Resultado);
					break;
						
					case 0:
						System.out.println("Programa encerrado!!!\n");
						System.exit(1);
					break;
							
					default:
						System.out.println("\nDigite uma opcão válida!\n");
					}

						
				}while(opcao!=0);

			break;
				
			case 2:
				System.out.println("LOGIN DE USUARIO\n");
				System.out.println("Usuario:");
				jog_nome = in.readLine();
				System.out.println("Senha:");
				jog_senha = in.readLine();
			
				Selecionar_jogador joga1 = new Selecionar_jogador();
				List<Jogador> jog1 = joga1.consulta(jog_nome, jog_senha);
				
				Selecionar_jogador idJog1 = new Selecionar_jogador(); 
				int idjoga1 = idJog1.consulta_id(jog_nome);
				while(jog1 == null) {
					System.out.println("Usuario ou senha invalido!!!\n");
					System.out.println("LOGIN DE USUARIO\n");
					System.out.println("Usuario:");
					jog_nome = in.readLine();
					System.out.println("Senha:");
					jog_senha = in.readLine();
					jog1 = joga1.consulta(jog_nome, jog_senha);
					idjoga1 = idJog1.consulta_id(jog_nome);
				}
				System.out.println("Login efetudo com sucesso!!!\n");
				do{
					Menu();
					System.out.println("Digite a opção desejada: ");
					opcao2 = tcl.nextInt();
					switch(opcao2){
					
					case 1:
						System.out.println("Faça sua aposta:");
						System.out.println("Valor da aposta:");
						float apo_valor = tcl.nextFloat();
						System.out.println("Numero de partida");
						int apo_confronto = tcl.nextInt();
						Selecionar_confronto dao_confronto_par = new Selecionar_confronto();
						List<Partida> Partida = dao_confronto_par.confronto(apo_confronto);
						while(Partida == null) {
							System.out.println("Confronto invalido");
							System.out.println("Digite novamente\n");
							apo_confronto = tcl.nextInt();
							Partida = dao_confronto_par.confronto(apo_confronto);
						}
						System.out.println("Confrontos\n");
						System.out.println(Partida);
						System.out.println("Esse é o confronto desejado:\n");
						System.out.println("1 - Sim | 2- Não \n");
						int teste = tcl.nextInt();
						if(teste == 1) {
							System.out.println("Confronto inserido\n");
						}else{
							System.out.println("Digite o numero de partida novamente:");
							apo_confronto = tcl.nextInt();
							Selecionar_confronto dao_confronto_par1 = new Selecionar_confronto();
							System.out.println(dao_confronto_par1.confronto(apo_confronto));
						}
						System.out.println("Numero de identiicação do time");
						int apo_id_time = tcl.nextInt();
						Selecionar dao_time1 = new Selecionar();
						System.out.println(dao_time1.time_aposta(apo_id_time));
						System.out.println("Esse é o time desejado:\n");
						System.out.println("1 - Sim | 2- Não \n");
						teste = tcl.nextInt();
						if(teste == 1){
							System.out.println("Time inserido\n");
						}else{
							System.out.println("Digite o numero do time novamente:");
							apo_confronto = tcl.nextInt();
							System.out.println(dao_time1.time_aposta(apo_id_time));
						}
						int apo_id_jog = idjoga1;
						Aposta aposta1 = new Aposta();
						aposta1.setApo_valor(apo_valor);
						aposta1.setApo_confronto(apo_confronto);
						aposta1.setApo_id_time(apo_id_time);
						aposta1.setApo_id_jog(apo_id_jog);
						Insercao dao_aposta = new Insercao();
						dao_aposta.adiciona_aposta(aposta1);
						System.out.println("Aposta realizado com sucesso!!!\n");
					break;
					
					case 2:
						Selecionar dao_selecionar = new Selecionar();
						List<Time_fut> Time_fut = dao_selecionar.getListarTime();
						System.out.println("Times Cadastrados\n");
						System.out.println("***ID***********Time*********");
						System.out.println(Time_fut);
					break;
					
					case 3:
						Selecionar_confronto dao_confronto = new Selecionar_confronto();
						List<Partida> Partida1 = dao_confronto.getListarConfrontos();
						System.out.println("Confrontos\n");
						System.out.println(Partida1);
					break;
					
					case 4:
						System.out.println("########## DELETE A APOSTA ###########\n");
						System.out.println("ID do jogador...\n");
						System.out.println(idjoga1);
						int jog_id = idjoga1;
						Selecionar_jogador dao_jogador1 = new Selecionar_jogador();
						System.out.println( dao_jogador1.ListaJog(jog_id));
						Selecionar_jogador dao_jogador12 = new Selecionar_jogador();
						List<Jogador> apostas = dao_jogador12.ListaJog(idjoga1);
						System.out.println(apostas);						
						Funcoes_de_aposta funApo = new Funcoes_de_aposta(); 
						if(apostas != null && !apostas.isEmpty()) {
							System.out.println("Digite um ID valido\n");
							int apo_id = tcl.nextInt();
							funApo.delete(apo_id);
						}
					break;
					
					case 5:
						System.out.println("########## VALOR TOTAL APOSTADO EM UM TIME ###########\n");
						System.out.println("Digite o ID do time a ser consultado...\n");
						apo_id_time = tcl.nextInt();
						System.out.println("Valor total de aposta:\n");
						Funcoes_de_aposta funApo1 = new Funcoes_de_aposta(); 
						System.out.println(funApo1.ValorTotal(apo_id_time));
					break;
					
					case 6:
						System.out.println("########## ALTERAR APOSTA ###########\n");
						System.out.println("Digite o ID do usuario a ser consultado...\n");
						jog_id = tcl.nextInt();
						System.out.println("Aposta do Jogador\n");
						Selecionar_jogador dao_jogador = new Selecionar_jogador();
						System.out.println( dao_jogador.ListaJog(jog_id));
						System.out.println("Digite o ID da aposta que deseja alterar\n");
						int apo_id = tcl.nextInt();
						System.out.println("Valor da aposta:");
						apo_valor = tcl.nextFloat();
						System.out.println("Numero de partida");
						apo_confronto = tcl.nextInt();
						Selecionar_confronto dao_confronto_par1 = new Selecionar_confronto();
						List<Partida> Partida2 = dao_confronto_par1.confronto(apo_confronto);
						while(Partida2 == null) {
							System.out.println("Confronto invalido");
							System.out.println("Digite novamente\n");
							apo_confronto = tcl.nextInt();
							Partida2 = dao_confronto_par1.confronto(apo_confronto);
						}							
						System.out.println("Confrontos\n");
						System.out.println(Partida2);
						System.out.println("Esse é o confronto desejado:\n");
						System.out.println("1 - Sim | 2- Não \n");
						teste = tcl.nextInt();	
						if(teste == 1) {
							System.out.println("Confronto inserido\n");
						}else{
							System.out.println("Digite o numero de partida novamente:");
							apo_confronto = tcl.nextInt();
							System.out.println(dao_confronto_par1.confronto(apo_confronto));
						}
						System.out.println("Numero de identiicação do time");
						apo_id_time = tcl.nextInt();
						Selecionar dao_time2 = new Selecionar();
						System.out.println(dao_time2.time_aposta(apo_id_time));
						System.out.println("1 - Sim | 2- Não \n");
						teste = tcl.nextInt();
						if(teste == 1) {
							System.out.println("Time inserido com sucesso!!\n");
						}else{
							System.out.println("Digite o numero de partida novamente:");
							apo_confronto = tcl.nextInt();
							System.out.println(dao_time2.time_aposta(apo_id_time));
						}
						Aposta aposta = new Aposta();
						aposta.setApo_id(apo_id);
						aposta.setApo_valor(apo_valor);
						aposta.setApo_confronto(apo_confronto);		
						aposta.setApo_id_time(apo_id_time);	
						Insercao dao_alterar = new Insercao();
						dao_alterar.update(aposta);	
					break;
							
					case 7:
						Selecionar_confronto dao_resultado = new Selecionar_confronto();
						List<Partida> Resultado = dao_resultado.Resultado();
						System.out.println("Resultado\n");
						System.out.println(Resultado);	
					break;
						
					case 0:
						System.out.println("Programa encerrado!!!\n");
						System.exit(1);
					break;
							
					default:
						System.out.println("\nDigite uma opcão válida!\n");
					}

						
				}while(opcao!=0);

			break;
			case 0:
				System.out.println("Programa encerrado!!!\n");
				System.exit(1);
				break;
			default:
				System.out.println("\nDigite uma opcão válida!\n");
			}	
			
		}while(opcao != 0 && opcao != 1 && opcao != 2);
	}
}


