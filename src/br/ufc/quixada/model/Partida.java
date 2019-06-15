package br.ufc.quixada.model;

public class Partida  extends Time_fut{
	private int partida;
	private int confronto;
	private int time;
	private int resultado;
	
	public Partida(){
		super();
	}
		
	public Partida(int partida, int confronto, int time, int resultado, int id_time, String tim_nome) {
		super();
		this.partida = partida;
		this.confronto = confronto;
		this.time = time;
		this.resultado = resultado;
	}

	public int getPartida() {
		return partida;
	}

	public void setPartida(int partida) {
		this.partida = partida;
	}

	public int getConfronto() {
		return confronto;
	}

	public void setConfronto(int confonto) {
		this.confronto = confonto;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return  " Partida: " + confronto + " Time:" + this.getTim_nome()+ "\n";
	}

	
	
	
	
	
	
	
	
}
