
package view.tokens;

import controller.viewController.EntityData;

/**
 *
 * @author Sterbenxy13
 */
public class TokenFormInstruction extends TokenViewInstruction {
    private String action;
    private EntityData entityData;
    
    public TokenFormInstruction() {
        super();
        this.entityData = new EntityData();        
    }

    public TokenFormInstruction(TokenViewInstruction other) {
        super(other);
        this.entityData = new EntityData();
    }
    
    public TokenFormInstruction(
            String title,
            String context,
            String origin,
            String action,
            EntityData entityData
    ) {
        super(title, context, origin);
        this.action = action;
        this.entityData = entityData;
    }

    public EntityData getEntityData() {
        return entityData;
    }

    public String getAction() {
        return action;
    }    

    public void setEntityData(EntityData entityData) {
        this.entityData = entityData;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
    
    
}
