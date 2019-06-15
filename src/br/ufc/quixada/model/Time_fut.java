package br.ufc.quixada.model;

public class Time_fut {
	private int tim_id;
	private String tim_nome;
	
	public Time_fut() {
		super();
	}
	
	public Time_fut(int tim_id, String tim_nome) {
		super();
		this.tim_id = tim_id;
		this.tim_nome = tim_nome;
	}

	public int getTim_id() {
		return tim_id;
	}

	public void setTim_id(int tim_id) {
		this.tim_id = tim_id;
	}

	public String getTim_nome() {
		return tim_nome;
	}

	public void setTim_nome(String tim_nome) {
		this.tim_nome = tim_nome;
	}

	@Override
	public String toString() {
		String modelo = "\n   "+tim_id + "  --------->  "+ tim_nome + "\n" ;
		return modelo;
	}

	
	
	
	
	
}
