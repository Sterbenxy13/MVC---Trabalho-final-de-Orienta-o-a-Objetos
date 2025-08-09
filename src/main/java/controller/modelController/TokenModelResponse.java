
package controller.modelController;

import view.components.tableModel.TableData;

/**
 *
 * @author Sterbenxy13
 */
public class TokenModelResponse {
    private String title;
    private String context;
    private String origin;
    private TableData tableData;

    public TokenModelResponse() {
        this.title = "NULL";
        this.context = "NULL";
        this.origin = "NULL";
        this.tableData = new TableData();
    }

    public TokenModelResponse(String title, String context, String origin, TableData tableData) {
        this.title = title;
        this.context = context;
        this.origin = origin;
        this.tableData = tableData;
    }

    public String getTitle() {
        return title;
    }

    public String getContext() {
        return context;
    }

    public String getOrigin() {
        return origin;
    }

    public TableData getTableData() {
        return tableData;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setTableData(TableData tableData) {
        this.tableData = tableData;
    }
    
    
    
    
}
