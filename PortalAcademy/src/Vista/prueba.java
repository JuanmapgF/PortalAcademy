package Vista;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.CtrButtonDynamic;

public class prueba extends JFrame {

	private JPanel contentPane;
	private JButtonDynamic cerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prueba frame = new prueba();
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
	public prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cerrar = new JButtonDynamic("Cerrar Sesion", JButtonDynamic.CERRAR_SESION);
		CtrButtonDynamic cbd = new CtrButtonDynamic(cerrar);
		cerrar.setBounds(156, 98, 114, 52);
		getContentPane().add(cbd.getBoton());
	}

}
