
package controller.modelController;

import view.components.tableModel.TableData;

/**
 *
 * @author Sterbenxy13
 */
public class TokenModelMenuResponse extends TokenModelResponse {
    private TableData tableData;

    public TokenModelMenuResponse() {
        this.tableData = new TableData();
    }
    
    public TokenModelMenuResponse(String title, String context, String origin, TableData tableData) {
        super(title, context, origin);
        this.tableData = tableData;
    }    

    public TableData getTableData() {
        return tableData;
    }

    public void setTableData(TableData tableData) {
        this.tableData = tableData;
    }
    
    
    
    
}
