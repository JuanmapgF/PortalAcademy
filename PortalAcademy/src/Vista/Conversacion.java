package Vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import Controlador.CtrMenu;

import java.util.List;

import Modelo.Usuario;
import Modelo.Estudiante;
import Modelo.MensajePrivado;
import Modelo.Organizacion;
import Modelo.Profesor;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class Conversacion extends JPanel {
	
	private Usuario user;
	private Usuario seleccionado;
	private JTable tablaMensajes;
	private List<MensajePrivado> mensajes;
	private JTextField textField;
	private JButton enviar;
	private JButton refrescar;
	
	/**
	 * Create the panel.
	 */
	public Conversacion(Usuario user, Usuario seleccionado) {
		this.setBounds(0, 0, 1080, 650);
		setLayout(null);
		
		this.user = user;
		this.seleccionado = seleccionado;
		
		getMensajes();
		
		JScrollPane sp = new JScrollPane();
		sp.setBounds(550, 105, 273, 446);
		sp.setViewportView(tablaMensajes);
		add(sp);
		
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
		tablaMensajes.getColumnModel().getColumn(0).setCellRenderer(new MensajeReceptorRenderer());
		tablaMensajes.getColumnModel().getColumn(1).setCellRenderer(new MensajeEmisorRenderer());
		tablaMensajes.setTableHeader(null);
		tablaMensajes.setCellSelectionEnabled(false);
		tablaMensajes.setShowVerticalLines(false);
		tablaMensajes.setShowHorizontalLines(false);
	}
	
	
	
    private class MensajeEmisorRenderer extends JLabel implements TableCellRenderer {


        @Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub
        	JLabel lbl = new JLabel();
        	
			if (value.equals("")) {
				lbl.setText("");
			} else {
				lbl.setText((String) value);
				lbl.setOpaque(true);
				lbl.setBackground(Color.getColor("#00BABB"));
			}
			return lbl;
		}
    }
    
    private class MensajeReceptorRenderer extends JLabel implements TableCellRenderer {


        @Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub
        	JLabel lbl = new JLabel();
        	
        	if (value.equals("")) {
				lbl.setText("");
			} else {
				lbl.setText((String) value);
				lbl.setOpaque(true);
				lbl.setBackground(Color.getColor("#BDC1D6"));
			}
			return lbl;
		}
    }
    
    public void controlador(ActionListener ctr) {
		enviar.addActionListener(ctr);
		enviar.setActionCommand("ENVIAR");
		
		refrescar.addActionListener(ctr);
		refrescar.setActionCommand("REFRESCAR");
	}
	
	public String getMensaje() {
		return textField.getText();
	}
}
