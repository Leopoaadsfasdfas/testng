package com.claro.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import com.claro.resource.crm.FuncionesProperties;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class config extends JFrame {

	private JPanel contentPane;
	private JComboBox texto1;
	Label coment,prueba,text2,igu,cooment,prueba2,prueba1,iguual;
	private Label prueba11;
	JComboBox fontt;
	private Label label;
	 FuncionesProperties fp= new FuncionesProperties();
	 private Label fondo;
		Color color_de_regreso;
boolean a=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					config frame = new config();
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
	public config() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 162);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		panel.setBackground(Color.DARK_GRAY);
		
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JComboBox igual = new JComboBox();
		igual.setBackground(Color.WHITE);
		igual.setModel(new DefaultComboBoxModel(new String[] {"", "Amarillo", "Azul", "Verde", "Blanco", "Celeste", "Rosado", "Rojo", "Morado", "Anaranjado", "Gris Oscuro", "Negro"}));
		igual.setBounds(202, 47, 82, 20);
		panel.add(igual);
		
	 igu = new Label("=");
	 igu.setForeground(Color.WHITE);
		igu.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		igu.setBounds(223, 21, 22, 20);
		panel.add(igu);
		
		 text2 = new Label("Valor");
		 text2.setForeground(Color.WHITE);
		text2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		text2.setBounds(302, 21, 82, 20);
		panel.add(text2);
		
		coment = new Label("#");
		coment.setForeground(Color.WHITE);
		coment.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		coment.setBounds(10, 21, 82, 20);
		panel.add(coment);
  
	
		 prueba1 = new Label("Prueba ");
		prueba1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		prueba1.setBounds(20, 113, 46, 20);
		panel.add(prueba1);
		
		JComboBox comentario = new JComboBox();
		comentario.setModel(new DefaultComboBoxModel(new String[] {"", "Amarillo", "Azul", "Verde", "Blanco", "Celeste", "Rosado", "Rojo", "Morado", "Anaranjado", "Gris Oscuro", "Negro"}));
		comentario.setBackground(Color.WHITE);
		comentario.setBounds(10, 47, 82, 20);
		panel.add(comentario);
		
		texto1 = new JComboBox();
		texto1.setModel(new DefaultComboBoxModel(new String[] {"", "Amarillo", "Azul", "Verde", "Blanco", "Celeste", "Rosado", "Rojo", "Morado", "Anaranjado", "Gris Oscuro", "Negro"}));
		texto1.setBackground(Color.WHITE);
		texto1.setBounds(108, 47, 82, 20);
		panel.add(texto1);
		
		JComboBox texto2 = new JComboBox();
		texto2.setModel(new DefaultComboBoxModel(new String[] {"", "Amarillo", "Azul", "Verde", "Blanco", "Celeste", "Rosado", "Rojo", "Morado", "Anaranjado", "Gris Oscuro", "Negro"}));
		texto2.setBackground(Color.WHITE);
		texto2.setBounds(294, 47, 82, 20);
		panel.add(texto2);
		
		Button button = new Button("Salir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		setVisible(false);
			}
		});
		setUndecorated(true);
		
		fontt = new JComboBox();
		fontt.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(a==false) {
					JOptionPane.showMessageDialog(null,"Recuerde que al cambiar el fondo los cambios se le "
							+ "reflejará en la siguente ejecución");
					a=true;
				}
			}
		});
		fontt.setModel(new DefaultComboBoxModel(new String[] {"", "Amarillo", "Azul", "Verde", "Blanco", "Celeste", "Rosado", "Rojo", "Morado", "Anaranjado", "Gris Oscuro", "Negro"}));
	
		fontt.setBackground(Color.WHITE);
		fontt.setBounds(414, 58, 82, 20);
		panel.add(fontt);
		button.setBackground(Color.WHITE);
		button.setBounds(430, 8, 66, 21);
		panel.add(button);
		
		Button button_1 = new Button("Aplicar cambios");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            String come,text1,text2,igu,fondoo;
	    	come=funcionColorTexto(comentario.getSelectedItem().toString(),cooment,"comentario");
			text1=funcionColorTexto(texto1.getSelectedItem().toString(),prueba1,"llave");
			igu=funcionColorTexto(igual.getSelectedItem().toString(),iguual,"igual");
			text2=funcionColorTexto(texto2.getSelectedItem().toString(),prueba11,"valor");			
			fondoo=funcionColorTexto(fontt.getSelectedItem().toString(),fondo,"font");
	        fp.escribirProperties(come, text1, igu, text2,fondoo);

			}
		});
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(333, 113, 132, 20);
		panel.add(button_1);
		
	 cooment = new Label("#Esto es un comentario");
		cooment.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		cooment.setBounds(10, 93, 167, 20);
		panel.add(cooment);
		
		 prueba = new Label("Llave");
		 prueba.setForeground(Color.WHITE);
		 prueba.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		 prueba.setBounds(106, 21, 55, 20);
		panel.add(prueba);
		
		iguual = new Label("=");
		iguual.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 14));
		iguual.setBounds(61, 113, 14, 20);
		panel.add(iguual);
		
	prueba11 = new Label(" prueba");
		prueba11.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		prueba11.setBounds(72, 113, 55, 20);
		panel.add(prueba11);
		
		label = new Label("Resultado.");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		label.setBounds(10, 73, 65, 20);
		panel.add(label);
		
		Label label_1 = new Label("Modificaci\u00F3n de Colores");
		label_1.setForeground(Color.CYAN);
		label_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		label_1.setBounds(0, 0, 161, 20);
		panel.add(label_1);
		
		fondo = new Label("Fondo");
		fondo.setForeground(Color.WHITE);
		fondo.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		fondo.setBounds(430, 35, 59, 20);
		panel.add(fondo);
		setLocationRelativeTo(null);
		   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		   setDefaultCloseOperation(0);
	}
	public String funcionColorTexto(String a,Label b,String tipo_de_valor) {
		

		switch(a){
		case "Amarillo":
		   b.setForeground(Color.YELLOW);
			break;
		case "Azul":
		   b.setForeground(Color.BLUE);
			break;
		case "Verde":
		   b.setForeground(Color.GREEN);
			break;
		case "Blanco":
		  b.setForeground(Color.WHITE);
			break;
		case "Celeste":
		  b.setForeground(Color.CYAN);
			break;
		
			case "Rosado":
			    b.setForeground(Color.PINK);
				break;
			case "Rojo":
			    b.setForeground(Color.RED);
				break;
			case "Morado":
			    b.setForeground(Color.MAGENTA);
				break;
			case "Anaranjado":
			    b.setForeground(Color.ORANGE);
				break;
			case "Negro":
			    b.setForeground(Color.black);
				break;
			case "Gris Oscuro":
			    b.setForeground(Color.DARK_GRAY);
				break;
			case "":
			   
				break;
		}
		
			  if(!a.equals("")) {
					return a;
              }else {
              	return fp.leerProperties(tipo_de_valor, 13);
              }
		
	
		
	}

}
