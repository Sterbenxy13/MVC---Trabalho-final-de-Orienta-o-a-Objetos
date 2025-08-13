
package view.menus;

import model.entity.User;
import view.FrMainFrame;
import view.ResponsibleView;
import view.tokens.TokenMenuInstruction;

@Deprecated
/**
 *
 * @author Sterbenxy13
 */
public class DlgUserMenu extends AbstractMenuDialog implements ResponsibleView {
    
    /**
     * Creates new form FrUserManager
     */
    public DlgUserMenu(FrMainFrame parent, TokenMenuInstruction instructions) {
        super(parent,instructions);
        
    }
    
}
