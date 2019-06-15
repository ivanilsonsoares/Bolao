package br.ufc.quixada.model;

public class Aposta extends Time_fut{
	private int apo_id;
	private float apo_valor;
	private int apo_confronto;
	private int apo_id_time;
	private int apo_id_jog;
	private int apo_id_partida;
	
	public Aposta() {
		super();
	}
	
	public Aposta(int apo_id, float apo_valor, int apo_confronto, int apo_id_time, int apo_id_jog, int apo_id_partida) {
		super();
		this.apo_id = apo_id;
		this.apo_valor = apo_valor;
		this.apo_confronto = apo_confronto;
		this.apo_id_time = apo_id_time;
		this.apo_id_jog = apo_id_jog;
		this.apo_id_partida = apo_id_partida;
	}

	public int getApo_id() {
		return apo_id;
	}

	public void setApo_id(int apo_id) {
		this.apo_id = apo_id;
	}

	public float getApo_valor() {
		return apo_valor;
	}

	public void setApo_valor(float apo_valor) {
		this.apo_valor = apo_valor;
	}

	public int getApo_confronto() {
		return apo_confronto;
	}

	public void setApo_confronto(int apo_confronto) {
		this.apo_confronto = apo_confronto;
	}

	public int getApo_id_time() {
		return apo_id_time;
	}

	public void setApo_id_time(int apo_id_time) {
		this.apo_id_time = apo_id_time;
	}

	public int getApo_id_jog() {
		return apo_id_jog;
	}

	public void setApo_id_jog(int apo_id_jog) {
		this.apo_id_jog = apo_id_jog;
	}

	public int getApo_id_partida() {
		return apo_id_partida;
	}

	public void setApo_id_partida(int apo_id_partida) {
		this.apo_id_partida = apo_id_partida;
	}

	@Override
	public String toString() {
		return "Aposta [apo_id=" + apo_id + ", apo_valor=" + apo_valor + ", apo_confronto=" + apo_confronto
				+ ", apo_id_time=" + apo_id_time + ", apo_id_jog=" + apo_id_jog + ", apo_id_partida=" + apo_id_partida
				+ ", getApo_id()=" + getApo_id() + ", getApo_valor()=" + getApo_valor() + ", getApo_confronto()="
				+ getApo_confronto() + ", getApo_id_time()=" + getApo_id_time() + ", getApo_id_jog()=" + getApo_id_jog()
				+ ", getApo_id_partida()=" + getApo_id_partida() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	

}
