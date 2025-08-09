
package controller.viewController;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import model.entity.IEntity;

/**
 *
 * @author Sterbenxy13
 */
public class EntityData<E extends IEntity> {
    private Dictionary<String, Object> data;
    private Integer entityIndex;
    private java.lang.Class<E> entityClass;
    
    public EntityData() {
        this.data = new Hashtable<>();
        this.entityIndex = -1;
    }
    
    public EntityData(Dictionary<String, Object> data) {
        this.data = data;
    }
    
    public void put(String identifier, Object attr) {
        this.data.put(identifier, attr);
    }
    
    public Object get(String identifier) throws IndexOutOfBoundsException{
        if (this.contains(identifier) == false) {
//            throws new IndexOutOfBoundsException();
        }
        return this.data.get(identifier);
    }
    
    public String[] getLabels() {
        String[] result = new String[this.data.size()];
        Enumeration<String> keys = this.data.keys();
        
        int i = 0;
        while (keys.hasMoreElements()) {
            result[i] = keys.nextElement();
            i ++;
        }
        return result;
    }
    
    public Integer getIndex() {
        return this.entityIndex;
    }
    
    public Dictionary<String, Object> getData() {
        return this.data;
    }
    
    private boolean contains(String identifier) {
        return this.data.get(identifier) != null;
    }
}
