package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

	public class MensajeRenderer extends JLabel implements TableCellRenderer {


    /**
	 * 
	 */
	private ChatPrivado MensajeRenderer;

	/**
	 * @param chatPrivado
	 */
	MensajeRenderer(ChatPrivado chatPrivado) {
		MensajeRenderer = chatPrivado;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
    	this.setOpaque(true);
    	this.setText("<html><p style=\"width:80px\">"+(String) value+"</p></html>");
    	this.setFont(new Font("Microsoft YaHei", Font.ITALIC, 11));
    	
    	
    	
		if (value.equals("")) {
			setBackground(Color.decode("#F0F0F0"));
		} else {
			if (column == 0) {
				setBackground(Color.decode("#BDC1D6"));
			} else {
				setBackground(Color.decode("#00BABB"));
			}
		}
		return this;
	}
}