package Vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import Controlador.CtrMenu;
import Modelo.Estudiante;
import Modelo.MensajePrivado;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;

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
	private JScrollPane chat;
	
	private ButtonChatEditor chatEditor = new ButtonChatEditor(this, new JTextField());

	public ChatPrivado(Usuario user) {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);
		
		this.user = user;
		
		getChatsAbiertos();
		
		JScrollPane sp = new JScrollPane();
		sp.setBounds(230, 105, 273, 479);
		sp.setViewportView(chatsAbiertos);
		add(sp);
		chatsAbiertos.setRowHeight(75);
		
		
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
	

	public ChatPrivado(Usuario user, Usuario seleccionado) {
		
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);
		
		this.user = user;
		
		this.seleccionado = seleccionado;
		
		getChatsAbiertos();
		
		JScrollPane sp = new JScrollPane();
		sp.setBounds(230, 105, 273, 479);
		sp.setViewportView(chatsAbiertos);
		add(sp);
		chatsAbiertos.setRowHeight(75);
		
		getMensajes();
		
		JScrollPane chat = new JScrollPane();
		chat.setBounds(550, 105, 273, 446);
		chat.setViewportView(tablaMensajes);
		add(chat);
		tablaMensajes.setRowHeight(50);
//		chat.setBorder(BorderFactory.createEmptyBorder());
		
		textField = new JTextField();
		textField.setBounds(550, 562, 240, 20);
		add(textField);
		textField.setColumns(20);

		enviar = new JButton("");
		enviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		enviar.setBounds(796, 554, 40, 36);
		enviar.setIcon(new ImageIcon(getClass().getResource("/img/enviar.png")));
		enviar.setContentAreaFilled(false);
		enviar.setFocusPainted(false);
		enviar.setBorderPainted(false);
		add(enviar);
		
		refrescar = new JButton("");
		refrescar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		refrescar.setBounds(783, 58, 40, 36);
		refrescar.setIcon(new ImageIcon(getClass().getResource("/img/refrescar.png")));
		refrescar.setContentAreaFilled(false);
		refrescar.setFocusPainted(false);
		refrescar.setBorderPainted(false);
		add(refrescar);
		
		JLabel nombreReceptor = new JLabel(seleccionado.getNick());
		nombreReceptor.setHorizontalAlignment(SwingConstants.CENTER);
		nombreReceptor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nombreReceptor.setBounds(550, 58, 223, 36);
		add(nombreReceptor);
		
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
		users = user.usuariosCompartiendoChat();
		Object[][] datos = new Object[users.size()][1];
		int k = 0;
		for (Usuario usuarioChat : users) {
			datos[k][0] = usuarioChat.getNick();
			k++;
		}
		
		String[] columnHeaders = {"Chat"};
		
		chatsAbiertos = new JTable(datos, columnHeaders);
		chatsAbiertos.getColumnModel().getColumn(0).setCellRenderer(new ButtonChatRenderer(this));
		chatsAbiertos.getColumnModel().getColumn(0).setCellEditor(chatEditor);
		chatsAbiertos.setTableHeader(null);
		chatsAbiertos.setCellSelectionEnabled(false);
		chatsAbiertos.setShowVerticalLines(false);
	}
	
	private void getMensajes() {
		mensajes = MensajePrivado.getMensajesDeConversacion(user, seleccionado);
		Object[][] datos = new Object[mensajes.size()][2];
		int k = 0;
		for (MensajePrivado mensajeChat : mensajes) {
			if (mensajeChat.getEmisor().equals(user)) {
				datos[k][0] = "";
				datos[k][1] = mensajeChat.getTexto();
			} else {
				datos[k][0] = mensajeChat.getTexto();
				datos[k][1] = "";
			}
			k++;
		}
		
		String[] columnHeaders = {"Receptor", "Emisor"};
		
		tablaMensajes = new JTable(datos, columnHeaders);
		tablaMensajes.getColumnModel().getColumn(0).setCellRenderer(new MensajeRenderer(this));
		tablaMensajes.getColumnModel().getColumn(1).setCellRenderer(new MensajeRenderer(this));
		tablaMensajes.setTableHeader(null);
		tablaMensajes.setCellSelectionEnabled(false);
		tablaMensajes.setGridColor(Color.decode("#F0F0F0"));
	}
	
	public Usuario getUsuarioSeleccionado() {
		if (seleccionado == null) {
			this.seleccionado = users.get(chatsAbiertos.getSelectedRow());
		}
		return seleccionado;
	}
	
	public void controlador(ActionListener ctr) {
		chatEditor.controlador(ctr);
		
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
    
    
    
}
