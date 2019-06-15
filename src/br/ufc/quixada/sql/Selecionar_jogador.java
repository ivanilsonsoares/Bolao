package br.ufc.quixada.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import br.ufc.quixada.model.Jogador;

public class Selecionar_jogador{
	private Connection con;

	public Selecionar_jogador () {
		this.con = new Conexao().Conectar();
	}
	
	public List<Jogador> ListaJog(int jog_id) {
		String sql ="select  J.jog_id,J.jog_nome, A.apo_id from jogador J , aposta A "
				+ "where  A.apo_id_jog = J.jog_id and J.jog_id =?";

		try {
			List<Jogador> Jogador = new  ArrayList<Jogador>();
			PreparedStatement jog = con.prepareStatement(sql);
			jog.setInt(1, jog_id);
			ResultSet rs = jog.executeQuery();
			while(rs.next()){
				Jogador lista_jog = new Jogador();
				lista_jog.setJog_id(rs.getInt("jog_id"));
				lista_jog.setJog_nome(rs.getString("jog_nome"));
				lista_jog.setApo_id(rs.getInt("apo_id"));
				Jogador.add(lista_jog);
			}
			rs.close();
			jog.close();
			if(Jogador.isEmpty()) {
				System.out.println();
			}else {
				return Jogador;
			}
		}catch (SQLException e) {
			System.out.println("Falha");
		}
		return null;
	}
	
	public List<Jogador> VerificarJog(String jog_nome) {
		String sql ="select  jog_nome,jog_senha from jogador"
				+ " where  jog_nome = ?";

		try {
			List<Jogador> Jogador = new  ArrayList<Jogador>();
			PreparedStatement jog = con.prepareStatement(sql);
			jog.setString(1, jog_nome);
			ResultSet rs = jog.executeQuery();
			while(rs.next()){
				Jogador lista_jog = new Jogador();
				lista_jog.setJog_nome(rs.getString("jog_nome"));
				Jogador.add(lista_jog);
			}
			rs.close();
			jog.close();
			
			return Jogador;
		}catch (SQLException e) {
			System.out.println("Falha");
		}
		return null;
	}
	
	
	public List<Jogador> consulta(String jog_nome, String jog_senha) {
		String sql ="select  jog_nome,jog_senha from jogador where  jog_nome = ? and jog_senha =?";

		try {
			List<Jogador> Jogador = new  ArrayList<Jogador>();
			PreparedStatement jog = con.prepareStatement(sql);
			jog.setString(1, jog_nome);
			jog.setString(2, jog_senha);
			ResultSet rs = jog.executeQuery();
			while(rs.next()){
				Jogador lista_jog = new Jogador();
				lista_jog.setJog_nome(rs.getString("jog_nome"));
				lista_jog.setJog_senha(rs.getString("jog_senha"));
				Jogador.add(lista_jog);
			}
			rs.close();
			jog.close();
			if(Jogador.isEmpty()) {
				System.out.println("nulo");
				return null;
			}else {
				return Jogador;
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	public int consulta_id(String jog_nome) {
		String sql ="select jog_id from jogador where jog_nome = ?";
		int resul =0;
		try {
			PreparedStatement jog = con.prepareStatement(sql);
			jog.setString(1, jog_nome);
			ResultSet rs = jog.executeQuery();
			rs.next();
			resul = rs.getInt("jog_id");
			rs.close();
			jog.close();

		}catch (SQLException e) {
			System.out.println(e);
		}
		return resul;
	}
	
	
		
}


