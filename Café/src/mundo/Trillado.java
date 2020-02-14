package mundo;

import java.sql.Date;
import java.util.UUID;

public class Trillado {
	
	protected String parentID;

	protected String id;

	protected float peso;
	
	protected Date fechaPergamino;

	protected String variedad;
	
	protected Date fechaTrillado;
	
	public Trillado(float peso, Date inicial, Pergamino padre) {
		this.peso = peso;
		fechaTrillado = inicial;
		parentID = padre.getId();
		variedad = padre.getVariedad();
		fechaPergamino = padre.getFechaPergamino();
		id = UUID.randomUUID().toString();
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

	public String getId() {
		return id;
	}

	public String getParentId() {
		return parentID;
	}

	public String getVariedad() {
		return variedad;
	}
}
