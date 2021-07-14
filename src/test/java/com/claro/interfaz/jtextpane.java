package com.claro.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.claro.funciones.EscribirArchivo;
import com.claro.funciones.FuncionesPrincipales;
import com.claro.resource.crm.FuncionesProperties;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import javax.swing.JTextField;
import javax.swing.JProgressBar;


public class jtextpane extends JFrame {
	Thread thread;
	Color color_de_regreso;
String texto="";
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jtextpane frame = new jtextpane();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public jtextpane() {
		FuncionesProperties properties = new FuncionesProperties();
		PruebasTestsSuitPanamaFuncionLog correr = new PruebasTestsSuitPanamaFuncionLog();

		 EscribirArchivo ar=new EscribirArchivo();
		    FuncionesPrincipales f=new FuncionesPrincipales();
		    CambioExtencionElimCopDeArchivo r=new CambioExtencionElimCopDeArchivo();
			 leerArchivo n=new leerArchivo();

		ImageIcon hoja= new ImageIcon(this.getClass().getResource("/images/hoja.png"));
		ImageIcon atras= new ImageIcon(this.getClass().getResource("/images/atras.jpg"));
		ImageIcon adelante= new ImageIcon(this.getClass().getResource("/images/adelante.jpg"));
		ImageIcon ajustes= new ImageIcon(this.getClass().getResource("/images/ajuste.png"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTextPane recursos = new JTextPane();
		contentPane.add(recursos, BorderLayout.CENTER);
		recursos.setCaretColor(Color.red);
		JPanel panel = new JPanel();
		
		panel.setForeground(color(f.leerProperties("font", 13)));
		
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		recursos.setBackground(color(f.leerProperties("font", 13)));
		
		recursos.setFont(new Font("Consolas", Font.PLAIN, 16));
		recursos.setForeground(Color.GREEN);
		
		 JScrollPane scroll = new JScrollPane(recursos);
			scroll.setBounds(20, 20, 720, 400);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			// Add Textarea in to middle panel
			panel.add(scroll);
			
			textField = new JTextField();
			textField.setFont(new Font("Consolas", Font.PLAIN, 14));
			textField.setBackground(Color.BLACK);
			textField.setForeground(Color.GREEN);
			scroll.setColumnHeaderView(textField);
			textField.setColumns(10);
		     JPanel panel_1 = new JPanel();
		     panel_1.setBackground(Color.WHITE);
		     contentPane.add(panel_1, BorderLayout.SOUTH);
		     
		     JButton btnRegresar = new JButton("Regresar atras");
		     btnRegresar.setIcon(atras);
				btnRegresar.setBackground(new Color(255, 255, 255));
				
		     btnRegresar.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     	   if(recursos.getText().equals("")) {
					      setVisible(false);
	  
				   }else {
					      setVisible(false);

					   switch(f.getPais()) {
						case 1:
							 ar.escribirr(recursos,f.getDato().substring(0,37));
						      r.renombrararchivo(f.getDato().substring(0,38),"txt","properties");
						      setVisible(false);
						      recursos.setText("");
							break;
						case 2:
							 ar.escribirr(recursos,f.getDato().substring(0,40));
						      r.renombrararchivo(f.getDato().substring(0,41),"txt","properties");
						      setVisible(false);
						      recursos.setText("");
							break;
						case 3:
							 ar.escribirr(recursos,f.getDato().substring(0,43));
						      r.renombrararchivo(f.getDato().substring(0,44 ),"txt","properties");
						      setVisible(false);
						      recursos.setText("");
							break;
	     }
	recursos.setText("");
				   }
				
		     	}
		     });
				
				JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("");
				panel_1.add(lblNewJgoodiesLabel);
				
				JButton btnNewButton = new JButton("");
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
				btnNewButton.setIcon(ajustes);
				btnNewButton.setOpaque(true);
				btnNewButton.setBorder(null);

				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						config config=new config();
						config.setVisible(true);
					}
				});
				
				JProgressBar progres = new JProgressBar();
				panel_1.add(progres);

				btnNewButton.setBackground(Color.WHITE);
				panel_1.add(btnNewButton);
				
				JLabel label_1 = DefaultComponentFactory.getInstance().createLabel("          ");
				panel_1.add(label_1);
				btnRegresar.setBorder(new com.claro.interfaz.RoundedBorder(2));

		     panel_1.add(btnRegresar);
		     
		     JButton btnVerRecursos = new JButton("Ver Recursos");
		 	btnVerRecursos.setBackground(new Color(255, 255, 255));
			btnVerRecursos.setIcon(hoja);
			
		     btnVerRecursos.addActionListener(new ActionListener() {
		     		@Test
		     	 public void actionPerformed(ActionEvent e) {
		     			
			        	  correr.testng1(properties.leerProperties(f.getNombreTest(),6));

		     		}
		     });
				
				JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("                                  ");
				panel_1.add(lblNewJgoodiesTitle);
				btnVerRecursos.setBorder(new com.claro.interfaz.RoundedBorder(2));

		     panel_1.add(btnVerRecursos);
		     
		     JButton btnSeguirConLa = new JButton("Seguir con la prueba");
		 	btnSeguirConLa.setIcon(adelante);
			btnSeguirConLa.setBackground(new Color(255, 255, 255));
		     btnSeguirConLa.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		  int i=JOptionPane.showConfirmDialog(null,"�Estas seguro que quieres continuar?","Confirmaci�n",JOptionPane.YES_NO_OPTION);			     
				      if(i==0&&!recursos.getText().equals("")){
					      
					      switch(f.getPais()) {
							case 1:
							
								if(f.getNombreTest().equals("cambio")) {
							    	  JOptionPane.showMessageDialog(null,"Esto solo es un cambio de usuario! Presione el  boton regresar para almacenar los\n"
							    	  		+ "                               nuevos cambios que has realizado","Confirmaci�n",JOptionPane.ERROR_MESSAGE);
					
								}else {
							      thread = new Thread() {
							          public void run() {

							        	  ar.escribirr(recursos,f.getDato().substring(0,37));
									      r.renombrararchivo(f.getDato().substring(0,38),"txt","properties");
									      recursos.setText("");
									      setVisible(false);

							        	  correr.testng1(properties.leerProperties(f.getNombreTest(),6));

							          }
							      };
							      thread.start();
								}
								break;
							case 2:
								thread = new Thread() {
							          public void run() {
								 ar.escribirr(recursos,f.getDato().substring(0,40));
							      r.renombrararchivo(f.getDato().substring(0,41),"txt","properties");
							      recursos.setText("");
							      setVisible(false);
							      correr.testng1(properties.leerProperties(f.getNombreTest(),7));
							          }
							      };
							      thread.start();
								break;
							case 3:
								thread = new Thread() {
							          public void run() {
							 ar.escribirr(recursos,f.getDato().substring(0,43));
							      r.renombrararchivo(f.getDato().substring(0,44),"txt","properties");
							      recursos.setText("");
							      setVisible(false);

							      correr.testng1(properties.leerProperties(f.getNombreTest(),7));
							          }
							      };
							      thread.start();
								break;
							case 4:
								 

							thread = new Thread() {
							          public void run() {
							     f.setTextPane(recursos);
							      f.setDato(recursos.getText());
							      recursos.setText("");
							      setVisible(false);

							      correr.testng1(properties.leerProperties(FuncionesPrincipales.getNombreTest(),6));
							    
							          }
							      };
							    
							      thread.start();
								break;
							}
					      
					      }else {
					    	  JOptionPane.showMessageDialog(null,"No se puede seguir la prueba por falta de datos.","Confirmaci�n",JOptionPane.ERROR_MESSAGE);
					      }
		     	}
		     });
				
				JLabel label = DefaultComponentFactory.getInstance().createLabel("                                  ");
				panel_1.add(label);
				btnSeguirConLa.setBorder(new com.claro.interfaz.RoundedBorder(2));

		     panel_1.add(btnSeguirConLa);
		     
		     JLabel lblUrl = new JLabel("URL ");
		     contentPane.add(lblUrl, BorderLayout.NORTH);
		     
			setLocationRelativeTo(null);
			   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			   setDefaultCloseOperation(0);
	}

    private void appendToPane(JTextPane tp, String msg, Color c) 
    { 
     StyleContext sc = StyleContext.getDefaultStyleContext(); 
     AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c); 

     aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console"); 
     aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED); 

     int len = tp.getDocument().getLength(); 
     tp.setCaretPosition(len); 
     tp.setCharacterAttributes(aset, false); 
     tp.replaceSelection(msg); 
    } 
	//color del background
	  public Color color(String color) {
			
			switch(color){
			case "Amarillo":				
				//color amarillo
				color_de_regreso=Color.YELLOW;

		//StyleConstants.setBackground(keyWord,  java.awt.Color.YELLOW);
				break;
			case "Azul":
				//color azul
				color_de_regreso=Color.BLUE;


				break;
			case "Verde":
				//color verde
				color_de_regreso=Color.GREEN;


				break;
			case "Blanco":
				//color blanco
				color_de_regreso=Color.WHITE;


				break;
			case "Celeste":				
				//color amarillo
				color_de_regreso=Color.CYAN;
				break;
			
				case "Rosado":
					//color rojo
					color_de_regreso=Color.PINK;

					break;
				case "Rojo":
					//color rojo
				
					color_de_regreso=Color.RED;

					break;
				case "Morado":
				
					color_de_regreso=Color.MAGENTA;

					break;
				case "Anaranjado":
					color_de_regreso=Color.ORANGE;

					break;
				case "Negro":
					color_de_regreso=Color.BLACK;

					break;
				case "Gris Oscuro":
					color_de_regreso=Color.DARK_GRAY;

					break;
			}
			return color_de_regreso;
			}
}
