package br.ufc.quixada.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Funcoes_de_aposta{
	private Connection con;
	
	public Funcoes_de_aposta() {
		this.con = new Conexao().Conectar();
	}
		
	public void delete(int apo_id) {
		String sql =" delete from aposta where apo_id = ?";
		
		try {
			PreparedStatement deletar = con.prepareStatement(sql);
			deletar.setInt(1, apo_id);
			
			int quantidade = deletar.executeUpdate();
			if(quantidade > 0) {
				System.out.println("Excluida!!");
			}
			deletar.close();
		}catch (SQLException e) {
			System.out.println(e);
		}
		
	}
	
	public float ValorTotal(int apo_id_time) {
		String sql =" select soma_de_aposta(?)";
		float resul=0;
		try {
			PreparedStatement total = con.prepareStatement(sql);
			total.setInt(1, apo_id_time);
			ResultSet rs = total.executeQuery();
			rs.next();
			resul = rs.getFloat("soma_de_aposta");
			total.close();
			
		}catch (SQLException e) {
			System.out.println("Falha");
		}
		
		return resul;
	}
	
	
	
	
	
}
