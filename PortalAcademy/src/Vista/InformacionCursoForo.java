package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.TableCellEditor;

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
	private ButtonChatEditor chatEditor = new ButtonChatEditor(new JTextField());
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
		foro.setBounds(602, 454, 659, 268);
		foro.setViewportView(tablaMensajes);
		tablaMensajes.setRowHeight(50);
		foro.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		add(foro);

		textField = new JTextField();
		textField.setBounds(602, 733, 659, 20);
		add(textField);
		textField.setColumns(10);

		enviar = new JButton(new ImageIcon(getClass().getResource("/img/enviar.png")));
		enviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		enviar.setContentAreaFilled(false);
		enviar.setFocusPainted(false);
		enviar.setBorderPainted(false);
		enviar.setBounds(1271, 714, 73, 59);
		add(enviar);

		refrescar = new JButton(new ImageIcon(getClass().getResource("/img/refrescar.png")));
		refrescar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		refrescar.setContentAreaFilled(false);
		refrescar.setFocusPainted(false);
		refrescar.setBorderPainted(false);
		refrescar.setBounds(1271, 454, 57, 59);
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
				datos[k][0] = "[ANONIMO] : " + m.getTexto();
				datos[k][1] = "";
			} else if (m.getEmisor().equals(user)) {
				datos[k][0] = "";
				datos[k][1] = m.getTexto();				
			} else if (m.getEmisor().equals(curso.getProfesor())) {
				datos[k][0] = "[PROFESOR] : " + m.getTexto();
				datos[k][1] = "";
			} else {
				datos[k][0] = "[" + m.getEmisor().toString().toUpperCase() + "] : " + m.getTexto();
				datos[k][1] = "";
			}
			
			k++;
		}
		
		for (int i = 0; i < datos.length; i++) {
			for (int j = 0; j < datos[0].length; j++) {
				System.out.println(datos[i][j]);
			}
		}
		
		tablaMensajes = new JTable(datos, columnHeaders);
		Border border = mensajeRenderer.getBorder();
		Border margin = new EmptyBorder(5,5,5,5);
		mensajeRenderer.setBorder(new CompoundBorder(border, margin));
		tablaMensajes.getColumnModel().getColumn(0).setCellRenderer(mensajeRenderer);
		tablaMensajes.getColumnModel().getColumn(1).setCellRenderer(mensajeRenderer);
		tablaMensajes.setTableHeader(null);
		tablaMensajes.getColumnModel().getColumn(0).setCellEditor(new EditorMensajes());
		tablaMensajes.getColumnModel().getColumn(1).setCellEditor(new EditorMensajes());
		tablaMensajes.setCellSelectionEnabled(false);
		tablaMensajes.setGridColor(Color.decode("#F0F0F0"));
	}
	
	private class EditorMensajes implements TableCellEditor {

		@Override
		public Object getCellEditorValue() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean isCellEditable(EventObject anEvent) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean shouldSelectCell(EventObject anEvent) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean stopCellEditing() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void cancelCellEditing() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addCellEditorListener(CellEditorListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeCellEditorListener(CellEditorListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
