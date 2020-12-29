package Vista;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class ButtonChatRenderer extends JButton implements TableCellRenderer {
	
	/**
	 * 
	 */
	private ChatPrivado ButtonChatRenderer;

	public ButtonChatRenderer(ChatPrivado chatPrivado) {
		ButtonChatRenderer = chatPrivado;
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