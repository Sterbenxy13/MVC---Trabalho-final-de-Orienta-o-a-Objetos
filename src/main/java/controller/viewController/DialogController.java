
package controller.viewController;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Dictionary;
import java.util.Hashtable;
import view.FrMainFrame;
import view.dialogs.AbstractFormDialog;
import view.dialogs.DlgAddForm;
import view.dialogs.DlgEditForm;

/**
 *
 * @author Sterbenxy13
 */
public class DialogController<T extends AbstractFormDialog> {
    Dictionary<String, java.lang.Class<T>> dialogs;
    private FrMainFrame parent;
    
    public DialogController(FrMainFrame parent) {
        this.dialogs = new Hashtable<>();
        this.parent = parent;
        this.init();
    }
    
    public AbstractFormDialog loadForm(
            String action, 
            String title, 
            java.lang.Class entityClass, 
            EntityData entityData
    ) {
        try {
            Constructor<T> constr = this.dialogs.get(action).getConstructor(
                    FrMainFrame.class,
                    String.class,
                    java.lang.Class.class,
                                EntityData.class
            );
            AbstractFormDialog currentDlg = constr.newInstance(
                    this.parent,
                    title,
                    entityClass,
                    entityData
            );
            currentDlg.setVisible(true);
            return currentDlg;
            
        } catch (InstantiationException | IllegalAccessException 
                | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException ex) 
        {
//            throws new 
            return null;
        }
    }
    
    private void init() {
        this.dialogs.put("ADD", (Class<T>) DlgAddForm.class);
        this.dialogs.put("EDIT", (Class<T>) DlgEditForm.class);        
    }
    
    
    
}
