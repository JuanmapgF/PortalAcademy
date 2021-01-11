package Vista;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class ButtonChatRenderer extends JButton implements TableCellRenderer {
	
	/**
	 * 
	 */
	private ChatPrivado ButtonChatRenderer;

	public ButtonChatRenderer(ChatPrivado chatPrivado) {
		ButtonChatRenderer = chatPrivado;
		setOpaque(false);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		this.setText((String) value);
		this.setHorizontalAlignment(SwingConstants.LEFT);
		
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		this.setBorderPainted(false);
		return this;
		
	}

}