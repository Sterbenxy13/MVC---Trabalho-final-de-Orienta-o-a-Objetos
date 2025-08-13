
package controller.viewController;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Dictionary;
import java.util.Hashtable;
import view.menus.AbstractMenuDialog;
import view.menus.DlgBookMenu;
import view.FrMainFrame;
import view.dialogs.AbstractDialog;
import view.menus.DlgUserMenu;

/**
 *
 * @author Sterbenxy13
 */
public class MenuController<T extends AbstractMenuDialog> {
    
    private Dictionary<String, java.lang.Class<T>> menus;
    private FrMainFrame parent;
    
    public MenuController(FrMainFrame parent) {
        this.menus = new Hashtable<>();
        this.parent = parent;
        this.init();
    }
    
    public AbstractDialog loadMenu(String menuName) {
        try {
            Constructor<T> constr = this.menus.get(menuName).getConstructor(FrMainFrame.class);
            AbstractMenuDialog menu = constr.newInstance(this.parent);
            menu.setVisible(true);
            return menu;
            
        } catch (InstantiationException | IllegalAccessException 
                | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException ex) 
        {
//            throws new 
            return null;
        }
    }
    
    private void init() {
        this.menus.put("USER", (Class<T>) DlgUserMenu.class);
        this.menus.put("BOOK", (Class<T>) DlgBookMenu.class);
    }
    
    
}
