
package model.serializer;

import controller.viewController.EntityData;
import java.util.ArrayList;
import java.util.List;
import logger.Logger;
import model.entity.IEntity;
import view.components.tableModel.TableData;

/**
 *
 * @author Sterbenxy13
 */
public class SerializerTableData {
    
    public SerializerTableData() {
        
    }
    
    public TableData serialize(List<IEntity> entities) {
        if (entities.isEmpty()) {
            Logger.log("SerializerTableData.serialize(): " + "LISTA VAZIA");
            return new TableData();
        }
        
        List<EntityData> rows = new ArrayList<>();
        for (IEntity e: entities) {
            Logger.log("SerializerTableData.serialize() -> entity: " + e.toString());
            Logger.log("SerializerTableData.serialize() -> fields: " + e.getFields().toString());
            rows.add(new EntityData(e.getFields()));
        }
        
        return new TableData(entities.get(0).getFieldsNames(), rows);
    }
    
}
