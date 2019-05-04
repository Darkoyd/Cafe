package mundo;

import java.util.ArrayList;

import mundo.Cafe.molienda;
import mundo.Cafe.presentacion;
import mundo.Cafe.tostion;

public class Inventario 
{
	//Atributos
	
	private ArrayList <Cafe> cafes;
	
	private ArrayList <String> movimientos;
	
	//Constructor
	/*
	 * Metodo constructor del inventario.
	 */
	public Inventario()
	{
		cafes = new ArrayList <Cafe>();
		movimientos = new ArrayList<String>();
	}
	
	//Metodos
	
	/*
	 * Método que agrega un café.
	 */
	public void agregarCafe(tostion pTostion, molienda pMolienda, presentacion pPresentacion, String pCodigoDeBarras) throws Exception
	{
		Cafe x = new Cafe(pTostion, pMolienda, pPresentacion, pCodigoDeBarras);
		if(buscarCafe(pCodigoDeBarras) == null)
		{
			cafes.add(x);
		}
		else
			throw new Exception("Ya existe ese café");
	}
	
	public Cafe buscarCafe(String pCodigoDeBarras)
	{
		boolean encontrado = false;
		Cafe cafe = null;
		for (int i = 0; i < cafes.size() && !encontrado; i++)
		{
			if (cafes.get(i).darCodigoDeBarras().equals(pCodigoDeBarras))
			{
				cafe = cafes.get(i);
			}
		}
		return cafe;
	}
	
	public void registrarMovimiento(int pCantidad, boolean entro, String pCodigoDeBarras)
	{
		Cafe cafe = buscarCafe(pCodigoDeBarras);
		if (cafe != null)
		{
			if(entro)
			{
				cafe.agregarCantidad(pCantidad);
				movimientos.add("Se ingresaron " + pCantidad +" unidades.");
			}
			else
			{
				cafe.quitarCantidad(pCantidad);
				movimientos.add("Se retiraron " + pCantidad + " unidades.");
			}
		}
	}
}
