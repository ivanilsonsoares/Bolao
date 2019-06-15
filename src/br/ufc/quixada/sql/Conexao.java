package br.ufc.quixada.sql;
import java.sql.Connection;
import java.sql.DriverManager;

import br.ufc.quixada.interfaces.IGenericConnectionFactory;


public class Conexao implements IGenericConnectionFactory{
	
	public Connection Conectar() {
		String url = "jdbc:postgresql://localhost:5432/Bolao";
		Connection con = null;
		String usuario ="postgres";
		String senha = "0414769";
			System.out.println("Conectando...");
			try {
				con = DriverManager.getConnection(url, usuario, senha);
				System.out.println("conectado!!!");
			}catch(Exception e) {
				System.out.println("Falha!!!");
			}
		return con;
	}
}

