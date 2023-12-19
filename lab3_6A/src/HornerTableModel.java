import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class HornerTableModel extends AbstractTableModel {
    private final Double[] coefficients;
    private final Double from;
    private final Double to;
    private final Double step;

    public HornerTableModel(Double from, Double to, Double step,
                            Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    public int getColumnCount() {
        return 3;
    }

    public int getRowCount() {
        return (int) Math.ceil((to - from) / step) + 1;
    }

    public Object getValueAt(int row, int col) {
        double x = from + step * row;
        switch (col) {
            case 0:
                return x;
            case 1:
                return calculateHorner(x);
            case 2:
                return isCloseToInt(calculateHorner(x));
            default:
                return 0;
        }
    }


    private Object isCloseToInt(double x) {
        return Math.abs(Math.round(x) - x) <= 0.11;
    }

    public String getColumnName(int col) {
        switch (col) {
            case 0:
                return "Значение X";
            case 1:
                return "Значение многочлена";
            case 2:
                return "Близко к целому";
            default:
                return "";
        }
    }

    public Class<?> getColumnClass(int col) {
        switch (col) {
            case 2:
                return Boolean.class;
            case 0:
            case 1:
            default:
                return Double.class;
        }
    }

    private double calculateHorner(double x) {
        Double b = coefficients[coefficients.length - 1];
        for (int i = coefficients.length - 2; i >= 0; i--) {
            b = b * x + coefficients[i];
        }
        return b;
    }
}

