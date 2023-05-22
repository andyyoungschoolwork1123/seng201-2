import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
/**
 * A custom list cell renderer for displaying Athlete objects in a JList.
 * This renderer sets the text of each list cell to the athlete's name.
 */
class AthleteListCellRenderer extends DefaultListCellRenderer {
    @Override
    /**
     * Returns the component used for rendering the list cell.
     *
     * @param list         the JList being painted
     * @param value        the value to be rendered
     * @param index        the cell index
     * @param isSelected  true if the cell is selected
     * @param cellHasFocus true if the cell has focus
     * @return the component used for rendering the list cell
     */
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Athlete) {
            Athlete athlete = (Athlete) value;
            setText(athlete.getName());  // Set the text to be displayed as the athlete's name
        }
        return this;
    }
}