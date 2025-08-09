
package controller.modelController;

import controller.globals.Contexts;
import controller.globals.Origins;

/**
 *
 * @author Sterbenxy13
 */
public class TokenModelResponse {
    private String title;
    private String context;
    private String origin;

    public TokenModelResponse() {
        this.title = "NULL";
        this.context = Contexts.NONE;
        this.origin = Origins.NONE;
    }

    public TokenModelResponse(String title, String context, String origin) {
        this.title = title;
        this.context = context;
        this.origin = origin;
    }

    public String getTitle() {
        return title;
    }

    public String getContext() {
        return context;
    }

    public String getOrigin() {
        return origin;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "TokenModelResponse{" + "title=" + title + ", context=" + context + ", origin=" + origin + '}';
    }
    
    
    
    
    
}
