
import controller.MainController;


/**
 *
 * @author Sterbenxy13
 */
public class ProjetoFinal {

    public static void main(String[] args) {
        
        // Este programa requer a dependência do jackson:
        /*
        
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-core</artifactId>
            <version>2.12.3</version>
        </dependency>

        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.12.3</version>
        </dependency>
        
        */
        
        MainController mainController = new MainController();
        mainController.init();
        
        return;
        
//        view.FrMain window = new view.FrMain();;
//        window.setVisible(true);
        
        
    }
}
