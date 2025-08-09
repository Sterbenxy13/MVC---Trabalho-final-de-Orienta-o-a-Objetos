
package view.tokens;

/**
 *
 * @author Sterbenxy13
 */
public class TokenViewInstruction {
    private String title;
    private String context;
    private String origin;
    
    public TokenViewInstruction() {
        this.title = "NULL";
        this.context = "START";
        this.origin = "NULL";
    }
    
    public TokenViewInstruction(String context) {
        this.title = "NULL";
        this.context = "EXIT";
        this.origin = "NULL";
    }
    
    public TokenViewInstruction(String title, String context, String origin) {
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
        return "TokenViewInstruction{" + "title=" + title + ", context=" + context + ", origin=" + origin + '}';
    }
    
    
    
    
    
}
