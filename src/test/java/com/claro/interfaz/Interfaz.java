package com.claro.interfaz;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;

import com.claro.funciones.FuncionesPrincipales;
import com.claro.resource.crm.FuncionesProperties;

import java.awt.SystemColor;
import javax.swing.JSpinner;
import java.awt.List;

public class Interfaz extends JFrame {
	FuncionesProperties properties=new FuncionesProperties();
	private JPanel contentPane;
	PruebasTestsSuitPanamaFuncionLog n = new PruebasTestsSuitPanamaFuncionLog();
	FuncionesPrincipales fp=new FuncionesPrincipales();
	jtextpane r=new jtextpane();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);		
					frame.setLocationRelativeTo(null);

					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interfaz() {
		//setAlwaysOnTop(true);
        UIManager.put("TabbedPane.selected", Color.WHITE);

		setResizable(false);
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setTitle("AUTOMATED TEST");
		setIconImage(Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/images/icono.jpeg")));
		//setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\leo\\Downloads\\test (1).png"));
		ImageIcon panama = new ImageIcon(this.getClass().getResource("/images/panama.jpg"));
		ImageIcon costarica = new ImageIcon(this.getClass().getResource("/images/costaRica.jpg"));
		ImageIcon clienteNuevo = new ImageIcon(this.getClass().getResource("/images/cliente nuevo.png"));
		ImageIcon clienteExistente = new ImageIcon(this.getClass().getResource("/images/clienteExistente.png"));
		ImageIcon ventaNueva = new ImageIcon(this.getClass().getResource("/images/venta nueva.png"));
		ImageIcon postVenta = new ImageIcon(this.getClass().getResource("/images/PostVenta.png"));
		ImageIcon masivo = new ImageIcon(this.getClass().getResource("/images/masivo.png"));
		ImageIcon corporativo = new ImageIcon(this.getClass().getResource("/images/empresa.png"));
		ImageIcon equipo = new ImageIcon(this.getClass().getResource("/images/dispositivo.png"));
		ImageIcon log= new ImageIcon(this.getClass().getResource("/images/log.png"));
		ImageIcon renovar= new ImageIcon(this.getClass().getResource("/images/renovar.png"));
		ImageIcon movil= new ImageIcon(this.getClass().getResource("/images/phone.png"));
		ImageIcon dth= new ImageIcon(this.getClass().getResource("/images/DTH.png"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 13));
		tabbedPane.setBounds(0, 0, 779, 440);
		contentPane.add(tabbedPane);

		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		tabbedPane.addTab("Costa Rica 9.1", costarica, tabbedPane_2, null);
		
		JPanel panel = new JPanel();
		tabbedPane_2.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fp.recursos("Inicio 6", "Fin 6", properties.leerProperties("CostaRicaData", 7), "VentaMovilClienteExistenteEquipoCFCostaRica",2);
				r.setVisible(true);
			}
		});
		btnNewButton.setBounds(315, 85, 89, 23);
		panel.add(btnNewButton);


		JPanel middlePanel = new JPanel();
		tabbedPane.addTab("Log", log, middlePanel, null);
		middlePanel.setLayout(null);

		// create the middle panel components
		JTextArea display = new JTextArea(10, 10);
		display.setWrapStyleWord(true);
		display.setLineWrap(true);
		JScrollPane scroll = new JScrollPane(display);
		scroll.setBounds(20, 20, 720, 400);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// Add Textarea in to middle panel
		middlePanel.add(scroll);
		JButton btnNewButton_1 = new JButton("Ver Log");
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				display.setText("");
				fp.log(display);
			}
		});

		//poner color a las pesta�as
		
		
		btnNewButton_1.setBounds(20, 0, 89, 23);
		middlePanel.add(btnNewButton_1);

	}
}
