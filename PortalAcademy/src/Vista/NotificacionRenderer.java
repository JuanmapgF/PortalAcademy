package Vista;

import java.awt.Component;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class NotificacionRenderer extends JButton implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		if (!(boolean) value)
			this.setIcon(new ImageIcon(getClass().getResource("/img/notificacion.png")));
		
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		this.setBorderPainted(false);
		return this;
		
	}
}
