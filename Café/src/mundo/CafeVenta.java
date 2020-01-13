package mundo;

import java.sql.Date;

import mundo.CafeInventario.molienda;
import mundo.CafeInventario.presentacion;
import mundo.CafeInventario.tostion;


public class CafeVenta {
	//Atributos
	
	
	private tostion tostion;
	
	private molienda molienda;
	
	private presentacion presentacion;
	
	private int cantidad;
	
	private Date fecha;
	
	private String codigoDeBarras;
	
	private String variedad;
	
	//Metodos
	
	public int darCantidad()
	{
		return cantidad;
	}
	
	public String darCodigoDeBarras()
	{
		return codigoDeBarras;
	}
	
	public molienda darMolienda()
	{
		return molienda;
	}
	
	public tostion darTostion()
	{
		return tostion;
	}
	
	public Date darFecha()
	{
		return fecha;
	}
	
	public presentacion darPresentacion()
	{
		return presentacion;
	}
	
	public String darVariedad()
	{
		return variedad;
	}
	
	public void agregarCantidad(int pCantidad)
	{
		cantidad += pCantidad;
	}
	
	public void quitarCantidad(int pCantidad)
	{
		cantidad -= pCantidad;
	}
	public CafeVenta(tostion pTostion, molienda pMolienda, presentacion pPresentacion, Date fecha, String pCodigoDeBarras, String variedad) {
		tostion = pTostion;
		molienda = pMolienda;
		presentacion = pPresentacion;
		this.fecha = fecha;
		cantidad = 0;
		codigoDeBarras = pCodigoDeBarras;
		this.variedad = variedad;
	}

}
