
package controller.modelController;

import controller.BookManager;
import controller.UserManager;
import controller.globals.Route;
import controller.globals.Context;
import controller.modelController.entityController.AbstractEntityController;
import controller.viewController.EntityData;
import java.lang.reflect.InvocationTargetException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.logging.Level;
import logger.Logger;
import model.entity.Book;
import model.entity.IEntity;
import model.entity.User;
import model.persistence.FilePersistence;
import model.persistence.JSONService;
import view.components.tableModel.TableData;
import view.tokens.TokenViewResponse;

/**
 *
 * @author Sterbenxy13
 */
public class ModelController {
    private final String jsonFilePath = "src/main/java/domain/data/";
    private final Dictionary<String, EntityUtilities> entityControllers;
    
    public ModelController() {
        this.entityControllers = new Hashtable<>();
        this.init();
    }
    
    private void init() {
        
        this.entityControllers.put(Context.USER, 
                new EntityUtilities("users.json", User.class, UserManager.class)
        );
        
        this.entityControllers.put(Context.BOOK,
                new EntityUtilities("books.json", Book.class, BookManager.class)
        );
        
    }
    
    public TableData getTableData(String origin) {
        AbstractEntityController entityController = this.getController(origin);
        
        return entityController.getTableData();
        
//        switch (origin) {
//            case Context.USER -> {
//                loadedFile = FilePersistence.loadFromFile(this.jsonFilePath + "users.json");
//                json = new JSONService(User.class);
//                entityController = new UserManager(json.fromJson(loadedFile));
//            }
//            case Context.BOOK -> {
//                loadedFile = FilePersistence.loadFromFile(this.jsonFilePath + "books.json");
//                json = new JSONService(Book.class);
//                entityController = new BookManager(json.fromJson(loadedFile));
//            }
//        
//        }
    }
    
    public EntityData getEntityData(String origin, Integer id) {
        AbstractEntityController entityController = this.getController(origin);
        
        return entityController.getEntityDataById(id);
    }
    
    public String getOriginTitle(String origin) {
        return "NONETITLE";
    }

    private AbstractEntityController getController(String origin) {
        EntityUtilities entityUtils = this.entityControllers.get(origin);
        
        String loadedFile = FilePersistence.loadFromFile(this.jsonFilePath + entityUtils.getFileName());
        
        JSONService json = new JSONService(entityUtils.getEntityClass());
        List<IEntity> entities = json.fromJson(loadedFile);
        
        AbstractEntityController entityController;
        try {
            entityController = (AbstractEntityController) entityUtils.getControllerConstructor().newInstance(entities);
        } catch (
                InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException
                ex) {
            String errorMessage = "Houve um erro ao instanciar a EntityController em ModelController.getTableData()";
            java.util.logging.Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, errorMessage, ex);
            throw new RuntimeException("ORIGIN INVÁLIDA");
        }
        
        return entityController;
    }
    
    public TokenModelResponse getResponse(TokenViewResponse viewRequest) {
        
        TokenModelResponse response = this.createToken(viewRequest);
        
        response = this.manageContext(response);
        
//        if (viewRequest.getContext().equals(Route.START)) {;
//            
//            return response;
//        } else {
//            response = new TokenModelResponse();
//        }
        
//        Logger.log("ModelController.getResponse(): " + response.toString());
        
        return response;
    }
    
    private TokenModelResponse createToken(TokenViewResponse viewRequest) {
        TokenModelResponse newToken = new TokenModelResponse();
        newToken.setContext(viewRequest.getRoute());
        newToken.setOrigin(viewRequest.getContext());
        return newToken;
    }
    
    private TokenModelResponse manageContext(TokenModelResponse modelToken) {
        TokenModelResponse response;
        
        switch (modelToken.getContext()) {
            case Route.START:
                response = new TokenModelMenuResponse();
                response.setContext(Route.MENU);
                response.setOrigin(modelToken.getOrigin());
                
                response = this.manageOrigin(response);
                
//                Logger.log("ModelController.manageContext(): " + response.toString());
                
                return response;
                
            default:
                
        }
        
        
        
        response = new TokenModelResponse();
        
        
        return response;        
    }
    
    private TokenModelResponse manageOrigin(TokenModelResponse modelToken) {
        AbstractEntityController entityController;
        String loadedFile = "";
        JSONService json;
        
        switch (modelToken.getOrigin()) {
            case Context.USER:
                loadedFile = FilePersistence.loadFromFile(this.jsonFilePath + "users.json");
                json = new JSONService(User.class);
                entityController = new UserManager(json.fromJson(loadedFile));
                break;
            case Context.BOOK:
                loadedFile = FilePersistence.loadFromFile(this.jsonFilePath + "books.json");
                json = new JSONService(Book.class);
                entityController = new BookManager(json.fromJson(loadedFile));
                break;
        
            default:
                throw new RuntimeException("ORIGIN INVÁLIDA");
        }
        
        modelToken.setTitle(entityController.getClassTitle());
        
        if (modelToken.getContext().equals(Route.MENU)) {
            ((TokenModelMenuResponse) modelToken).setTableData(entityController.getTableData());
//            Logger.log("ModelController.manageOrigin(): " + entityController.getTableData().toString());
        } else {
            ((TokenModelFormResponse) modelToken).setEntityData(entityController.getEntityDataById(0));
        }
        
        
        return modelToken;
    }
    
    
    
}
