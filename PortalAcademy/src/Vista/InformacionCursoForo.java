package Vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

import Controlador.CtrMenu;
import Modelo.Curso;
import Modelo.Estudiante;
import Modelo.Mensaje;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;

@SuppressWarnings("serial")
public class InformacionCursoForo extends JPanel {
	private JButton enviar;
	private JButton refrescar;

	private JTextField textField;
	
	private List<Mensaje> lista;
	private JTable tablaMensajes;
	private MensajeRenderer mensajeRenderer = new MensajeRenderer();
	private ButtonChatEditor chatEditor = new ButtonChatEditor(this, new JTextField());
	private Usuario user;
	private Curso curso;

	/**
	 * Create the panel.
	 */
	public InformacionCursoForo(Usuario user, Curso curso) {

		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		lista = curso.getMensajes();
		this.user = user;
		this.curso = curso;
		
		getMensajes();

		JScrollPane foro = new JScrollPane();
		foro.setBounds(602, 454, 459, 268);
		foro.setViewportView(tablaMensajes);
		tablaMensajes.setRowHeight(50);
		foro.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		add(foro);

		textField = new JTextField();
		textField.setBounds(602, 733, 459, 20);
		add(textField);
		textField.setColumns(10);

		enviar = new JButton(new ImageIcon(getClass().getResource("/img/enviar.png")));
		enviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		enviar.setContentAreaFilled(false);
		enviar.setFocusPainted(false);
		enviar.setBorderPainted(false);
		enviar.setBounds(1071, 714, 73, 59);
		add(enviar);

		refrescar = new JButton(new ImageIcon(getClass().getResource("/img/refrescar.png")));
		refrescar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		refrescar.setContentAreaFilled(false);
		refrescar.setFocusPainted(false);
		refrescar.setBorderPainted(false);
		refrescar.setBounds(1071, 454, 57, 59);
		add(refrescar);

		if (user == null) {
			CtrMenu menu = new CtrMenu(new Menu(curso));
			add(menu.getPanel());
		} else if (user instanceof Profesor) {
			CtrMenu menu = new CtrMenu(new Menu((Profesor) user, curso));
			add(menu.getPanel());
		} else if (user instanceof Organizacion) {
			CtrMenu menu = new CtrMenu(new Menu((Organizacion) user));
			add(menu.getPanel());
		} else {
			CtrMenu menu = new CtrMenu(new Menu((Estudiante) user, curso));
			add(menu.getPanel());
		}

	}

	public void controlador(ActionListener ctr) {
		if (enviar != null) {
			enviar.addActionListener(ctr);
			enviar.setActionCommand("Enviar");
		}

		if (refrescar != null) {
			refrescar.addActionListener(ctr);
			refrescar.setActionCommand("Refrescar");
		}
	}

	public String mensajeAEnviar() {
		return textField.getText();
	}
	
	public void getMensajes() {
		String[] columnHeaders = {"Otros", "Emisor"};
		Object[][] datos = new Object[lista.size()][2];
		
		int k = 0;
		for (Mensaje m : lista) {
			if (m.getEmisor() == null) {
				datos[k][0] = "<AN�NIMO> : " + m.getTexto();
			} else if (m.getEmisor().equals(user)) {
				datos[k][1] = m.getTexto();
			} else if (m.getEmisor().equals(curso.getProfesor())) {
				datos[k][0] = "<PROFESOR> : " + m.getTexto();
			} else {
				datos[k][0] = "<" + m.getEmisor().toString().toUpperCase() + "> : " + m.getTexto();
			}
			
			k++;
		}
		
		tablaMensajes = new JTable(datos, columnHeaders);
		Border border = mensajeRenderer.getBorder();
		Border margin = new EmptyBorder(5,5,5,5);
		mensajeRenderer.setBorder(new CompoundBorder(border, margin));
		tablaMensajes.getColumnModel().getColumn(0).setCellRenderer(mensajeRenderer);
		tablaMensajes.getColumnModel().getColumn(1).setCellRenderer(mensajeRenderer);
		tablaMensajes.setTableHeader(null);
		tablaMensajes.setCellSelectionEnabled(false);
		tablaMensajes.setGridColor(Color.decode("#F0F0F0"));
	}

}
