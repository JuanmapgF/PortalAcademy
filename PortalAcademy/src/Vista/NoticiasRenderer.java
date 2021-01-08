package Vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

public class NoticiasRenderer implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
    	JLabel aux;
    	if (row == 0) {
    		aux = new JLabel("<html><p style=\"width:130px\">" + value + "</p></html>");
    		aux.setOpaque(true);
			aux.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			aux.setHorizontalAlignment(SwingConstants.CENTER);
			aux.setVerticalAlignment(SwingConstants.CENTER);
    	} else {
    		aux = new JLabel("<html><p style=\"width:130px\">" + value + "</p></html>");
    		aux.setOpaque(true);
			aux.setFont(new Font("Segoe UI", Font.PLAIN, 11));
			aux.setHorizontalAlignment(SwingConstants.CENTER);
			aux.setVerticalAlignment(SwingConstants.TOP);
    	}
    	
    	if (column % 3 == 0) {
    		aux.setBackground(Color.decode("#6AC6F5"));
    	} else if (column % 3 == 1) {
    		aux.setBackground(Color.decode("#5fb2dc"));
    	} else {
    		aux.setBackground(Color.decode("#549ec4"));
    	}
    	
		return aux;
	}

}
