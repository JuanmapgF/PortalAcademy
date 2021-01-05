package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.CtrExplorar;
import Modelo.Actividad;
import Modelo.Curso;
import Modelo.Usuario;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private static JPanel contentPane;
	private static Main frame;
	private static Usuario user;
	private static JLabel userName;

	public Main() {
		userName = new JLabel();
		userName.setBounds(10, 11, 240, 20);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1080, 650);
		CtrExplorar c = null;
		c = new CtrExplorar(new Explorar(Curso.getTodosLosCursos(), Actividad.getTodasLasActividades()));
		contentPane = c.getPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void setPanel(JPanel pane) {
		frame.getContentPane().removeAll();
		frame.getContentPane().invalidate();
		frame.getContentPane().add(pane);
		frame.getContentPane().revalidate();
	}

	public static void setUser(Usuario u) {
		user = u;
		setLabel();
	}

	public static Usuario getUser() {
		return user;
	}

	public static void setLabel() {
		userName.setText(user.getNick());
	}

	public static JLabel getLabel() {
		return userName;
	}

}
