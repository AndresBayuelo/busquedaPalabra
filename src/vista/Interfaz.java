package vista;

import javax.swing.*;

import controlador.Controlador;

import java.awt.*;
	
public class Interfaz extends JFrame{
	
	Controlador controlador;
	
	JButton buscar;
	JButton archivo;
	JButton palindromo;
	JTextArea pantalla;
	JTextField ingresar;
	JLabel numero;
	
	
	public Interfaz(Controlador controlador){
		
		this.controlador = controlador;
		
		JFrame ventana = new JFrame("Busqueda en texto");
		ventana.setSize(350, 370);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		ventana.add(panel);
		placeComponents(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		
		ventana.setVisible(true);
	
	}

	private void placeComponents(JPanel panel) {
		
		panel.setLayout(null);
		
		ImageIcon fondo = new ImageIcon("fondo.jpg");
		JLabel Fondo = new JLabel(fondo);
		Fondo.setBounds(0,0,350,370);
		panel.add(Fondo);
			
		buscar = new JButton("Buscar");
		buscar.setBounds(165, 280, 120, 30);
		Fondo.add(buscar);
		
		archivo = new JButton("Archivo");
		archivo.setBounds(20, 230, 120, 30);
		Fondo.add(archivo);
		
		palindromo = new JButton("Palindromo");
		palindromo.setBounds(20, 280, 120, 30);
		Fondo.add(palindromo);
		
		pantalla =new JTextArea();
		JScrollPane scrollPane = new JScrollPane(pantalla);
		scrollPane.setBounds(30, 50, 270, 150);
		Fondo.add(scrollPane);
		
		ingresar = new JTextField();
		ingresar.setBounds(150, 230, 150, 30);
		ingresar.setEditable(true);
		Fondo.add(ingresar);
		
		numero = new JLabel("Palabra:");
		numero.setForeground(Color.white);
		numero.setBounds(30, 230, 120, 30);
		Fondo.add(numero);
		
	}
	
	public void cargarListeners() {
		
		buscar.addActionListener(this.controlador);
		archivo.addActionListener(this.controlador);
		palindromo.addActionListener(this.controlador);
		
	}

	public Controlador getControlador() {
		return controlador;
	}

	public JButton getBuscar() {
		return buscar;
	}

	public JButton getArchivo() {
		return archivo;
	}

	public JButton getPalindromo() {
		return palindromo;
	}

	public JTextArea getPantalla() {
		return pantalla;
	}

	public JTextField getIngresar() {
		return ingresar;
	}

	public JLabel getNumero() {
		return numero;
	}
	
}	