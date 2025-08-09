
package model.persistence;

/**
 *
 * @author Sterbenxy13
 */
public class JSONService {
    
    public static<T> String toJson(java.util.List<T> objs) {
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
    
    public static<T> java.util.List<T> fromJson(String jsonString, java.lang.Class<T> cls) {
        java.util.List<T> result = new java.util.ArrayList<>();
        if (jsonString.equals("")) {
            return result;
        }
        try {
            com.fasterxml.jackson.databind.ObjectMapper mapper = 
            new com.fasterxml.jackson.databind.ObjectMapper();
            
            com.fasterxml.jackson.core.type.TypeReference<T> type = 
                    new com.fasterxml.jackson.core.type.TypeReference<T>() {};

            com.fasterxml.jackson.databind.JavaType javaType;
            javaType = mapper.getTypeFactory().constructParametricType(
                    java.util.List.class, cls
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
