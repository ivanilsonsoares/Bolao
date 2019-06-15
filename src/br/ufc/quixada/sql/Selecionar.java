package br.ufc.quixada.sql;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import br.ufc.quixada.model.Time_fut;

public class Selecionar{
	private Connection con;
	
	public Selecionar() {
		this.con = new Conexao().Conectar();
		
	}
	public List<Time_fut> getListarTime(){
		String sql = "SELECT * FROM time";
		
		try {
			List<Time_fut> TimeLista = new ArrayList<Time_fut>();
			PreparedStatement lista = con.prepareStatement(sql);
			ResultSet rs = lista.executeQuery();
			while(rs.next()) {
				Time_fut lista_time = new Time_fut();
				lista_time.setTim_id(rs.getInt("Tim_id"));
				lista_time.setTim_nome(rs.getString("Tim_nome"));
				TimeLista.add(lista_time);
			}
			rs.close();
			lista.close();
			return TimeLista;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		} 
	}
	public String time_aposta(int apo_id_time) {
		String sql ="select T.tim_nome from aposta A , time T where A.apo_id_time = T.tim_id and  T.tim_id =?";
		String resul = "";
		try {
			PreparedStatement time = con.prepareStatement(sql);
			time.setInt(1, apo_id_time);
			ResultSet rs = time.executeQuery();
			rs.next();
			resul = rs.getString("tim_nome");
			time.close();
		} catch (SQLException e) {
			System.out.println("time não existe");
		}
		return resul;
	}

	
}
