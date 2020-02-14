package mundo;

import java.sql.Date;

public class CafeInventario
{
	//Atributos
	
	public enum presentacion
	{
		MUESTRA,
		CUARTO,
		MEDIA,
		LIBRA,
		CINCO,
		DIEZ
	}
	public enum tostion
	{
		MEDIA_BAJA,
		MEDIA,
		MEDIA_ALTA
	}
	public enum molienda
	{
		EX_FINA,
		FINA,
		MEDIA,
		MEDIA_GRUESA,
		SIN_MOLER
	}
	
	private tostion tostion;
	
	private molienda molienda;
	
	private presentacion presentacion;
	
	private int cantidad;

	private int cantidadVendida;
	
	private Date fecha;

	private String parentID;
	
	private String codigoDeBarras;
	
	private String variedad;
	
	//Constructor
	
	public CafeInventario(tostion pTostion, molienda pMolienda, presentacion pPresentacion, Date fecha, String pCodigoDeBarras, Trillado padre, int cantidad)
	{
		tostion = pTostion;
		molienda = pMolienda;
		parentID = padre.getId();
		presentacion = pPresentacion;
		this.fecha = fecha;
		this.cantidad = cantidad;
		cantidadVendida = 0;
		codigoDeBarras = pCodigoDeBarras;
		this.variedad = padre.getVariedad();
	}
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
	
	public void quitarCantidad(int pCantidad)
	{
		cantidad -= pCantidad;
	}

	public String getParentId() {
		return parentID;
	}

	public int getCantidadVendida() {
		return cantidadVendida;
	}
}
