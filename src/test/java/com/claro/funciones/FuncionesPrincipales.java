package com.claro.funciones;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import org.testng.TestNG;
import org.testng.xml.Parser;

import com.claro.resource.crm.FuncionesProperties;

public class FuncionesPrincipales {
	public static String texto;

	private static Thread hilo;
	int localizadorPanama=1;
	int dataPanama=2;
	public static JTextPane textPane;
	static int ordenPanama=14;
	static int ordenCostaRica=15;
	int localizadorCostaRica=3;
	int dataCostaRica=4;
	int localizadorGuatemala=9;
	int dataGuatemala=10;
	int localizadorCostaRicaV14=11;
	int dataCostaRicaV14=12;
	public static int validacion;
public static int validacionOpcion;
public final int prioridad_del_test=1;
public static String nombreTest;
public static String ResultadoDepruebas;
public static String getResultadoDepruebas() {
	return ResultadoDepruebas;
}
public static void setResultadoDepruebas(String resultadoDepruebas) {
	ResultadoDepruebas = resultadoDepruebas;
}

public static String dato;
public static String inicio,fin;//estos son variables desde donde se leen los datos a modificar y desde donde termina
public static int pais;
public static Thread getHilo() {
	return hilo;
}
public String botonEntradaText(String textDePregunta, String tituloJInput) {
	JFrame frame = new JFrame();
	frame.setAlwaysOnTop(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.setVisible(false);
	String variable = JOptionPane.showInputDialog(frame, textDePregunta, tituloJInput, JOptionPane.ERROR_MESSAGE);
	//si le dan cancelar al boton no entra en el if y retorna un cadena vacia
	if ((variable != null) && (variable.length() > 0)) {
		return variable;
	} else {
		return "";
	}

}

public void Testsuit(String test) throws IOException {
	String cuerpo = "<!DOCTYPE suite SYSTEM \"https://testng.org/testng-1.0.dtd\" >\r\n"
			+ "<suite name=\"Test-Suite\" >\r\n" + "   <test name=\"ToolsQA\" >\r\n" + "       <classes> \r\n"
			+ "          <class name=\"" + test + "\" />\r\n" + "       </classes>\r\n" + "   </test>\r\n"
			+ " </suite>";

	TestNG tng = new TestNG();
	ByteArrayInputStream is = new ByteArrayInputStream(cuerpo.getBytes());
	tng.setXmlSuites(new Parser(is).parseToList());
	tng.run();

}
public static void setTextPane(JTextPane textPane) {
	FuncionesPrincipales.textPane = textPane;
}


public static void setHilo(Thread hilo) {
	FuncionesPrincipales.hilo = hilo;
}
public int getDataPanama() {
	return dataPanama;
}
public void setDataPanama(int dataPanama) {
	this.dataPanama = dataPanama;
}
public static int getOrdenPanama() {
	return ordenPanama;
}
public static void setOrdenPanama(int ordenPanama) {
	FuncionesPrincipales.ordenPanama = ordenPanama;
}
public static int getOrdenCostaRica() {
	return ordenCostaRica;
}
public static void setOrdenCostaRica(int ordenCostaRica) {
	FuncionesPrincipales.ordenCostaRica = ordenCostaRica;
}
public static String getNombreTest() {
	return nombreTest;
}
public static void setNombreTest(String nombreTest) {
	FuncionesPrincipales.nombreTest = nombreTest;
}
public static String getDato() {
	return dato;
}
public static void setDato(String dato) {
	FuncionesPrincipales.dato = dato;
}
public static String getInicio() {
	return inicio;
}
public static void setInicio(String inicio) {
	FuncionesPrincipales.inicio = inicio;
}
public static String getFin() {
	return fin;
}
public static void setFin(String fin) {
	FuncionesPrincipales.fin = fin;
}
public static int getPais() {
	return pais;
}
public static void setPais(int pais) {
	FuncionesPrincipales.pais = pais;
}
public FuncionesProperties getProperties() {
	return properties;
}
public void setProperties(FuncionesProperties properties) {
	this.properties = properties;
}
public int getPrioridad_del_test() {
	return prioridad_del_test;
}
public static void setTexto(String texto) {
	FuncionesPrincipales.texto = texto;
}

private FuncionesProperties properties = new FuncionesProperties();

public String leerProperties(String propertie, int localizador) {
	FuncionesProperties propierties = new FuncionesProperties();
	return properties.leerProperties(propertie, localizador);
}
//Funcion para mandar error en JTextField en la interface
public void log(JTextArea display) {

	display.setText(getTexto());

}
//variable para el almacenamiento de texto y para despues mandarlo en el AreaText
public static String getTexto() {
	return texto;
}

public void recursos(String inicio,String fin,String dato,String nombreTest,int pais) {
	this.inicio=inicio;
	this.fin=fin;
	this.dato=dato;
	this.nombreTest=nombreTest;
	this.pais=pais;
	//aca se manda el nombre del test a ejecutar
}
//Funcion que se llama en el try Catch
	public void excepcion(String exception) {
		setTexto(exception);
		System.out.println("\n" + exception+ "\n");
	}
	
}



