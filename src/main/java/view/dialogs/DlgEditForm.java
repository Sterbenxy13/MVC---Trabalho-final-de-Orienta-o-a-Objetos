
package view.dialogs;

import controller.globals.Actions;
import view.tokens.TokenFormInstruction;
import view.tokens.TokenFormResponse;

/**
 *
 * @author Sterbenxy13
 */
public class DlgEditForm extends AbstractFormDialog {
    private Integer entityIndex;
    
    public DlgEditForm(java.awt.Frame parent, TokenFormInstruction instructions) {
        super(parent,instructions);
        this.entityIndex = instructions.getEntityData().getIndex();
        super.setFormData(instructions.getEntityData());
    }
    
    @Override
    protected void performConfirmAction() {
        super.response = new TokenFormResponse(
                super.getFormData(),
                super.context,
                super.origin,
                Actions.EDIT,
                this.entityIndex
        );
    }
}
