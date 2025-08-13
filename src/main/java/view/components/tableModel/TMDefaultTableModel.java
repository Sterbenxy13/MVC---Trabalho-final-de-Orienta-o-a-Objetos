
package view.components.tableModel;

import controller.viewController.EntityData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sterbenxy13
 */
public class TMDefaultTableModel extends AbstractTableModel {
    private String[] columns;
    private List<EntityData> rows;
    
    public TMDefaultTableModel() {
        this.columns = new String[2];
        this.rows = new ArrayList<>();
    }
    
    public TMDefaultTableModel(TableData data) {
        this.columns = data.getColumns();
        this.rows = data.getRows();
    }
    
    @Override
    public int getRowCount() {
        return this.rows.size();
    }
    
    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.rows.get(rowIndex).get(columns[columnIndex]);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int collumnIndex) {
        return false;
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }
    
    
    
}
