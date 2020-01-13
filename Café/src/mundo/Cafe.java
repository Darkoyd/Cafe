package mundo;

public class Cafe extends SuperCafe
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
	
	private String codigoDeBarras;
	
	//Constructor
	
	public Cafe(tostion pTostion, molienda pMolienda, presentacion pPresentacion, String pCodigoDeBarras)
	{
		tostion = pTostion;
		molienda = pMolienda;
		presentacion = pPresentacion;
		cantidad = 0;
		codigoDeBarras = pCodigoDeBarras;
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
	
	public presentacion darPresentacion()
	{
		return presentacion;
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
