package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.CtrAdminActividades;
import Controlador.CtrAdminInicio;
import Controlador.CtrInicio;

public class MainPrueba extends JFrame {

	private static JPanel contentPane;
	private static MainPrueba frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainPrueba();
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
	public MainPrueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1080, 650);
		// Crea el controlador aqui:
		
		CtrAdminInicio ctr = new CtrAdminInicio(new AdminInicio());
		//Dale el valor al contentPane del panel
		contentPane = ctr.getpanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
	}

	public static void setPanel(JPanel pane) {
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		frame.getContentPane().add(pane);
		frame.getContentPane().revalidate();
	}
}
