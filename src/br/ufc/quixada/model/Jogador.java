package br.ufc.quixada.model;

public class Jogador extends Aposta{
	private int jog_id;
	private String jog_nome;
	private String jog_senha;
	
	public Jogador(int jog_id, String jog_nome, String jog_senha,int apo_id, float apo_valor, int apo_confronto, int apo_id_time, int apo_id_jog,int apo_id_partida) {
		this.jog_id = jog_id;
		this.jog_nome = jog_nome;
		this.jog_senha = jog_senha;
	}

	public Jogador() {
		super();
	}

	public int getJog_id() {
		return jog_id;
	}

	public void setJog_id(int jog_id) {
		this.jog_id = jog_id;
	}

	public String getJog_nome() {
		return jog_nome;
	}

	public void setJog_nome(String jog_nome) {
		this.jog_nome = jog_nome;
	}

	public String getJog_senha() {
		return jog_senha;
	}

	public void setJog_senha(String jog_senha) {
		this.jog_senha = jog_senha;
	}

	@Override
	public String toString() {
		String modelo = "Jogador ID = " + jog_id + " Nome = " + jog_nome +"\n"+ " Aposta:" + this.getApo_id() + "\n";
		return modelo;
	}

	
	
	

}
