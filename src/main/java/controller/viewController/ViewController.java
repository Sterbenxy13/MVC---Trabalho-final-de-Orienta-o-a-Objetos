
package controller.viewController;

import controller.exceptions.InvalidActionException;
import controller.globals.Actions;
import controller.globals.Contexts;
import logger.Logger;
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

//    private MenuController menuController;
//    private DialogController dialogController;
    private FrMainFrame mainFrame;
    private AbstractDialog currentDialog;
    
    
    public ViewController() {
        this.mainFrame = new FrMainFrame();
        
//        this.menuController = new MenuController(this.mainFrame);
//        this.dialogController = new DialogController(this.mainFrame);
    }
    
    public void init() {
        this.mainFrame.setVisible(true);
    }
    
    public TokenViewResponse getResponse() {
//        TokenFrameResponse response = new TokenFrameResponse();
//        
//        while (token.getAction().equals("EXIT") == false) {
//            this.setView(token);
//
//            response = this.currentDialog.getResponse();
//
//            if (response.getAction().equals("EXIT")) {
//                return response;
//            }
//            if (response.getAction().equals("BACK")) {
//                token = new TokenViewLoading("");
//                continue;
//            }
//            if (response.getAction().equals("CONFIRM")) {
//                return response;
//            }
//        }
        
        return this.currentDialog.getResponse();
    }
    
    public void setView(TokenViewInstruction token) {
        
        if (token.getContext().equals(Contexts.EXIT)) {
            this.mainFrame.dispose();
            return;
        }
        
        if (token.getContext().equals(Contexts.START)) {
            this.invokeStartMenu();
            return;
        }
        if (token.getContext().equals(Contexts.MENU)) {
            this.invokeMenu((TokenMenuInstruction) token);
            return;
        }
        if (token.getContext().equals(Contexts.FORM)) {
            this.invokeForm((TokenFormInstruction) token);
            return;
        }
        
//        throws new InvalidContextException(token.getContext());
        
        return;
    }
    
    private void invokeStartMenu() {
        DlgMenuSelect mainDlg = new DlgMenuSelect(this.mainFrame);
        mainDlg.setVisible(true);
        this.currentDialog = mainDlg;
    }
    
    private void invokeMenu(TokenMenuInstruction menuInstruction) {
        Logger.log("ViewController.invokeMenu(): " + menuInstruction.toString());
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
