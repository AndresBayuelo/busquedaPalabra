package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import modelo.Texto;
import vista.*;

public class Controlador implements ActionListener{
	
	private Interfaz interfaz;

	public Controlador() {
		
		interfaz = new Interfaz(this);
		interfaz.cargarListeners();
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		JButton boton;
        boton = (JButton)e.getSource();
        
        if(boton == interfaz.getArchivo()) {
        	
        	JFileChooser jF = new JFileChooser();
        	jF.setFileSelectionMode(JFileChooser.FILES_ONLY);
        	jF.showOpenDialog(interfaz);
        	File archivo = jF.getSelectedFile();
        	if ((archivo == null) || (archivo.getName().equals(""))) {
        		JOptionPane.showMessageDialog(interfaz, "Nombre de archivo inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE);
        	}else {
        		//interfaz.getPantalla().setText(archivo.getAbsolutePath());
				try {
					Scanner scn = new Scanner(archivo);
					while (scn.hasNext()) {
	        			interfaz.getPantalla().insert(scn.nextLine() + "\n", interfaz.getPantalla().getText().length());
	        		}
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
        	}
        	
        }
        
        if(boton == interfaz.getBuscar()) {
        	
        	Texto text = new Texto(interfaz.getPantalla().getText());
        	text.buscarPalabra(interfaz.getIngresar().getText());
        	interfaz.getPantalla().setText(text.getTexto());
        	
        }
        
        if(boton == interfaz.getPalindromo()) {
        	
        	Texto text = new Texto(interfaz.getPantalla().getText());
        	text.buscarPalindromos();
        	interfaz.getPantalla().setText(text.getTexto());
        	
        }
		
	}
	
}
