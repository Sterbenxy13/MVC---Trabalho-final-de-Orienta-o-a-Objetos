
package controller.modelController;

import controller.viewController.EntityData;

/**
 *
 * @author Sterbenxy13
 */
public class TokenModelFormResponse extends TokenModelResponse {
    private String action;
    private EntityData entityData;

    public TokenModelFormResponse() {
        super();
        this.action = "NULL";
        this.entityData = new EntityData();
    }
    
    public TokenModelFormResponse(String title, String context, String origin) {
        super(title, context, origin);
    }
    
    public TokenModelFormResponse(String action, EntityData entityData) {
        super();
        this.action = action;
        this.entityData = entityData;
    }

    public String getAction() {
        return action;
    }

    public EntityData getEntityData() {
        return entityData;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setEntityData(EntityData entityData) {
        this.entityData = entityData;
    }

    
    
    
    
    

    
    
    
    
    
}
