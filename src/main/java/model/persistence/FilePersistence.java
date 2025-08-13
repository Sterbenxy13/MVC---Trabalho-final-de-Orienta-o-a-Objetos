package model.persistence;


/**
 *
 * @author Sterbenxy13
 */
public class FilePersistence {

    public static void saveOnFile(String texto, String filePath) {        
        java.io.FileWriter file;
        try {
            file = new java.io.FileWriter(filePath);
            
        } catch (Exception e) {
            System.out.println("Nao foi possivel escrever no arquivo:\n" + e.getMessage());
            return;
        }
        
        java.io.PrintWriter escritor = new java.io.PrintWriter(file);
        
        escritor.print(texto);
        
        try {
            file.close();
        } catch (Exception e) {
            System.out.println("Falha ao fechar arquivo");
        }
    }
    
    public static String loadFromFile(String filePath) {        
        java.lang.StringBuilder result = new StringBuilder();
        
        java.io.FileReader file;        
        try {
            file = new java.io.FileReader(filePath);
        } catch(java.io.FileNotFoundException e) {
            System.out.println("Nao foi possivel ler o arquivo:\n " + e.getMessage());
            return "";
        }
        
        java.util.Scanner leitor = new java.util.Scanner(file);
        leitor.useDelimiter("\n");
        while (leitor.hasNext()) {
            result.append(leitor.next() + "\n");
        }
        
        try {
            file.close();
        } catch (Exception e) {
            System.out.println("Falha ao fechar arquivo");
        }
        
        return result.toString();
    }
    
}
