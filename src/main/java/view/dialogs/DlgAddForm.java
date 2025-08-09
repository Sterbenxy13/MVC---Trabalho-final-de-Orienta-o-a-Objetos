
package view.dialogs;

import controller.globals.Actions;
import view.tokens.TokenFormInstruction;
import view.tokens.TokenFormResponse;

/**
 *
 * @author Sterbenxy13
 */
public class DlgAddForm extends AbstractFormDialog {

    public DlgAddForm(java.awt.Frame parent, TokenFormInstruction instructions) {
        super(parent,instructions);
    }

    @Override
    protected void performConfirmAction() {
        super.response = new TokenFormResponse(
                super.getFormData(),
                super.context,
                super.origin,
                Actions.ADD,
                -1
        );
    }
    
}
