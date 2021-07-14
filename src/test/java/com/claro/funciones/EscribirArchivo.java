package com.claro.funciones;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import com.claro.interfaz.CambioExtencionElimCopDeArchivo;
/**
 *
 * @author decodigo
 */
public class EscribirArchivo {
    	
			int contador=1;
			String line;
			CambioExtencionElimCopDeArchivo r=new CambioExtencionElimCopDeArchivo();
		
    public void escribir(JTextArea txtDatos,String rutaOriginal){
    	boolean validacion=true;
    	String contenidoTexto=new String(txtDatos.getText());
    	
		StringTokenizer st= new StringTokenizer(contenidoTexto,"\n");
		 String[] parts=null,parts1=null; 
		 String datofinal="",datofinal1="";
		 
		   String nombreFichero = rutaOriginal+"Copy.txt";
	        //Declarar una variable BufferedReader
	        BufferedReader br = null;
	        //fichero que se le va a escribir
	 	   	File fout = new File(rutaOriginal+".txt");
	        try {
	           	FileOutputStream fos = new FileOutputStream(fout);
	        	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	           //Crear un objeto BufferedReader al que se le pasa 
	           //   un objeto FileReader con el nombre del fichero
	          br = new BufferedReader(new InputStreamReader(new FileInputStream(nombreFichero), "ISO-8859-1"));
	           //Leer la primera línea, guardando en un String
	           String texto = br.readLine();
	           //Repetir mientras no se llegue al final del fichero
	           while(texto != null)
	           {     	  
	        	
  	        	  if( st.hasMoreTokens()) {
  	        		 while(validacion) {
 	    	 	        line=st.nextToken();
 	        		 if(!line.equals("")) {
 			   	   			if(!line.substring(0,1).equals("#")) {

 			   	   		  parts1=line.split("=");

 			   	   		  datofinal1=parts1[0];
 			   	   		  validacion=false;

 			   	   			}
 			   	   			}
 	  	 	        System.out.print("\n."+line+".\n");

 	        	           }

  	                  	  }

  	        	 if(!texto.equals("")) {
 	   	   			if(!texto.substring(0,1).equals("#")) {
 	   	   		    parts=texto.split("=");
 			       	datofinal=parts[0];
 	   	   			}
  	        	 }
  	        	 try {
					
				
 	   	   		if(datofinal.equals(datofinal1)&&!texto.substring(0,1).equals("#")&&!texto.equals("")) {
		    		
			    		 bw.write(line);
					      	bw.newLine();	   
		    		 validacion=true;
		    	}else {		    		
		    		bw.write(texto);
		    		bw.newLine();
		    	}
  	        	} catch (Exception e) {
			      	bw.newLine();

				}
	        	   //Leer la siguiente línea
	        	   texto = br.readLine(); 
	        	   contador++;
	           }
	        // despues de escribir cierra el archivo
	    	     	bw.close();
	    	     	br.close();
	    	     	fos.close();
	        }
	        catch (FileNotFoundException e) {
	            System.out.println("Error: Fichero no encontrado");
	            System.out.println(e.getMessage());
	        }
	        catch(Exception e) {
	            System.out.println("Error de lectura del fichero");
	            System.out.println(e.getMessage());
	        }
	        finally {
	            try {
	                if(br != null)
	                    br.close();
	            }
	            catch (Exception e) {
	                System.out.println("Error al cerrar el fichero");
	                System.out.println(e.getMessage());
	            }
	        }
	        //despues de realizar los cambios se eliminaa el archivo tipoCopia
	        r.elminarArchivo(rutaOriginal+"Copy.txt");
	        
	   }
    //JtextPane
    public void escribirr(JTextPane txtDatos,String rutaOriginal){	
    	boolean validacion=true;
    	String contenidoTexto=new String(txtDatos.getText().trim());
		StringTokenizer st= new StringTokenizer(contenidoTexto,"\n");
		 String[] parts=null,parts1=null; 
		 String datofinal="",datofinal1="";
	    	System.out.print(contenidoTexto);

		   String nombreFichero = rutaOriginal+"Copy.txt";
	        //Declarar una variable BufferedReader
	        BufferedReader br = null;
	        //fichero que se le va a escribir
	 	   	File fout = new File(rutaOriginal+".txt");
	        try {
	           	FileOutputStream fos = new FileOutputStream(fout);
	        	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	           //Crear un objeto BufferedReader al que se le pasa 
	           //   un objeto FileReader con el nombre del fichero
	          br = new BufferedReader(new InputStreamReader(new FileInputStream(nombreFichero), "ISO-8859-1"));
	           //Leer la primera línea, guardando en un String
	           String texto = br.readLine();
	           //Repetir mientras no se llegue al final del fichero
	           while(texto != null)
	           {     	  
	        	
  	        	  if( st.hasMoreTokens()) {
  	        		 while(validacion) {
 	    	 	        line=st.nextToken().trim();
 	        		 if(!line.equals("")) {
 			   	   			if(!line.substring(0,1).equals("#")) {

 			   	   		  parts1=line.split("=");

 			   	   		  datofinal1=parts1[0];
 			   	   		  validacion=false;

 			   	   			}
 			   	   			}
 	        	           }

  	                  	  }

  	        	 if(!texto.equals("")) {
 	   	   			if(!texto.substring(0,1).equals("#")) {
 	   	   		    parts=texto.split("=");
 			       	datofinal=parts[0];
 	   	   			}
  	        	 }
  	        	 try {
					
				
 	   	   		if(datofinal.equals(datofinal1)&&!texto.substring(0,1).equals("#")&&!texto.equals("")) {
		    		
			    		 bw.write(line);
					      	bw.newLine();	   
		    		 validacion=true;
		    	}else {		    		
		    		bw.write(texto);
		    		bw.newLine();
		    	}
  	        	} catch (Exception e) {
			      	bw.newLine();

				}
	        	   //Leer la siguiente línea
	        	   texto = br.readLine(); 
	        	   contador++;
	           }
	        // despues de escribir cierra el archivo
	    	     	bw.close();
	    	     	br.close();
	    	     	fos.close();
	        }
	        catch (FileNotFoundException e) {
	            System.out.println("Error: Fichero no encontrado");
	            System.out.println(e.getMessage());
	        }
	        catch(Exception e) {
	            System.out.println("Error de lectura del fichero");
	            System.out.println(e.getMessage());
	        }
	        finally {
	            try {
	                if(br != null)
	                    br.close();
	            }
	            catch (Exception e) {
	                System.out.println("Error al cerrar el fichero");
	                System.out.println(e.getMessage());
	            }
	        }
	        //despues de realizar los cambios se eliminaa el archivo tipoCopia
	        r.elminarArchivo(rutaOriginal+"Copy.txt");
	   }
    
}