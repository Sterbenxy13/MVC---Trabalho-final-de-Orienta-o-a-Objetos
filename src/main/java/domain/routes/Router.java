
package domain.routes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sterbenxy13
 */
public class Router {
    
    private List<Route> routes;
    
    public Router() {
        
    }
    
    public Route getRoute() {
        return new Route();
    }
    
    private void init() {
        this.routes = new ArrayList<>();
        
        this.routes.add(new Route());
        
        
    }
     
}
