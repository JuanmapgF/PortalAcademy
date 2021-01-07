package Vista;

import java.awt.Color;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.IDateEvaluator;
import com.toedter.calendar.JCalendar;

import Controlador.CtrCalendario;
import Controlador.CtrMenu;
import Modelo.Actividad;

public class Calendario extends JPanel {
		
	public Calendario (Date d) {
			this.setBounds(0, 0, 1080, 650);
			setLayout(null);
			
			Calendar cal = Calendar.getInstance();
		    cal.setTime(d);
			JLabel lblNewLabel = new JLabel("Eventos del día " + cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR));
			lblNewLabel.setBounds(332, 147, 403, 33);
			lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
			add(lblNewLabel);
			
			
			CtrMenu menu = new CtrMenu(new Menu());
			add(menu.getPanel());
		}
		
//		public Calendario (Profesor p) {
//			
//		}
		
		private static class HighlightEvaluator implements IDateEvaluator {

	        private final List<Date> list = new ArrayList<>();

	        public void add(Date date) {
	            list.add(date);
	        }

	        @Override
	        public boolean isSpecial(Date date) {
	            return list.contains(date);
	        }

	        @Override
	        public Color getSpecialForegroundColor() {
	            return Color.black;
	        }

	        @Override
	        public Color getSpecialBackroundColor() {
	            return Color.yellow;
	        }

	        @Override
	        public String getSpecialTooltip() {
	            return "Highlighted event.";
	        }

	        @Override
	        public boolean isInvalid(Date date) {
	            return false;
	        }

	        @Override
	        public Color getInvalidForegroundColor() {
	            return null;
	        }

	        @Override
	        public Color getInvalidBackroundColor() {
	            return null;
	        }

	        @Override
	        public String getInvalidTooltip() {
	            return null;
	        }
	    }
}
