package Vista;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Explorar extends JPanel {
	
	private String titulo;
	private JButton cerrarSesion = new JButton("Cerrar sesión");
	
	
	public Explorar() {
		
	}
	
	public void setSize(int width, int height) {
		this.setBounds(0, 0, width, height);
	}

}
