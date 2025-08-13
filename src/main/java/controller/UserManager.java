
package controller;

import controller.modelController.entityController.AbstractEntityController;
import java.util.List;
import model.entity.IEntity;

/**
 *
 * @author Sterbenxy13
 */
public class UserManager extends AbstractEntityController {

    public UserManager(List<IEntity> entityList) {
        super(entityList, "Usuário");
    }
    
//    @Override
//    public void register(String JsonData) {
////        users.add(
////                (model.entity.User) model.persistence.JSONService.fromJson(JsonData, model.entity.User.class)
////        );
//        saveData();
//    }
    
//    public void register(String name, java.util.List<String> genres, java.util.List<model.entity.Book> readedBooks) {
//        users.add(new model.entity.User(name, genres, readedBooks)
//        );
//        saveData();
//    } 
    
//    public model.entity.User getUser(int index) {
//        return users.get(index);
//    }
    
//    public java.util.List<model.entity.Book> getReadedBooks(int userIndex) {
//        return users.get(userIndex).getReadedBooks();
//    }
//    
//    public void setReadedBooks(int userIndex, java.util.List<model.entity.Book> books) {
//        users.get(userIndex).setReadedBooks(books);
//        saveData();
//    }
//    
//    public void addReadedBook(int userIndex, model.entity.Book book, int grade) {
//        users.get(userIndex).addReadedBook(book, grade);
//        saveData();
//    }
    
//    @Override
//    public void remove(int index) {
//        users.remove(index);
//        saveData();
//    }
//    
//    @Override
//    public void edit(int index, String JsonData) {
//        users.get(index).edit(JsonData);
//        saveData();
//    }
//    
//    @Override
//    public Integer getSize() {
//        return users.size();
//    }
    
//    @Override
//    public String getJsonData(int index) {
//        java.util.List<model.entity.User> temp = new java.util.ArrayList<>();
////        temp.add(users.get(index));
////        return model.persistence.JSONService.toJson(temp);
//        return "";
//    }
    
//    @Override
//    public String getFormattedData() {
//        java.lang.StringBuilder result = new java.lang.StringBuilder();
//        int index = 0;
//        for (model.entity.User u: users) {
//            result.append(u.getFormattedData(index));
//            index ++;
//        }
//        return result.toString();
//    }
//    
//    @Override
//    public String getFormattedData(int index) {
//        return users.get(index).getFormattedData(index);
//    }
    
    private void saveData() {
//        model.persistence.FilePersistence.saveOnFile(
//                model.persistence.JSONService.toJson(users),
//                dataPath
//        );
    }
    
    private void loadData() {
//        for (model.entity.User u: model.persistence.JSONService.fromJson(model.persistence.FilePersistence.loadFromFile(dataPath),
//                model.entity.User.class 
//            )
//        ) {
//            users.add(u);
//        }
    }
    
}
