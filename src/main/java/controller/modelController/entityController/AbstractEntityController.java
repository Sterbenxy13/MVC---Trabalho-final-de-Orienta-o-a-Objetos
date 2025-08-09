
package controller.modelController.entityController;

import controller.viewController.EntityData;
import java.util.List;
import logger.Logger;
import model.entity.IEntity;
import model.serializer.SerializerEntityData;
import model.serializer.SerializerTableData;
import view.components.tableModel.TableData;

/**
 *
 * @author Sterbenxy13
 */
public abstract class AbstractEntityController {
    protected final List<IEntity> entityList;
    protected final String classTitle;
    
    public AbstractEntityController(List<IEntity> entityList, String classTitle) {
        this.entityList = entityList;
        this.classTitle = classTitle;
    }
    
    public boolean isEmpty() {
        return this.entityList.isEmpty();
    }
    
    public List<IEntity> getEntityList() {
        return this.entityList;
    }
    
    public IEntity getEntityById(Integer id) {
        return this.entityList.get(id);
    }
    
    public TableData getTableData() {
        SerializerTableData serializer = new SerializerTableData();
        Logger.log("AbstractEntityController.getTableData() -> entityList: " + this.entityList.toString());
        TableData data = serializer.serialize(this.entityList);
        Logger.log("AbstractEntityController.getTableData() -> data: " + data.toString());
        return data;
    }
    
    public EntityData getEntityDataById(Integer id) {
        SerializerEntityData serializer = new SerializerEntityData();
        return serializer.serialize(this.entityList.get(id));
    }
    
    public String getClassTitle() {
        return this.classTitle;
    }
    
    public Integer getSize() {
        return this.entityList.size();
    }
    
    
    
    
}
