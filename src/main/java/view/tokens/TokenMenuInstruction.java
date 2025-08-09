
package view.tokens;

import view.components.tableModel.TableData;

/**
 *
 * @author Sterbenxy13
 */
public class TokenMenuInstruction extends TokenViewInstruction {
    private TableData tableData;
    
    public TokenMenuInstruction() {
        super();
        this.tableData = new TableData();
    }

    public TableData getTableData() {
        return tableData;
    }

    public void setTableData(TableData tableData) {
        this.tableData = tableData;
    }

    @Override
    public String toString() {
        return super.toString() + ": TokenMenuInstruction{" + "tableData=" + tableData + '}';
    }
    
}
