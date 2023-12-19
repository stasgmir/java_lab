import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class HornerTableCellRenderer implements TableCellRenderer {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();

    private boolean needle = false;
    private DecimalFormat formatter =
            (DecimalFormat) NumberFormat.getInstance();

    public HornerTableCellRenderer() {
        formatter.setMaximumFractionDigits(10);
        formatter.setGroupingUsed(false);
        DecimalFormatSymbols dottedDouble = formatter.getDecimalFormatSymbols();
        dottedDouble.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(dottedDouble);
        label.setBackground(Color.GRAY);////
        panel.add(label);

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

   public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int col) {
        String formattedDouble = formatter.format(value);
        label.setText(formattedDouble);

        /*if (col == 1 && formattedDouble.equals("1")) {
            panel.setBackground(Color.RED);
        } else {
            panel.setBackground(table.getBackground());
        }*/
       if (col == 0 ) {
           panel.setBackground(table.getBackground());;
        } else {

        }

        return panel;
    }

    public void setNeedle(boolean needle) {
        this.needle = needle;
    }
}
