
package controller.viewController;

/**
 *
 * @author Sterbenxy13
 */
public class TokenViewLoading {
    
    private String origin;
    private String action;
    
    public TokenViewLoading() {
        this.origin = "";
        this.action = "";
    }
    
    public TokenViewLoading(String origin) {
        this.origin = origin;
        this.action = "";
    }
    
    public TokenViewLoading(String origin, String action) {
        this.origin = origin;
        this.action = action;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getAction() {
        return this.action;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setAction(String action) {
        this.action = action;
    }
    
    public boolean haveAction() {
        return !this.action.equals("");
    }
    
    
    
    
}
