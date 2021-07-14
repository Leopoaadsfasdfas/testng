package testPost;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.claro.funciones.FuncionesPrincipales;
import com.claro.interfaz.CambioExtencionElimCopDeArchivo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post extends FuncionesPrincipales{
	CambioExtencionElimCopDeArchivo cambioExtencion= new CambioExtencionElimCopDeArchivo();
	String a;
	 Date ahora = new Date();
    SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
	int hora, minutos, segundos;
	Calendar calendario = Calendar.getInstance();

	int failed,passed;
	@Test(invocationCount=200)
	public void testPostUserr()  {	
		hora =calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);
		String contenido = "";

		String date=" Date "+formateador.format(ahora).toString()+" Hora "+Integer.toString(hora)+" Min "+Integer.toString(minutos)+" Seg "+Integer.toString(segundos);

		 String ruta = "./src/test/java/reportes/report"+date+".txt";
         File filee = new File(ruta);
      
	    File file = new File("./src/test/java/properties/json.json");

		//Specifify base URI
				RestAssured.baseURI=leerProperties("url", 1);
				//Request object
				RequestSpecification httpRequest=RestAssured.given();
contenido+="Iteración: "+leerProperties("iteraciones", 1)+"\n";
contenido+="URL: "+leerProperties("url", 1)+"\n\n";
			
//for(int i=0;i<Integer.parseInt(leerProperties("iteraciones", 1));i++) {
				//Request payload sending along with post request
		

				httpRequest.header("Content-Type","application/json");

				httpRequest.body(file);

				//Response object
				Response response=httpRequest.request(Method.POST);
//				System.out.println("Test No: "+(i+1)+".--------------------------------------------------------------\n");
//contenido+="Test No: "+(i+1)+".--------------------------------------------------------------\n";
				//print response in console window
			//	String responseBody=response.getBody().prettyPrint();
				contenido+=response.getBody().prettyPrint()+"\n";

			//	System.out.println("Response Body is:"+  responseBody);

				//Status code validation
		//	System.out.println("Status code is:"+response.getDetailedCookies());
				long tiempo_Respuesta=response.getTime();
				System.out.println("TPS: " + tiempo_Respuesta+" ms");
				
contenido+="TPS: " + tiempo_Respuesta+" ms \n";
				//Assert.assertEquals(response.getDetailedCookies(),200);
				
			//	setResultadoDepruebas(responseBody+"\n"+response.getStatusCode());
				//contenido+=responseBody+"\n"+response.getStatusCode();
		    //Success code validation
		//	String successCode=response.jsonPath().get("estado");
			String succedCode1=response.jsonPath().get("det_estado");
			
			if(succedCode1.equals("Operación exitosa")) {
				System.out.println("Prueba exitosa ");
				
				System.out.println("Status Code: "+response.getStatusCode()+"\n");
				contenido+="Prueba exitosa \n";
		    	 contenido+="Status Code: "+response.getStatusCode()+"\n\n\n";
			passed++;
			}else {
				failed++;
				System.out.println("Error ");
				System.out.println("Status Code: "+response.getStatusCode()+"\n");
			
				contenido+="Error\n ";
		    	 contenido+="Status Code: "+response.getStatusCode()+"\n\n\n";
			}
			System.out.println("\n");



//}



System.out.println("\n Passed: "+passed+"\n Failed: "+failed+"\n");

contenido+="\n Passed: "+passed+"\n Failed: "+failed+"\n";
//escritura y cierre del archivo
try {
	

FileWriter fw = new FileWriter(filee);
BufferedWriter bw = new BufferedWriter(fw);
bw.write(contenido);

bw.close();

		//Si el archivo no existe es creado
		if (!filee.exists()) {
		 filee.createNewFile();
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
			}
			
			  
	}

