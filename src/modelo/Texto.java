package modelo;

import javax.swing.JOptionPane;

public class Texto {

	private String texto; 
	
	public Texto(String texto) {
		this.texto = texto;
	}
	
	public String getTexto() {
		return this.texto;
	}
	
	public void buscarPalabra(String palabra) {
		
		int numero = 0;
		
		for(int i=palabra.length()-1; i<texto.length(); i++) {
			int k = i;
			int coinsd = 0;
			for(int j=palabra.length(); j>0; j--) {
				if(palabra.charAt(j-1)==texto.charAt(k)) {
					coinsd++;
				}else {
					break;
				}
				k--;
			}
			if(coinsd==palabra.length()) {
				texto = texto.substring(0, (i)-(palabra.length()-1)) + "_" + texto.substring(i-(palabra.length()-1), i+1) + "_" + texto.substring(i+1, (texto.length()-1));
				i = i + 2;
				numero++;
			}
		}
		
		JOptionPane.showMessageDialog(null, "Palabras encontradas " + numero);
		
	}
	
	public void buscarPalindromos() {
		
		int numero = 0;
		
		texto = texto.replaceAll("\n"," _- ");
		
		int h = 0;
		for(int i=0; i<texto.length(); i++) {
			int k = i-1;
			if((texto.charAt(i)==' ') || (i==texto.length()-1)) {
				int coinsd = 0;
				for(int j=h; j<i; j++) {
					System.out.println(texto.charAt(j) + ", " + texto.charAt(k));
					if(texto.charAt(j) == texto.charAt(k)) {
						coinsd++;
					}
					k--;
				}
				System.out.println(coinsd);
				if(coinsd == (i-h) && (i-h) !=1 ) {
					texto = texto.substring(0, (h)) + "*" + texto.substring(h, (i)) + "*" + texto.substring(i, (texto.length()-1));
					i = i + 2;
					numero++;
				}
				h = i+1;
			}
		}
		
		texto = texto.replaceAll(" _- ","\n");
		
		JOptionPane.showMessageDialog(null, "Palabras encontradas " + numero);
		
	}
	
}
