package com.claro.interfaz;

import java.awt.TextArea;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import com.claro.resource.crm.FuncionesProperties;

public class CambioExtencionElimCopDeArchivo {
	FuncionesProperties f=new FuncionesProperties();
	 String[] parts;         
	 //expresion regular para validar un rango de numeros
//Funcion para modificar la extencion de un archivo
	public void renombrararchivo(String archivofuente,String extencionActual,String extencionFinal){


    File archivo1 = new File(archivofuente+extencionActual);

    File archivo2 = new File(archivofuente+extencionFinal);
    archivo1.renameTo(archivo2);    
    System.out.print("Archivo Renombrado con Exito");

}
	String line;

	public void CrearCopia(String ruta,String nombreLeer,String nombreCopya) {
	
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
        	File archivoOriginal = new File(ruta+nombreLeer+".txt");
            File archivoCopia = new File(ruta+nombreCopya+".txt");
            inputStream = new FileInputStream(archivoOriginal);
            outputStream = new FileOutputStream(archivoCopia);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            inputStream.close();
            outputStream.close();
            System.out.println("Archivo copiado.");
        } catch (IOException e) {
            e.printStackTrace();
        }}
	
	public void elminarArchivo(String ruta) {
		File fichero = new File(ruta);
		if (fichero.delete())
			   System.out.println("El fichero Copia ha sido borrado satisfactoriamente");
			else
			   System.out.println("El fichero copia no puede ser borrado");
	}
  
}
