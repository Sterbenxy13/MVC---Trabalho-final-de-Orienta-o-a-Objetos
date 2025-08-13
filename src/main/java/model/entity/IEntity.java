
package model.entity;

import java.util.Dictionary;

/**
 *
 * @author Sterbenxy13
 */
public interface IEntity {
    /**
     * Retorna o valor referente ao nome do atributo. Como no exemplo:<br>
     ** <code>
     * IEntity b = new Book();<br>
     ** b.setTitle("O Pequeno Príncipe");<br>
     ** String titulo = b.getValueInReference("title");<br>
     * </code>
     * 
     * -> A variável `titulo` terá valor "O Pequeno Príncipe".
     * 
     * @param fieldName Nome do campo que deseja ser acessado.
     * @return 
     */
    Object getValueInReference(String fieldName);
    
//    String getClassTitle();
    
    String[] getFieldsNames();
    
    Dictionary<String, Object> getFields();
}
