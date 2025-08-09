
package controller;

import controller.modelController.ModelController;
import controller.exceptions.InvalidActionException;
import controller.exceptions.InvalidContextException;
import controller.globals.Contexts;
import controller.modelController.TokenModelFormResponse;
import controller.modelController.TokenModelMenuResponse;
import controller.modelController.TokenModelResponse;
import controller.viewController.EntityData;
import controller.viewController.ViewController;
import logger.Logger;
import view.components.tableModel.TableData;
import view.tokens.TokenFormInstruction;
import view.tokens.TokenMenuInstruction;
import view.tokens.TokenViewInstruction;
import view.tokens.TokenViewResponse;

/**
 *
 * @author Sterbenxy13
 */
public class MainController {
    
    private ViewController viewController;
    private ModelController modelController;
        
    public MainController() {
        this.viewController = new ViewController();
        this.modelController = new ModelController();
        
        
    }
    
    public void init() {
//        TokenFrameResponse viewToken = this.viewController.getResponse();

        Logger.setEnable(true);

        TokenViewInstruction viewInstruction = new TokenViewInstruction();
    
        this.viewController.init();
        
        TokenViewResponse viewResponse;
        while(true) {
            try {
                viewResponse = this.instructView(viewInstruction);
                
                if (viewResponse.getContext().equals(Contexts.EXIT)) {
                    this.exitProgram();
                    return;
                }
                
                
                TokenModelResponse modelResponse = instructModel(viewResponse);
                
                viewInstruction = generateViewToken(modelResponse);
                
                Logger.log("MainController.init(): " + viewInstruction.toString());
                
                continue;
                
                
            } catch (InvalidActionException | InvalidContextException ex) {
                this.exitProgram();
            }

            
            
            
            
            
        }
//        TokenViewLoading startToken = new TokenViewLoading("");
//        
//        TokenFrameResponse viewToken = viewController.getResponse(startToken);
//        
//        System.out.println("viewToken.action: " + viewToken.getAction());
//        
//        if (viewToken.getAction().equals("EXIT")) {
//            return;
//        }

    }
    
    private TokenModelResponse instructModel(TokenViewResponse viewRequest) {
        
        TokenModelResponse response = this.modelController.getResponse(viewRequest);
        
//        if (viewRequest.getContext().equals(Contexts.START)) {
//            response.setTitle("Usuário");
//            response.setContext(Contexts.MENU);
//            response.setOrigin(Origins.USER);
//            
//            String[] cols = {"nome", "Gêneros Favoritos", "Livros Lidos"};
//            List<EntityData> rows = new ArrayList<>();
//            
//            UserManager man = new UserManager();
//            
//            rows.addAll(man.getAllEntityData());
//            
//            TableData data = new TableData(cols, rows);
//            
//            response.setTableData(data);
//        }
                
        
        return response;
    }
    
    private TokenViewResponse instructView(TokenViewInstruction viewInstruction) {
        this.viewController.setView(viewInstruction);
        return this.viewController.getResponse();
    }
    
    private TokenViewInstruction generateViewToken(TokenModelResponse modelResponse) {
        TokenViewInstruction viewInstruction;
                
        if (modelResponse.getContext().equals(Contexts.MENU)) {
            viewInstruction = new TokenMenuInstruction();
            TableData data = ((TokenModelMenuResponse) modelResponse).getTableData();
            ((TokenMenuInstruction) viewInstruction).setTableData(data);
            
        } else if (modelResponse.getContext().equals(Contexts.FORM)) {
            viewInstruction = new TokenFormInstruction();
            EntityData data = ((TokenModelFormResponse) modelResponse).getEntityData();
            String action = ((TokenModelFormResponse) modelResponse).getAction();
            ((TokenFormInstruction) viewInstruction).setEntityData(data);
            ((TokenFormInstruction) viewInstruction).setAction(action);
        } else {
            viewInstruction = new TokenViewInstruction();
        }
        
        viewInstruction.setTitle(modelResponse.getTitle());
        viewInstruction.setContext(modelResponse.getContext());
        viewInstruction.setOrigin(modelResponse.getOrigin());
        
        
        
        return viewInstruction;
    }


    
    private void transition() {
        
    }
    
    private void exitProgram() {
        TokenViewInstruction exitInstruction = new TokenViewInstruction("EXIT");
        this.instructView(exitInstruction);
    }
    
}
