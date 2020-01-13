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
	
	private Date fecha;
	
	private String codigoDeBarras;
	
	private String variedad;
	
	//Constructor
	
	public CafeInventario(tostion pTostion, molienda pMolienda, presentacion pPresentacion, Date fecha, String pCodigoDeBarras, String variedad)
	{
		tostion = pTostion;
		molienda = pMolienda;
		presentacion = pPresentacion;
		this.fecha = fecha;
		cantidad = 0;
		codigoDeBarras = pCodigoDeBarras;
		this.variedad = variedad;
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
	
	public void agregarCantidad(int pCantidad)
	{
		cantidad += pCantidad;
	}
	
	public void quitarCantidad(int pCantidad)
	{
		cantidad -= pCantidad;
	}
}
