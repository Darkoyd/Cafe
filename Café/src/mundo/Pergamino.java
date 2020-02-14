package mundo;

import java.sql.Date;
import java.util.UUID;

public class Pergamino {
	
	private final String idPergamino;

	private final float peso;

	private final Date fechaPergamino;

	private final String variedad;

	private final String propietario;

	public Pergamino(final float peso, final Date inicial, final String pPropietario, final String variedad) {
		this.idPergamino = UUID.randomUUID().toString();
		this.peso = peso;
		fechaPergamino = inicial;
		propietario = pPropietario;
		this.variedad = variedad;
	}

	public String getVariedad() {
		return variedad;
	};

	public float getPeso() {
		return peso;
	}

	public String getId() {
		return idPergamino;
	}

	public Date getFechaPergamino() {
		return fechaPergamino;
	}
	
	public String getPropietario() {
		return propietario;
	}
}
