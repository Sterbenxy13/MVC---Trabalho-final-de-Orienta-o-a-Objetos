
package view.components.tableModel;

import controller.viewController.EntityData;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe para encapsular as informações necessárias para a criação da
 * PanDefaultEntityTable.
 * 
 * @author Sterbenxy13
 * @see view.components.tableModel.PanDefaultEntityTable#PanDefaultEntityTable() 
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

    @Override
    public String toString() {
        String columnsToPrint = "";
        for (String c: columns) {
            columnsToPrint += c;
        }
        return "TableData{" + "columns=" + columnsToPrint + ", rows=" + rows + '}';
    }
    
    
    
    
}
