
package controller.modelController;

import controller.modelController.entityController.AbstractEntityController;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.entity.IEntity;

/**
 *
 * @author Sterbenxy13
 */
public class EntityUtilities<E extends IEntity, C extends AbstractEntityController> {
    private final String fileName;
    private final java.lang.Class<E> entityClass;
    private Constructor<C> controllerConstructor;
    
    public EntityUtilities(
            String fileName, 
            java.lang.Class<E> entityClass,
            java.lang.Class<C> controllerClass
    ) {
        this.fileName = fileName;
        this.entityClass = entityClass;
        try {
            this.controllerConstructor = controllerClass.getConstructor(List.class);
            
        } catch (NoSuchMethodException | SecurityException ex) {
            String errorMessage = "Construtor e/ou classe inválida em EntityUtilities:28";
            Logger.getLogger(EntityUtilities.class.getName()).log(Level.SEVERE, errorMessage, ex);
        }
    }

    public String getFileName() {
        return fileName;
    }

    public Class<E> getEntityClass() {
        return entityClass;
    }

    public Constructor<C> getControllerConstructor() {
        return controllerConstructor;
    }
    
    
}
