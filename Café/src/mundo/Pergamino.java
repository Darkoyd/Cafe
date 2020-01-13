package mundo;

import java.sql.Date;

public class Pergamino {
	
	protected float peso;
	
	protected Date fechaPergamino;
	
	public Pergamino(float peso, Date inicial) {
		this.peso = peso;
		fechaPergamino = inicial;
	}

	public float getPeso() {
		return peso;
	}

	public Date getFechaPergamino() {
		return fechaPergamino;
	}
	
	public void setPeso(float peso) {
		this.peso = peso;
	}
}
