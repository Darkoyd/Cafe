package interfaz;

import javax.swing.*;

import mundo.Inventario;

import java.awt.*;

public class InterfazCafe extends JFrame
{
	private Inventario inventario;
	
	//------------------------------------------------------------------
		//Bob the Builder
	//------------------------------------------------------------------
	public InterfazCafe()
	{
		inventario = new Inventario();
		//--Main Frame Format-------------------------------------------
		setTitle("Coffee Manager");
		setResizable(false);
		setSize(820, 740);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//------------------------------------------------------------------
		//Main
	//------------------------------------------------------------------
	public static void main (String[] pArgs)
	{
		InterfazCafe x = new InterfazCafe();
		x.setVisible(true);
	}
}
