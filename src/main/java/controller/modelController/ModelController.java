
package controller.modelController;

import controller.BookManager;
import controller.UserManager;
import controller.globals.Contexts;
import controller.globals.Origins;
import controller.modelController.entityController.AbstractEntityController;
import logger.Logger;
import model.entity.Book;
import model.entity.User;
import model.persistence.FilePersistence;
import model.persistence.JSONService;
import view.tokens.TokenViewResponse;

/**
 *
 * @author Sterbenxy13
 */
public class ModelController {
    private final String jsonFilePath = "src/main/java/domain/data/";
    
    public ModelController() {
        
    }

    public TokenModelResponse getResponse(TokenViewResponse viewRequest) {
        
        TokenModelResponse response = this.createToken(viewRequest);
        
        response = this.manageContext(response);
        
//        if (viewRequest.getContext().equals(Contexts.START)) {;
//            
//            return response;
//        } else {
//            response = new TokenModelResponse();
//        }
        
        Logger.log("ModelController.getResponse(): " + response.toString());
        
        return response;
    }
    
    private TokenModelResponse createToken(TokenViewResponse viewRequest) {
        TokenModelResponse newToken = new TokenModelResponse();
        newToken.setContext(viewRequest.getContext());
        newToken.setOrigin(viewRequest.getOrigin());
        return newToken;
    }
    
    private TokenModelResponse manageContext(TokenModelResponse modelToken) {
        TokenModelResponse response;
        
        switch (modelToken.getContext()) {
            case Contexts.START:
                response = new TokenModelMenuResponse();
                response.setContext(Contexts.MENU);
                response.setOrigin(modelToken.getOrigin());
                
                response = this.manageOrigin(response);
                
                Logger.log("ModelController.manageContext(): " + response.toString());
                
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
            case Origins.USER:
                loadedFile = FilePersistence.loadFromFile(this.jsonFilePath + "users.json");
                json = new JSONService(User.class);
                entityController = new UserManager(json.fromJson(loadedFile));
                break;
            case Origins.BOOK:
                loadedFile = FilePersistence.loadFromFile(this.jsonFilePath + "books.json");
                json = new JSONService(Book.class);
                entityController = new BookManager(json.fromJson(loadedFile));
                break;
        
            default:
                throw new RuntimeException("ORIGIN INVÁLIDA");
        }
        
        modelToken.setTitle(entityController.getClassTitle());
        
        if (modelToken.getContext().equals(Contexts.MENU)) {
            ((TokenModelMenuResponse) modelToken).setTableData(entityController.getTableData());
            Logger.log("ModelController.manageOrigin(): " + entityController.getTableData().toString());
        } else {
            ((TokenModelFormResponse) modelToken).setEntityData(entityController.getEntityDataById(0));
        }
        
        
        return modelToken;
    }
    
    
    
}
