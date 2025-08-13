
package view.tokens;

import controller.viewController.EntityData;

/**
 *
 * @author Sterbenxy13
 */
public class TokenFormResponse extends TokenViewResponse {
    
    private EntityData entityData;
    
    public TokenFormResponse() {
        super();
        this.entityData = new EntityData();
    }
    
    public TokenFormResponse(String context) {
        super(context);
        this.entityData = new EntityData();
    }
    
    public TokenFormResponse(
            EntityData entityData,
            String context, 
            String origin, 
            String action, 
            Integer entityIndex
    ) {
        super(context, origin, action, entityIndex);
        this.entityData = entityData;
    }

    public EntityData getEntityData() {
        return entityData;
    }

    public void setEntityData(EntityData entityData) {
        this.entityData = entityData;
    }
    
    
    
}
