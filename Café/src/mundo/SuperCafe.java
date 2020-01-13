package mundo;

import java.sql.Date;

public class SuperCafe {
	
	public enum movimiento {
		PERGAMINO,
		TRILLANDO,
		EN_INVENTARIO,
		VENTA
	}
	
	private float peso;
	
	private Date fechaPergamino;
	
	private Date fechaTrillado;
	
	private Date fechaLote;
	
	private Date fechaVenta;
	
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
