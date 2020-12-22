package Vista;

import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class JButtonDesign extends JButton {
	public JButtonDesign(String name) {
		super(name);
		setForeground(SystemColor.textHighlight);
		setFont(new Font("HP Simplified", Font.ITALIC, 15));
	}
	public JButtonDesign(String name, ) {
		
	}
}
