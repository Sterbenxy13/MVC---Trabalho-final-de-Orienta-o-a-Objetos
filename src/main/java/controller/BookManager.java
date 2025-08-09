
package controller;

import controller.viewController.EntityData;
import java.util.ArrayList;
import java.util.List;
import model.entity.Book;

/**
 *
 * @author Sterbenxy13
 */
public class BookManager implements IEntityController {
    private final String dataPath = "src/main/java/domain/data/books.json";
    private final java.util.List<model.entity.Book> books
            = new java.util.ArrayList<>();

    public BookManager() {
        init();
    }
    
    @Override
    public boolean isEmpty() {
        return this.books.isEmpty();
    }
    
    @Override
    public List<model.entity.Book> getEntities() {
        return this.books;
    }

    @Override
    public void init() {
        books.clear();
        loadData();
    }

    @Override
    public void register(String jsonData) {
        books.add(
                (model.entity.Book) model.persistence.JSONService.fromJson(jsonData, model.entity.Book.class)
        );
        saveData();
    }
    
    public void register(
            String title, 
            java.util.List<model.entity.Author> authors,
            Integer publishYear,
            java.util.List<String> genres
            
    ) {
        books.add(new model.entity.Book(title, authors, publishYear, genres));
        saveData();
    }
    
    public void addGrade(int bookIndex, int grade) {
        books.get(bookIndex).addGrade(grade);
        saveData();
    }
    
    public java.util.List<model.entity.Book> getRecommendedBooks(int userIndex) {
        controller.UserManager userManager = new controller.UserManager();
        model.entity.User user = userManager.getUser(userIndex);
        
        java.util.List<model.entity.Book> recommendedBooks
                = new java.util.ArrayList<>();
        
        for (model.entity.Book b: books) {
            if (b.getGrade() < 3.5) {
                continue;
            }
            boolean equal = false;
            for (model.entity.Book ub: userManager.getReadedBooks(userIndex)) {
                if (ub.getTitle().equals(b.getTitle())) {
                    equal = true;
                    break;
                }
            }
            if (equal) {
                continue;
            }
            for (String g: b.getGenres()) {
                if (user.getFavoriteGenres().contains(g)) {
                    recommendedBooks.add(b);
                    break;
                }
            }
        }
        return recommendedBooks;        
    }
    
    public java.util.List<model.entity.Book> searchBookByTitle(String title) {
        java.util.List<model.entity.Book> result = new java.util.ArrayList<>(books.size());
        int index = 0;
        for (model.entity.Book b: books) {
            index ++;
            if (b.getTitle().contains(title)) {
                    result.add(b);
            } else {
                result.add(null);
            }
        }
        return result;
    }
    
    public java.util.List<model.entity.Book> searchBookByAuthor(String authorName) {
        java.util.List<model.entity.Book> result = new java.util.ArrayList<>(books.size());
        int index = 0;
        boolean added = false;
        for (model.entity.Book b: books) {
            index ++;
            added = false;
            for (model.entity.Author a: b.getAuthors()) {
                if (a.getName().contains(authorName)) {
                    result.add(b);
                    added = true;
                    break;
                }
            }
            if (!added) {
                result.add(null);
            }
        }
        return result;
    }
    
    public java.util.List<model.entity.Book> searchBookByGenre(String genre) {
        java.util.List<model.entity.Book> result = new java.util.ArrayList<>(books.size());
        int index = 0;
        boolean added = false;
        for (model.entity.Book b: books) {
            index ++;
            added = false;
            for (String g: b.getGenres()) {
                if (g.contains(genre)) {
                    result.add(b);
                    added = true;
                    break;
                }
            }
            if (!added) {
                result.add(null);
            }
        }
        return result;
    }
        

    @Override
    public void remove(int index) {
        books.remove(index);
        saveData();
    }

    @Override
    public void edit(int index, String jsonData) {
        java.util.List<model.entity.Book> temp 
                = model.persistence.JSONService.fromJson(jsonData, model.entity.Book.class);
        books.get(index).edit(
                model.persistence.JSONService.toJson(temp)
        );
        saveData();
    }

    @Override
    public Integer getSize() {
        return books.size();
    }
    
    @Override
    public String getJsonData(int index) {
        java.util.List<model.entity.Book> temp = new java.util.ArrayList<>();
        temp.add(books.get(index));
        return model.persistence.JSONService.toJson(temp);
    }

    @Override
    public String getFormattedData() {
        java.lang.StringBuilder result = new java.lang.StringBuilder();
        int index = 0;
        for (model.entity.Book b: books) {
            result.append(b.getFormattedData(index));
            index ++;
        }
        return result.toString();
    }
    
    @Override
    public String getFormattedData(int index) {
        return books.get(index).getFormattedData(index);
    }
    
    private void saveData() {
        model.persistence.FilePersistence.saveOnFile(
                model.persistence.JSONService.toJson(books),
                dataPath
        );
    }
    
    private void loadData() {
        for (model.entity.Book b: model.persistence.JSONService.fromJson(
                model.persistence.FilePersistence.loadFromFile(dataPath),
                model.entity.Book.class 
            )
        ) {
            books.add(b);
        }
    }
    
    @Override
    public EntityData getEntityData(Integer id) {
        return new EntityData(this.books.get(id).getFields());
    }
    
    @Override
    public List<EntityData> getAllEntityData() {
        List<EntityData> entitiesData = new ArrayList<>();
        int i = 0;
        for (Book u: this.books) {
            entitiesData.add(new EntityData(u.getFields()));
            i++;
        }
        
        return entitiesData;        
    }
    
    
}
