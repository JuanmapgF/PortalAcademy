package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class InicioSesion extends JFrame {

	private Inicio contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
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
	public InicioSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1080, 650);
		contentPane = new Inicio();
		setContentPane(contentPane);
		
		this.setLocationRelativeTo(null);
	}
	
	public void controlador(ActionListener ctr) {
		contentPane.controlador(ctr);
	}
	
	public String getUser() {
		return contentPane.getUser();
	}
	
	public String getPass() {
		return contentPane.getPass();
	}

}
