
package model.serializer;

import controller.viewController.EntityData;
import model.entity.IEntity;

/**
 *
 * @author Sterbenxy13
 */
public class SerializerEntityData {
    
    public SerializerEntityData() {
    }
    
    public EntityData serialize(IEntity entity) {
        return new EntityData(entity.getFields());
    }
    
}
