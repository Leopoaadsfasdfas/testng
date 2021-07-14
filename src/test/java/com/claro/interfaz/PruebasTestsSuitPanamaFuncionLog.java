package com.claro.interfaz;

import java.io.IOException;

import javax.swing.JTextArea;

import com.claro.funciones.FuncionesPrincipales;

public class PruebasTestsSuitPanamaFuncionLog {
	FuncionesPrincipales n = new FuncionesPrincipales();
	public static String texto;

	public static String getTexto() {
		return texto;
	}

	public static void setTexto(String texto) {
		PruebasTestsSuitPanamaFuncionLog.texto = texto;
	}

	//prueba Venta Nueva Panama Multimedia Gpon
	public void testng1(String entrada) {
		System.out.print("\n"+entrada+"\n");
		try {
			n.Testsuit(entrada);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			n.botonEntradaText(e.getMessage(), "Log");
		}
	}

	//Funcion para mandar error en JTextField en la interface
	public void log(JTextArea display) {

		display.setText(getTexto());

	}

}
