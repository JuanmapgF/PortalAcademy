package Vista;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

import Controlador.CtrMenu;
import Modelo.Estudiante;
import Modelo.Organizacion;
import Modelo.Profesor;
import Modelo.Usuario;

public class ChatPrivado extends JPanel {
	
	private Usuario user;
	private JTable chatsAbiertos;
	private List<Usuario> users;
	
	private ButtonChatEditor chatEditor = new ButtonChatEditor(new JTextField());

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
		chatsAbiertos.getColumnModel().getColumn(0).setCellRenderer(new ButtonChatRenderer());
		chatsAbiertos.getColumnModel().getColumn(0).setCellEditor(chatEditor);
		chatsAbiertos.setTableHeader(null);
		chatsAbiertos.setCellSelectionEnabled(false);
		chatsAbiertos.setShowVerticalLines(false);
	}
	
	public Usuario getUsuarioSeleccionado() {
		return users.get(chatsAbiertos.getSelectedRow());
	}
	
	public void controlador(ActionListener ctr) {
		chatEditor.controlador(ctr);
	}

	private class ButtonChatRenderer extends JButton implements TableCellRenderer {
		
		public ButtonChatRenderer() {
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			this.setText((String) value);
			this.setContentAreaFilled(false);
			this.setFocusPainted(false);
			this.setBorderPainted(false);
			return this;
		}

	}
	
	private class ButtonChatEditor extends DefaultCellEditor {
		private JButton btn;
		private String lbl;
		private Boolean clicked;
		 
		 public ButtonChatEditor(JTextField txt) {
			super(txt);
			
			btn = new JButton();
			btn.setOpaque(true);
			
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					fireEditingStopped();
				}
			});
		}
		 
//		 OVERRIDE A COUPLE OF METHODS
		 @Override
		public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col) {

				//SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
			 lbl = (obj == null) ? "":obj.toString();
			 btn.setText(lbl);
			 clicked = true;
			return btn;
		}
		 
//		//IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
//		 @Override
//		public Object getCellEditorValue() {
//			 if(clicked) {
//				 //SHOW US SOME MESSAGE
//				 JOptionPane.showMessageDialog(btn, lbl+" Clicked");
//			 }
//			 
//			 //SET IT TO FALSE NOW THAT ITS CLICKED
//			 clicked=false;
//			 
//		  return new String(lbl);
//		}
		
		 @Override
		public boolean stopCellEditing() {
			 //SET CLICKED TO FALSE FIRST
			 clicked = false;
			 
			return super.stopCellEditing();
		}
		 
		 @Override
		public void fireEditingStopped() {
			super.fireEditingStopped();
		}
		 
		public void controlador(ActionListener ctr) {
			btn.addActionListener(ctr);
			btn.setActionCommand("VER_CHAT");
		}
	}
}
