import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
class AthleteListCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Athlete) {
            Athlete athlete = (Athlete) value;
            setText(athlete.getName());  // Set the text to be displayed as the athlete's name
        }
        return this;
    }
}