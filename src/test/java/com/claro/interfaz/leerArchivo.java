package com.claro.interfaz;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import com.claro.resource.crm.FuncionesProperties;

import java.awt.Color;


public class leerArchivo {
	SimpleAttributeSet color_de_regreso;
	 String[] parts=null,parts1=null; 
FuncionesProperties fp=new FuncionesProperties();
	CambioExtencionElimCopDeArchivo r=new CambioExtencionElimCopDeArchivo();
	public void leer(JTextArea display,String ruta,String inicio, String fin,String nombreCopy,String nombreLeer){
		//renombrar archivo para leerlo como txt
		r.renombrararchivo(ruta+nombreLeer+".","properties","txt");
		//hacer una compia del archivo
		
	r.CrearCopia(ruta,nombreLeer,nombreCopy);

		   boolean validacion=false;
		   String nombreFichero =ruta+nombreLeer+".txt";
	        //Declarar una variable BufferedReader
	        BufferedReader br = null;
	        try {
	           //Crear un objeto BufferedReader al que se le pasa 
	           //   un objeto FileReader con el nombre del fichero
	          br = new BufferedReader(new InputStreamReader(new FileInputStream(nombreFichero), "ISO-8859-1"));
	           //Leer la primera línea, guardando en un String
	           String texto = br.readLine();
	           //Repetir mientras no se llegue al final del fichero
	           while(texto != null)
	           {     	  
	        	   if(texto.equals(fin)) {
	        		   validacion=false;
	        	   }
	               //Hacer lo que sea con la línea leída
	               if(validacion==true) {
	          	            //   System.out.println(texto);
	    		               display.append(texto+"\n");
	           		
	               }
	          	 
//verifica si encontro inicio entonces empiece a mandar el texto leido en el textArea
	        	   if(texto.equals(inicio)) {
		        		 validacion=true;  
		        	   }
	        	   //Leer la siguiente línea
	        	   texto = br.readLine(); 
	           }
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
	   }
	public void leer(JTextPane display,String ruta,String inicio, String fin,String nombreCopy,String nombreLeer){
		//renombrar archivo para leerlo como txt
		r.renombrararchivo(ruta+nombreLeer+".","properties","txt");
		//hacer una compia del archivo
		StyledDocument doc = display.getStyledDocument();

	r.CrearCopia(ruta,nombreLeer,nombreCopy);
		
		   boolean validacion=false;
		   String nombreFichero =ruta+nombreLeer+".txt";
	        //Declarar una variable BufferedReader
	        BufferedReader br = null;
	        try {
	           //Crear un objeto BufferedReader al que se le pasa 
	           //   un objeto FileReader con el nombre del fichero
	          br = new BufferedReader(new InputStreamReader(new FileInputStream(nombreFichero), "ISO-8859-1"));
	           //Leer la primera línea, guardando en un String
	           String texto = br.readLine();
	           //Repetir mientras no se llegue al final del fichero
	           while(texto != null)
	           {     	  
	        	   if(texto.equals(fin)) {
	        		   validacion=false;
	        	   }
	               //Hacer lo que sea con la línea leída
	               if(validacion==true) {
	    		               try
	    		               {	 
		          	       try {
		          	    	 if(texto.substring(0,1).equals("#")) {
 	    		                 doc.insertString(doc.getLength(), texto+"\n",color(fp.leerProperties("comentario", 13)));	    		    		   

							}else{
								parts=texto.split("=");
	    		                 doc.insertString(doc.getLength(), parts[0],color(fp.leerProperties("llave", 13)));
	    		                 doc.insertString(doc.getLength(),"=",color(fp.leerProperties("igual", 13)));	    		    		   
	    		                 doc.insertString(doc.getLength(), parts[1]+"\n",color(fp.leerProperties("valor", 13)));	    		    		   

                           }	

						} catch (Exception e) {
   		                 doc.insertString(doc.getLength(),"\n", color("Blanco"));	    		    		   
						}

 
		                 
	    		            	   
	    		               }
	    		               
	    		               catch(Exception e) { System.out.println(e); }	           		
	               }
	          	 
//verifica si encontro inicio entonces empiece a mandar el texto leido en el textArea
	        	   if(texto.equals(inicio)) {
		        		 validacion=true;  
		        	   }
	        	   //Leer la siguiente línea
	        	   texto = br.readLine(); 
	           }
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
	   }
  public SimpleAttributeSet color(String color) {
	
				switch(color){
				case "Amarillo":				
					//color amarillo
					SimpleAttributeSet amarillo = new SimpleAttributeSet();	
					StyleConstants.setForeground(amarillo, Color.YELLOW);
					StyleConstants.setBold(amarillo, true);
					color_de_regreso=amarillo;
			//StyleConstants.setBackground(keyWord,  java.awt.Color.YELLOW);
					break;
				case "Azul":
					//color azul
					SimpleAttributeSet azul = new SimpleAttributeSet();	
					StyleConstants.setForeground(azul, Color.BLUE);
					StyleConstants.setBold(azul, true);
					color_de_regreso=azul;

					break;
				case "Verde":
					//color verde
					SimpleAttributeSet verde = new SimpleAttributeSet();	
					StyleConstants.setForeground(verde, Color.GREEN);
					StyleConstants.setBold(verde, true);
					color_de_regreso=verde;

					break;
				case "Blanco":
					//color blanco
					SimpleAttributeSet blanco = new SimpleAttributeSet();	
					StyleConstants.setForeground(blanco, Color.WHITE);
					StyleConstants.setBold(blanco, true);
					color_de_regreso=blanco;

					break;
				case "Celeste":				
					//color amarillo
					SimpleAttributeSet CYAN = new SimpleAttributeSet();	
					StyleConstants.setForeground(CYAN, Color.CYAN);
					StyleConstants.setBold(CYAN, true);
					color_de_regreso=CYAN;

					break;
				
					case "Rosado":
						//color rojo
						SimpleAttributeSet rosado = new SimpleAttributeSet();	
						StyleConstants.setForeground(rosado, Color.PINK);
						StyleConstants.setBold(rosado, true);
						color_de_regreso=rosado;
						break;
					case "Rojo":
						//color rojo
						SimpleAttributeSet rojo = new SimpleAttributeSet();	
						StyleConstants.setForeground(rojo, Color.RED);
						StyleConstants.setBold(rojo, true);
						color_de_regreso=rojo;

						break;
					case "Morado":
						//color rojo
						SimpleAttributeSet morado = new SimpleAttributeSet();	
						StyleConstants.setForeground(morado, Color.MAGENTA);
						StyleConstants.setBold(morado, true);
						color_de_regreso=morado;

						break;
					case "Anaranjado":
						//color rojo
						SimpleAttributeSet anaranjado = new SimpleAttributeSet();	
						StyleConstants.setForeground(anaranjado, Color.ORANGE);
						StyleConstants.setBold(anaranjado, true);
						color_de_regreso=anaranjado;

						break;
					case "Negro":
						//color rojo
						SimpleAttributeSet Negro = new SimpleAttributeSet();	
						StyleConstants.setForeground(Negro, Color.BLACK);
						StyleConstants.setBold(Negro, true);
						color_de_regreso=Negro;

						break;
					case "Gris Oscuro":
						//color rojo
						SimpleAttributeSet grisObscuro = new SimpleAttributeSet();	
						StyleConstants.setForeground(grisObscuro, Color.DARK_GRAY);
						StyleConstants.setBold(grisObscuro, true);
						color_de_regreso=grisObscuro;

						break;
				}
				return color_de_regreso;
				}
}
