package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.TableCellEditor;

import Controlador.CtrMenu;
import Modelo.Estudiante;
import Modelo.MensajePrivado;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;

@SuppressWarnings("serial")
public class ChatPrivado extends JPanel {
	
	private Usuario user;
	private Usuario seleccionado;
	private JTable chatsAbiertos;
	private List<Usuario> users;
	
	private JTable tablaMensajes;
	private List<MensajePrivado> mensajes;
	private JTextField textField;
	private JButton enviar;
	private JButton refrescar;
	
	private MensajeRenderer mensajeRenderer = new MensajeRenderer();
	private ButtonChatEditor chatEditor = new ButtonChatEditor(new JTextField());
	
	private JTextField textFieldNuevoChat;
	private JButton buttonAgregarChat;


	
	public ChatPrivado(Usuario user) {
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		this.user = user;
		
		getChatsAbiertos();
		
		JScrollPane sp = new JScrollPane();
		sp.setBounds(464, 239, 363, 568);
		sp.setViewportView(chatsAbiertos);
		sp.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		add(sp);
		chatsAbiertos.setRowHeight(75);
		
		
		textFieldNuevoChat = new JTextField();
		textFieldNuevoChat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldNuevoChat.setToolTipText("");
		textFieldNuevoChat.setBounds(464, 178, 277, 40);
		add(textFieldNuevoChat);
		textFieldNuevoChat.setColumns(10);
		
		buttonAgregarChat = new JButton("");
		buttonAgregarChat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonAgregarChat.setBounds(770, 167, 57, 59);
		buttonAgregarChat.setIcon(new ImageIcon(getClass().getResource("/img/agregar.png")));
		buttonAgregarChat.setContentAreaFilled(false);
		buttonAgregarChat.setFocusPainted(false);
		buttonAgregarChat.setBorderPainted(false);
		add(buttonAgregarChat);
		
		
		if (user instanceof Profesor) {
			CtrMenu menu = new CtrMenu(new Menu((Profesor) user));
			add(menu.getPanel());
		} else if (user instanceof Estudiante) {
			CtrMenu menu = new CtrMenu(new Menu((Estudiante) user));
			add(menu.getPanel());
		} else {
			CtrMenu menu = new CtrMenu(new Menu((Organizacion) user));
			add(menu.getPanel());
		}
	}
	

	
	/**
	 * @wbp.parser.constructor
	 */
	public ChatPrivado(Usuario user, Usuario seleccionado) {
		
		this.setBounds(0, 0, 1920, 1080);
		setLayout(null);
		
		this.user = user;
		
		this.seleccionado = seleccionado;
		
		getMensajes();

		JScrollPane chat = new JScrollPane();
		chat.setBounds(977, 237, 371, 570);
		chat.setViewportView(tablaMensajes);
		chat.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		chat.getVerticalScrollBar().setValue(chat.getVerticalScrollBar().getMaximum());
		add(chat);
		tablaMensajes.setRowHeight(80);
		
		getChatsAbiertos();
		
		JScrollPane sp = new JScrollPane();
		sp.setBounds(464, 239, 363, 568);
		sp.setViewportView(chatsAbiertos);
		sp.getVerticalScrollBar().setUI(new BasicScrollBarUI());
		add(sp);
		chatsAbiertos.setRowHeight(75);
		
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(977, 826, 370, 40);
		add(textField);
		textField.setColumns(20);

		enviar = new JButton("");
		enviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		enviar.setBounds(1357, 818, 73, 59);
		enviar.setIcon(new ImageIcon(getClass().getResource("/img/enviar.png")));
		enviar.setContentAreaFilled(false);
		enviar.setFocusPainted(false);
		enviar.setBorderPainted(false);
		add(enviar);
		
		refrescar = new JButton("");
		refrescar.setToolTipText("Refresca el chat para ver nuevos mensajes");
		refrescar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		refrescar.setBounds(1291, 167, 57, 59);
		refrescar.setIcon(new ImageIcon(getClass().getResource("/img/refrescar.png")));
		refrescar.setContentAreaFilled(false);
		refrescar.setFocusPainted(false);
		refrescar.setBorderPainted(false);
		add(refrescar);
		
		JLabel nombreReceptor = new JLabel(seleccionado.getNick());
		nombreReceptor.setHorizontalAlignment(SwingConstants.CENTER);
		nombreReceptor.setFont(new Font("Tahoma", Font.BOLD, 16));
		nombreReceptor.setBounds(977, 178, 223, 36);
		add(nombreReceptor);
		
		textFieldNuevoChat = new JTextField();
		textFieldNuevoChat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldNuevoChat.setToolTipText("");
		textFieldNuevoChat.setBounds(464, 178, 277, 40);
		add(textFieldNuevoChat);
		textFieldNuevoChat.setColumns(10);
		
		buttonAgregarChat = new JButton("");
		buttonAgregarChat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonAgregarChat.setBounds(770, 167, 57, 59);
		buttonAgregarChat.setIcon(new ImageIcon(getClass().getResource("/img/agregar.png")));
		buttonAgregarChat.setContentAreaFilled(false);
		buttonAgregarChat.setFocusPainted(false);
		buttonAgregarChat.setBorderPainted(false);
		add(buttonAgregarChat);
		
		if (user instanceof Profesor) {
			CtrMenu menu = new CtrMenu(new Menu((Profesor) user));
			add(menu.getPanel());
		} else if (user instanceof Estudiante) {
			CtrMenu menu = new CtrMenu(new Menu((Estudiante) user));
			add(menu.getPanel());
		} else {
			CtrMenu menu = new CtrMenu(new Menu((Organizacion) user));
			add(menu.getPanel());
		}
	}

	private void getChatsAbiertos() {
		users = MensajePrivado.usuariosCompartiendoChat(user);
		Object[][] datos = new Object[users.size()][2];
		MensajePrivado aux;
		int k = 0;
		for (Usuario usuarioChat : users) {
			datos[k][0] = usuarioChat.getNick();
			aux = MensajePrivado.getUltimoMensaje(user, usuarioChat);
			if (aux == null) { // Si el ultimo mensaje lo envie yo ya he visto los suyos
				datos[k][1] = true;
			} else {
				datos[k][1] = aux.getLeido();
			}
			
			k++;
		}
		
		String[] columnHeaders = {"Chat", "Notificacion"};
		
		chatsAbiertos = new JTable(datos, columnHeaders);
		chatsAbiertos.getColumnModel().getColumn(0).setCellRenderer(new ButtonChatRenderer(this));
		chatsAbiertos.getColumnModel().getColumn(0).setCellEditor(chatEditor);
		chatsAbiertos.getColumnModel().getColumn(1).setCellRenderer(new NotificacionRenderer());
		chatsAbiertos.getColumnModel().getColumn(1).setCellEditor(chatEditor);
		chatsAbiertos.setTableHeader(null);
		chatsAbiertos.setCellSelectionEnabled(false);
		chatsAbiertos.setShowVerticalLines(false);
	}
	
	private void getMensajes() {
		mensajes = MensajePrivado.getMensajesDeConversacion(user, seleccionado);
		
		String[] columnHeadersConver = {"Receptor", "Emisor"};
		Object[][] datosConver;
		
		datosConver = new Object[mensajes.size()][2];
		
		int k = 0;
		for (MensajePrivado mensajeChat : mensajes) {
			if (mensajeChat.getEmisor().equals(user)) {
				datosConver[k][0] = "";
				datosConver[k][1] = mensajeChat.getTexto();
			} else {
				datosConver[k][0] = mensajeChat.getTexto();
				datosConver[k][1] = "";
			}
			k++;
		}
		
		tablaMensajes = new JTable(datosConver, columnHeadersConver);
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
	
	
	public Usuario getUsuarioSeleccionado() {
		if (chatsAbiertos.getSelectedRow() >= 0) {
			this.seleccionado = users.get(chatsAbiertos.getSelectedRow());
		}
		return seleccionado;
	}
	
	public void controlador(ActionListener ctr) {
		chatEditor.controlador(ctr);
		
		buttonAgregarChat.addActionListener(ctr);
		buttonAgregarChat.setActionCommand("NUEVO_CHAT");
		
		if (enviar != null) {
			enviar.addActionListener(ctr);
			enviar.setActionCommand("ENVIAR");
		}
		
		if (refrescar != null) {
			refrescar.addActionListener(ctr);
			refrescar.setActionCommand("REFRESCAR");
		}
		
	}
	
	public String getMensaje() {
		return textField.getText();
	}
	
	public String getNuevoUsuario() {
		return textFieldNuevoChat.getText();
	}
	
	private class EditorMensajes implements TableCellEditor {

		@Override
		public Object getCellEditorValue() {
			return null;
		}

		@Override
		public boolean isCellEditable(EventObject anEvent) {
			return false;
		}

		@Override
		public boolean shouldSelectCell(EventObject anEvent) {
			return false;
		}

		@Override
		public boolean stopCellEditing() {
			return false;
		}

		@Override
		public void cancelCellEditing() {
			
		}

		@Override
		public void addCellEditorListener(CellEditorListener l) {
			
		}

		@Override
		public void removeCellEditorListener(CellEditorListener l) {
			
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			return null;
		}
		
	}
}
