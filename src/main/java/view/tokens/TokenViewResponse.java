
package view.tokens;

import controller.globals.Actions;
import controller.globals.Route;
import controller.globals.Context;

/**
 *
 * @author Sterbenxy13
 */
public class TokenViewResponse {
    private String route;
    private String context;
    private String action;
    private Integer entityIndex;

    public TokenViewResponse() {
        this.route = Route.START;
        this.context = Context.NONE;
        this.action = Actions.NONE;
        this.entityIndex = -1;
    }

    @Override
    public String toString() {
        return "TokenViewResponse{" + "route=" + route + ", context=" + context + ", action=" + action + ", entityIndex=" + entityIndex + '}';
    }
    
    public TokenViewResponse(String context) {
        this.route = context;
        this.context = Context.NONE;
        this.action = Actions.NONE;
        this.entityIndex = -1;
    }
    
    public TokenViewResponse(String context, String origin, String action, Integer entityIndex) {
        this.route = context;
        this.context = origin;
        this.action = action;
        this.entityIndex = entityIndex;
    }

    public String getRoute() {
        return route;
    }

    public String getContext() {
        return context;
    }

    public String getAction() {
        return action;
    }

    public Integer getEntityIndex() {
        return entityIndex;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setEntityIndex(Integer entityIndex) {
        this.entityIndex = entityIndex;
    }
    
    
    
}
