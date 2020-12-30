package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class NotificacionRenderer implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		JButton btn = new JButton();
		
		if ((boolean) value == false) {
			btn.setIcon(new ImageIcon(getClass().getResource("/img/notificacion.png")));
		} else {
			btn.setText("<html><p style=\"width:30px\">" + "No hay mensajes nuevos" + "</p></html>");
			btn.setFont(new Font("Microsoft YaHei", Font.ITALIC, 8));
			btn.setForeground(Color.LIGHT_GRAY);
		}
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		btn.setBorderPainted(false);
		return btn;
		
	}
}
