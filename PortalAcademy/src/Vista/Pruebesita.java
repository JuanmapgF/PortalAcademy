package Vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import Modelo.Actividad;
import Modelo.BD;
import Modelo.Curso;

import javax.swing.JTable;
import javax.swing.JTextField;

public class Pruebesita extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pruebesita frame = new Pruebesita(Curso.getTodosLosCursos());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private class ButtonRenderer extends JButton implements TableCellRenderer {

		
		public ButtonRenderer() {
			setOpaque(true);
		}
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			// TODO Auto-generated method stub
			
			this.setText((value==null) ? "":value.toString());
			return this;
		}
		
	}
	
	private class ButtonEditor extends DefaultCellEditor {
		private JButton btn;
		private String lbl;
		private Boolean clicked;
		 
		 public ButtonEditor(JTextField txt) {
			super(txt);
			
			btn = new JButton();
			btn.setOpaque(true);
			
			//WHEN BUTTON IS CLICKED
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					fireEditingStopped();
				}
			});
		}
		 
		 //OVERRIDE A COUPLE OF METHODS
		 @Override
		public Component getTableCellEditorComponent(JTable table, Object obj,
				boolean selected, int row, int col) {

				//SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
			 lbl = (obj==null) ? "":obj.toString();
			 btn.setText(lbl);
			 clicked=true;
			return btn;
		}
		 
		//IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
		 @Override
		public Object getCellEditorValue() {

			 if(clicked)
				{
				//SHOW US SOME MESSAGE
					JOptionPane.showMessageDialog(btn, lbl+" Clicked");
				}
			//SET IT TO FALSE NOW THAT ITS CLICKED
			clicked=false;
		  return new String(lbl);
		}
		
		 @Override
		public boolean stopCellEditing() {

		       //SET CLICKED TO FALSE FIRST
				clicked=false;
			return super.stopCellEditing();
		}
		 
		 @Override
		protected void fireEditingStopped() {
			// TODO Auto-generated method stub
			super.fireEditingStopped();
		}
	}
	
	private class ImageRenderer extends JPanel implements TableCellRenderer {

		public Component getTableCellRendererComponent(JTable jtable, Object value, boolean isSelected,
				boolean hasFocus, int row, int column) {
			
			if (value != null) {
				return new JPanelImagen(((File) value).getName());
			} else {
				return new JPanelImagen(getClass().getResource("/img/curso_default.png"));
			}
			
		}
		
	}

	
	public Pruebesita(List<Curso> lc) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 964, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Object[][] data = new Object[lc.size()][3];
		BD bd = BD.getBD();
		
		
		int k = 0;
		for (Curso curso : lc) {			
			data[k][0] = curso.getImagen();
			data[k][1] = curso.getNombre();
			data[k][2] = "Ver curso";
			k++;
		}
		
		String[] columnHeaders = {"Imagen", "Curso", "Acceso"};
		
		table = new JTable(data, columnHeaders);
		table.setBounds(165, 11, 600, 400);
		table.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
		table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());
		table.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JTextField()));
		table.setRowHeight(90);
		
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(165, 11, 600, 400);
		scroll.setViewportView(table);
		
		contentPane.add(scroll);
	}
}
