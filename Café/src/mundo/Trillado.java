package mundo;

import java.sql.Date;

public class Trillado {
	
	protected float peso;
	
	protected Date fechaPergamino;
	
	protected Date fechaTrillado;
	
	public Trillado(float peso, Date inicial) {
		this.peso = peso;
		fechaPergamino = inicial;
	}

	public float getPeso() {
		return peso;
	}

	public Date getFechaPergamino() {
		return fechaPergamino;
	}

	public Date getFechaTrillado() {
		return fechaTrillado;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
}
