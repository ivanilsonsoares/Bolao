package br.ufc.quixada.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.model.Partida;

public class Selecionar_confronto{
	private Connection con;
	
	public Selecionar_confronto() {
		this.con = new Conexao().Conectar();
	}
	
	public List<Partida> getListarConfrontos(){
		String sql = "select * from conf";
		
		try {
			List<Partida> ListaPartida = new ArrayList<Partida>();

				PreparedStatement listaPar = con.prepareStatement(sql);
				ResultSet rs = listaPar.executeQuery();
				while(rs.next()) {
					Partida lista_partida = new Partida();
					lista_partida.setTim_nome(rs.getString("nome_time"));
					lista_partida.setConfronto(rs.getInt("conf_time"));
					ListaPartida.add(lista_partida);
				}
				rs.close();
				listaPar.close();
				return ListaPartida;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Partida> Resultado(){
		String sql = "select * from resultado";
		
		try {
			List<Partida> ListaResultado = new ArrayList<Partida>();

				PreparedStatement listaRes = con.prepareStatement(sql);
				ResultSet rs = listaRes.executeQuery();
				while(rs.next()) {
					Partida lista_res = new Partida();
					lista_res.setTim_nome(rs.getString("nome"));
					lista_res.setConfronto(rs.getInt("confronto"));
					ListaResultado.add(lista_res);
				}
				rs.close();
				listaRes.close();
				return ListaResultado;
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Partida> confronto(int apo_confronto) {
		String sql ="select P.par_confronto, T.tim_nome from  time T, partida P"
				+ " where P.par_id_time = T.tim_id and  P.par_confronto =?";

		try {
			List<Partida> confronto = new  ArrayList<Partida>();
			PreparedStatement conf = con.prepareStatement(sql);
			conf.setInt(1, apo_confronto);
			ResultSet rs = conf.executeQuery();
			while(rs.next()){
				Partida lista_conf = new Partida();
				lista_conf.setConfronto(rs.getInt("par_confronto"));
				lista_conf.setTim_nome(rs.getString("tim_nome"));
				confronto.add(lista_conf);
			}
			rs.close();
			conf.close();
			if(confronto.isEmpty()) {
				System.out.println();
			}else {
				return confronto;	
			}
			
			
		}catch (SQLException e) {
			System.out.println("Falha");
		}
		return null;
	}
	
}
