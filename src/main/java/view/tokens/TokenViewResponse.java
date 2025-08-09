
package view.tokens;

/**
 *
 * @author Sterbenxy13
 */
public class TokenViewResponse {
    private String context;
    private String origin;
    private String action;
    private Integer entityIndex;

    public TokenViewResponse() {
        this.context = "";
        this.origin = "";
        this.action = "";
        this.entityIndex = -1;
    }

    @Override
    public String toString() {
        return "TokenViewResponse{" + "context=" + context + ", origin=" + origin + ", action=" + action + ", entityIndex=" + entityIndex + '}';
    }
    
    public TokenViewResponse(String context) {
        this.context = context;
        this.origin = "";
        this.action = "";
        this.entityIndex = -1;
    }
    
    public TokenViewResponse(String context, String origin, String action, Integer entityIndex) {
        this.context = context;
        this.origin = origin;
        this.action = action;
        this.entityIndex = entityIndex;
    }

    public String getContext() {
        return context;
    }

    public String getOrigin() {
        return origin;
    }

    public String getAction() {
        return action;
    }

    public Integer getEntityIndex() {
        return entityIndex;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setEntityIndex(Integer entityIndex) {
        this.entityIndex = entityIndex;
    }
    
    
    
}
