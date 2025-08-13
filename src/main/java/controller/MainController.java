
package controller;

import controller.modelController.ModelController;
import controller.exceptions.InvalidActionException;
import controller.exceptions.InvalidContextException;
import controller.globals.Actions;
import controller.globals.Route;
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


        // começa em START
        TokenViewInstruction viewInstruction = new TokenViewInstruction();
    
        this.viewController.init();
        
        TokenViewResponse viewResponse;
        while(true) {
            try {
                viewResponse = this.instructView(viewInstruction);
                
                if (viewResponse.getRoute().equals(Route.EXIT)) {
                    this.exitProgram();
                    return;
                }
                
                Logger.log("MainController.init() -> viewResponse.getOrigin(): " + viewResponse.getContext());
                
                if (viewResponse.getAction().equals(Actions.NONE)) {
                    TableData menuData = this.manageMenuRequest(viewResponse.getContext());
                    viewInstruction = new TokenMenuInstruction(viewInstruction);
                    ((TokenMenuInstruction) viewInstruction).setTableData(menuData);
                    continue;
                    
                } else {
                    EntityData formData = this.manageFormRequest(viewResponse.getContext(), viewResponse.getEntityIndex());
                    viewInstruction = new TokenFormInstruction(viewInstruction);
                    ((TokenFormInstruction) viewInstruction).setEntityData(formData);
                    continue;
                }
                
//                System.out.println("OXI SAIU DO SWITCH EM MainController.init()");
//                
//                
//                
//                if (viewResponse.getContext().equals(Route.EXIT)) {
//                    this.exitProgram();
//                    return;
//                }
//                String lastContext = viewResponse.getContext();
//                
//                
//                
//                TokenModelResponse modelResponse = instructModel(viewResponse);
//                viewInstruction = generateViewToken(modelResponse);
//                
//                viewResponse = this.instructView(viewInstruction);
//                
//                if (viewResponse.getContext().equals(Route.EXIT)) {
//                    this.exitProgram();
//                    return;
//                }                
//                
//                if (viewResponse.getAction().equals(Actions.BACK)) {
//                    viewInstruction.setContext(lastContext);
//                }
//                
//                
//                
//                Logger.log("MainController.init(): " + viewInstruction.toString());
//                
//                continue;
//                
                
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
    
    private TokenViewInstruction manageStartRequest() {
        return new TokenViewInstruction();
    }
    
    private TableData manageMenuRequest(String origin) {
        // abre menu 
        // view -> (MENU, origin) : model -> (MENU, origin, Tdata) (Tdata)
        return this.modelController.getTableData(origin);
        
//        ((TokenMenuInstruction) viewInstruction).setTableData(menuData);
//        
//        return viewInstruction;
    }
    
    private EntityData manageFormRequest(String origin, Integer entityId) {
        return this.modelController.getEntityData(origin, entityId);
    }
    
    private TokenModelResponse instructModel(TokenViewResponse viewRequest) {
        
        TokenModelResponse response = this.modelController.getResponse(viewRequest);
        
//        if (viewRequest.getContext().equals(Route.START)) {
//            response.setTitle("Usuário");
//            response.setContext(Route.MENU);
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
                
        if (modelResponse.getContext().equals(Route.MENU)) {
            viewInstruction = new TokenMenuInstruction();
            TableData data = ((TokenModelMenuResponse) modelResponse).getTableData();
            ((TokenMenuInstruction) viewInstruction).setTableData(data);
            
        } else if (modelResponse.getContext().equals(Route.FORM)) {
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
