package mundo;

import java.sql.Date;

public class SuperCafe {
	
	public enum movimiento {
		PERGAMINO,
		TRILLANDO,
		EN_INVENTARIO,
		VENTA
	}
	
	protected float peso;
	
	protected Date fechaPergamino;
	
	protected Date fechaTrillado;
	
	protected Date fechaLote;
	
	protected Date fechaVenta;
	
	public SuperCafe(float peso, Date inicial) {
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

	public Date getFechaLote() {
		return fechaLote;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}
	
	public void setPeso(float peso) {
		this.peso = peso;
	}
}
