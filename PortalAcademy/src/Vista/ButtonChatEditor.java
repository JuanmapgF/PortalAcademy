package Vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class ButtonChatEditor extends DefaultCellEditor {
		/**
		 * 
		 */
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
		 
		public ButtonChatEditor(InformacionCursoForo icf, JTextField txt) {
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