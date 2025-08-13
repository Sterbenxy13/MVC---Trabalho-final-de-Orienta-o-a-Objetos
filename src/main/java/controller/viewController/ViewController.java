
package controller.viewController;

import controller.exceptions.InvalidActionException;
import controller.globals.Actions;
import controller.globals.Context;
import controller.globals.Route;
import view.DlgMenuSelect;
import view.FrMainFrame;
import view.dialogs.AbstractDialog;
import view.dialogs.AbstractFormDialog;
import view.dialogs.DlgAddForm;
import view.dialogs.DlgEditForm;
import view.menus.AbstractMenuDialog;
import view.tokens.TokenFormInstruction;
import view.tokens.TokenMenuInstruction;
import view.tokens.TokenViewInstruction;
import view.tokens.TokenViewResponse;

/**
 *
 * @author Sterbenxy13
 */
public final class ViewController {
    private FrMainFrame mainFrame;
    private AbstractDialog currentDialog;
    
    private String route;
    
    
    public ViewController() {
        this.mainFrame = new FrMainFrame();
        this.route = Route.START;
    }
    
    public void init() {
        this.mainFrame.setVisible(true);
    }
    
    public TokenViewResponse getResponse() {        
        return this.currentDialog.getResponse();
    }
    
    public void setView(TokenViewInstruction token) {
        
        if (token.getContext().equals(Route.EXIT)) {
            this.mainFrame.dispose();
            return;
        }
        
        if (token.getContext().equals(Route.START)) {
            this.invokeStartMenu();
            return;
        }
        if (token.getContext().equals(Route.MENU)) {
            this.invokeMenu((TokenMenuInstruction) token);
            return;
        }
        if (token.getContext().equals(Route.FORM)) {
            this.invokeForm((TokenFormInstruction) token);
            return;
        }
        
//        throws new InvalidContextException(token.getContext());

//        this.route = 

        return;
    }
    
    private void invokeStartMenu() {
        DlgMenuSelect mainDlg = new DlgMenuSelect(this.mainFrame);
        mainDlg.setVisible(true);
        this.currentDialog = mainDlg;
    }
    
    private void invokeMenu(TokenMenuInstruction menuInstruction) {
        AbstractMenuDialog menu = new AbstractMenuDialog(this.mainFrame, menuInstruction);
        menu.setVisible(true);
        this.currentDialog = menu;
    }
    
    private void invokeForm(TokenFormInstruction formInstruction) {
        if (formInstruction.getAction().equals(Actions.ADD)) {
            AbstractFormDialog form = new DlgAddForm(this.mainFrame, formInstruction);
            form.setVisible(true);
            this.currentDialog = form;
            return;
        }
        if (formInstruction.getAction().equals(Actions.EDIT)) {
            AbstractFormDialog form = new DlgEditForm(this.mainFrame, formInstruction);
            form.setVisible(true);
            this.currentDialog = form;
            return;
        }
        
        throw new InvalidActionException(formInstruction.getAction());
        
        
    }
    
    
}
