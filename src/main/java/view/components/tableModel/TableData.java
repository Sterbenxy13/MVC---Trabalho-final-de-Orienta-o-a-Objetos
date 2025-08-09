
package view.components.tableModel;

import controller.viewController.EntityData;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sterbenxy13
 */
public class TableData {
    private String[] columns;
    private List<EntityData> rows;
    
    public TableData() {
        this.columns = new String[10];
        this.rows = new ArrayList<>();
    }
    
    public TableData(String[] columns, List<EntityData> rows) {
        this.columns = columns;
        this.rows = rows;
    }

    public String[] getColumns() {
        return columns;
    }

    public List<EntityData> getRows() {
        return rows;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public void setRows(List<EntityData> rows) {
        this.rows = rows;
    }
    
    
    
}
