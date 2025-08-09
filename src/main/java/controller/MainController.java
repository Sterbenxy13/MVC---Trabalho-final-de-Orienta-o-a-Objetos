
package controller;

import controller.modelController.ModelController;
import controller.exceptions.InvalidActionException;
import controller.exceptions.InvalidContextException;
import controller.globals.Contexts;
import controller.globals.Origins;
import controller.modelController.TokenModelResponse;
import controller.viewController.EntityData;
import controller.viewController.ViewController;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
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
                
                System.out.println(viewResponse.toString());
                
                TokenModelResponse modelResponse = instructModel(viewResponse);
                
                viewInstruction = generateViewToken(modelResponse);
                
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
        TokenModelResponse response = new TokenModelResponse();
        
        if (viewRequest.getContext().equals(Contexts.START)) {
            response.setTitle("Usuário");
            response.setContext(Contexts.MENU);
            response.setOrigin(Origins.USER);
            
            String[] cols = {"nome", "Gêneros Favoritos", "Livros Lidos"};
            List<EntityData> rows = new ArrayList<>();
            
            UserManager man = new UserManager();
            
            rows.addAll(man.getAllEntityData());
            
            TableData data = new TableData(cols, rows);
            
            response.setTableData(data);
        }
                
        
        return response;
//        return this.modelController.getResponse();
    }
    
    private TokenViewResponse instructView(TokenViewInstruction viewInstruction) {
        this.viewController.setView(viewInstruction);
        return this.viewController.getResponse();
    }
    
    private TokenViewInstruction generateViewToken(TokenModelResponse modelResponse) {
        TokenViewInstruction viewInstruction;
        if (modelResponse.getContext().equals(Contexts.MENU)) {
            viewInstruction = new TokenMenuInstruction();
            ((TokenMenuInstruction) viewInstruction).setTableData(modelResponse.getTableData());
            
        } else {
            viewInstruction = new TokenFormInstruction();
            ((TokenFormInstruction) viewInstruction).setEntityData(modelResponse.getEntityData());
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
