package br.ufc.quixada.sql;
import java.sql.*;

import br.ufc.quixada.model.*; 

public class Insercao {
	private Connection con;
	public Insercao() {
		this.con = new Conexao().Conectar();
	}
	 public void adiciona(Jogador jogador) { 
	        String sql = "INSERT INTO jogador(jog_nome,jog_senha) VALUES(?,?)";
	        try {
	        	PreparedStatement inserir = con.prepareStatement(sql);

	        	if(jogador.getJog_nome() != null && jogador.getJog_senha().trim().length() >0
	        		&&	jogador.getJog_senha() != null && jogador.getJog_nome().trim().length() >0 )  {
		        	inserir.setString(1, jogador.getJog_nome());
		        	inserir.setString(2, jogador.getJog_senha());
		        	inserir.execute();
		        	inserir.close();	
	        	}else {
	        		System.out.println("campo nulo!!");
	        		
	        	}

	        } 
	        catch (SQLException e) { 
	        	System.out.println("Erro!!!");
	        }
	    }
	 
	 public void adiciona_aposta(Aposta aposta) { 
	        String sql = "INSERT INTO aposta(apo_valor,apo_confronto,apo_id_time,apo_id_jog) VALUES (?,?,?,?)";
	        try {
	        	PreparedStatement inserir = con.prepareStatement(sql);
	        	inserir.setFloat(1, aposta.getApo_valor());
	        	inserir.setInt(2, aposta.getApo_confronto());
	        	inserir.setInt(3, aposta.getApo_id_time());
	        	inserir.setInt(4, aposta.getApo_id_jog());
	        	inserir.execute();
	        	inserir.close();

	        } 
	        catch (SQLException e) { 
	            throw new RuntimeException(e);
	        }
	    }
	 
	 public boolean update(Aposta aposta) {
			String sql ="UPDATE aposta SET apo_valor =? , apo_confronto = ?, apo_id_time = ? "
					+ "WHERE apo_id = ?" ;
			try {
				PreparedStatement atualizar = con.prepareStatement(sql);
				atualizar.setFloat(1,aposta.getApo_valor());
				atualizar.setInt(2,aposta.getApo_confronto());
				atualizar.setInt(3, aposta.getApo_id_time());
				atualizar.setInt(4, aposta.getApo_id());
				int quantidade = atualizar.executeUpdate();
				atualizar.close();
				if(quantidade > 0) {
					return true;
				}
				return false;
			}catch (SQLException e) {
				System.out.println("Erro...\n");
			}finally {
				try {
					this.con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			return false;
		}
	 
}

