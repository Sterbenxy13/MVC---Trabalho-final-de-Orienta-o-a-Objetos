
package controller;

import controller.viewController.EntityData;
import java.util.List;


/**
 *
 * @author Sterbenxy13
 */
public interface IEntityController {
    void init();
    void register(String jsonData);
    void remove(int index);
    void edit(int index, String jsonData);
    Integer getSize();
    String getJsonData(int index);
    String getFormattedData();
    String getFormattedData(int index);
    
    List<EntityData> getAllEntityData();
    EntityData getEntityData(Integer id);
    
    boolean isEmpty();
    java.util.List getEntities();
}
