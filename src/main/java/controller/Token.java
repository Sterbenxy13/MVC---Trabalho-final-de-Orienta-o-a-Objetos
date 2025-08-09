
package controller;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * token padrão para comunicação entre as camadas. Usado para as ações de 
 * adicionar, editar e remover<br>
 * 
 * <code>action</code>: refere à ação que está acontecendo.<br>
 * <code>index</code>: refere ao indice da entidade que está sendo modificada.<br>
 * <code>data</code>: refere ao pacote de dados que está sendo transmitido. <br>
 * @author Sterbenxy13
 */
public class Token {
    private String action;
    private Integer index;
    private Dictionary<String, String> data;
    
    public Token() {
        this.action = "null";
        this.index = -1;
        this.data = new Hashtable<>();
    }
    
    public Token(String action) {
        this.action = action;
        this.index = -1;
        this.data = new Hashtable<>();
    }
    
    public Token(String action, Integer index) {
        this.action = action;
        this.index = index;
        this.data = new Hashtable<>();
    }
    
    public Token(String action, Integer index, Dictionary data) {
        this.action = action;
        this.index = index;
        this.data = data;
    }
    
    public void setAction(String action) {
        this.action = action;
    }
    
    public void setIndex(Integer index) {
        this.index = index;
    }
    
    public void addDataValue(String key, String value) {
        this.data.put(key, value);
    }

    @Override
    public String toString() {
        return "Token{" + "action=" + action + ", index=" + index + ", data=" + data + '}';
    }
    
    
    
    
}
