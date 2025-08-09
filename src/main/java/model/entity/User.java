
package model.entity;

import java.lang.reflect.Field;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import logger.Logger;

/**
 *
 * @author Sterbenxy13
 */
public class User implements IEntity{
    private String name;
    private java.util.List<String> favoriteGenres;
    private java.util.List<model.entity.Book> readedBooks;

    public User() {}
    
    public User(String name, List<String> favoriteGenres, List<Book> readedBooks) {
        this.name = name;
        this.favoriteGenres = favoriteGenres;
        this.readedBooks = readedBooks;
    }

    public String getName() {
        return name;
    }

    public List<String> getFavoriteGenres() {
        return favoriteGenres;
    }

    public List<Book> getReadedBooks() {
        return readedBooks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFavoriteGenres(List<String> favoriteGenres) {
        this.favoriteGenres = favoriteGenres;
    }

    public void setReadedBooks(List<Book> readedBooks) {
        this.readedBooks = readedBooks;
    }
    
    
    
    public void edit(String jsonData) {
//        User temp = model.persistence.JSONService.fromJson(jsonData, User.class).get(0);
//        this.name = temp.getName();
//        this.favoriteGenres = temp.getFavoriteGenres();
//        this.readedBooks = temp.getReadedBooks();
    }
    
    public void addFavoriteGenre(String genre) {
        this.favoriteGenres.add(genre);
    }
    
    public void removeFavoriteGenre(String genre) {
        int index = 0;
        for (String g: this.favoriteGenres) {
            if (g.equals(genre)) {
                break;
            }
            index ++;
        }        
        this.favoriteGenres.remove(index);
    }
    
    public void addReadedBook(model.entity.Book book, Integer grade) {
        if (grade < 0 || grade > 5) {
            return;
        }
        this.readedBooks.add(book);
        book.addGrade(grade);        
    }

    public String getFormattedData(int index) {
        return "--------User: " + index + "-----\n"
                + "name: " + name  + '\n'
                + ", favoriteGenres: " + favoriteGenres  + "\n"
                + ", readedBooks: " + readedBooks + "\n"
                + "------------------\n";
    }

    @Override
    public Object getValueInReference(String fieldName) {
        switch (fieldName) {
            case "name": 
                return this.name;
            case "favoriteGenres":
                return this.favoriteGenres;
            case "readedBooks":
                return this.readedBooks;
        }
        return this;
    }
    
    @Override
    public String[] getFieldsNames() {
        Field[] fields = this.getClass().getDeclaredFields();        
        String[] fieldsNames = new String[fields.length];
        
        int i = 0;
        for (Field f: fields) {
            fieldsNames[i] = f.getName();
            i++;
        }
        
        return fieldsNames;
    }
    
    @Override 
    public Dictionary<String, Object> getFields() {
        Dictionary<String, Object> fields = new Hashtable<>();
        
        String[] fieldsNames = this.getFieldsNames();
        
        for (String fname: fieldsNames) {
            Logger.log("User.getFields() -> fieldName: " + fname);
            fields.put(fname, this.getValueInReference(fname));
        }
        
        return fields;
        
    }
    
    
    
    
    
}
