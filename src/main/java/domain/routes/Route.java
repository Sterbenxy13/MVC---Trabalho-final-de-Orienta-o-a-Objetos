
package domain.routes;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 *
 * @author Sterbenxy13
 */
public class Route {
    
    private final String action;
    private final Dictionary<String, String> tokenToSend;
    private final Dictionary<String, String> tokenReceive;
    
    public Route() {
        this.action = "";
        this.tokenToSend = new Hashtable<>();
        this.tokenReceive = new Hashtable<>();
    }
    
    public Route(String action, Dictionary tokenSend, Dictionary tokenReceive) {
        this.action = action;
        this.tokenToSend = tokenSend;
        this.tokenReceive = tokenReceive;
    }
    
//    public addTokenToSend
    
    
    
}
