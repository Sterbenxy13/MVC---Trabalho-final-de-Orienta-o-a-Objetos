
package controller.viewController;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 *
 * @author Sterbenxy13
 */
public class TokenFrameResponse {
    
    private String action;
    private Integer entityIndex;
    private EntityData data;
//    private Dictionary<String, String> data;
    
    public TokenFrameResponse() {
        this.action = "";
        this.entityIndex = -1;
        this.data = new EntityData();
    }
    
    public TokenFrameResponse(String action) {
        this.action = action;
        this.entityIndex = -1;
        this.data = new EntityData();
    }
    
    public TokenFrameResponse(String action, Integer entityIndex) {
        this.action = action;
        this.entityIndex = entityIndex;
        this.data = new EntityData();
    }
    
    public TokenFrameResponse(String action, Integer entityIndex, EntityData data) {
        this.action = action;
        this.entityIndex = entityIndex;
        this.data = data;
    }

    public String getAction() {
        return this.action;
    }

    public Integer getEntityIndex() {
        return this.entityIndex;
    }

    public EntityData getData() {
        return this.data;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setEntityIndex(Integer entityIndex) {
        this.entityIndex = entityIndex;
    }

    public void setData(EntityData data) {
        this.data = data;
    }
    
    
    
}
