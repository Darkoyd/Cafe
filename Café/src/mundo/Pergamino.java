package mundo;

import java.sql.Date;

public class Pergamino {
	
	private float peso;
	
	private Date fechaPergamino;
	
	private String propietario;

	public Pergamino(float peso, Date inicial, String pPropietario) {
		this.peso = peso;
		fechaPergamino = inicial;
		propietario = pPropietario;
	}

	public float getPeso() {
		return peso;
	}

	public Date getFechaPergamino() {
		return fechaPergamino;
	}
	
	public String getPropietario() {
		return propietario;
	}
	
	public void setPeso(float peso) {
		this.peso = peso;
	}
}
