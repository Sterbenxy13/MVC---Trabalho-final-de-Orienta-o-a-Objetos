
package model.persistence;

import model.entity.IEntity;

/**
 *
 * @author Sterbenxy13
 */
public class JSONService<E extends IEntity> {
    private java.lang.Class<E> entityClass;
    
    public JSONService(java.lang.Class<E> entityClass) {
        this.entityClass = entityClass;
    }
    
    public String toJson(java.util.List<E> objs) {
        String result = "";
        try {
            com.fasterxml.jackson.databind.ObjectMapper mapper = 
                new com.fasterxml.jackson.databind.ObjectMapper();
            
        
            result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objs);
            
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
    
    public java.util.List<E> fromJson(String jsonString) {
        java.util.List<E> result = new java.util.ArrayList<>();
        if (jsonString.equals("")) {
            return result;
        }
        try {
            com.fasterxml.jackson.databind.ObjectMapper mapper = 
            new com.fasterxml.jackson.databind.ObjectMapper();
            
            com.fasterxml.jackson.core.type.TypeReference<E> type = 
                    new com.fasterxml.jackson.core.type.TypeReference<E>() {};

            com.fasterxml.jackson.databind.JavaType javaType;
            javaType = mapper.getTypeFactory().constructParametricType(
                    java.util.List.class, this.entityClass
            );
            
            result = mapper.readValue(
                    jsonString,
                    javaType
            );
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
}
