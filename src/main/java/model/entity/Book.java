
package model.entity;

import java.lang.reflect.Field;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import model.Evaluation;

/**
 *
 * @author Sterbenxy13
 */
public class Book implements IEntity {
    private String title;
    private java.util.List<model.entity.Author> authors;
    private Integer publishYear;
    private java.util.List<String> genres;
    private model.Evaluation evaluation;

    public Book() {
        this.title = "";
        this.authors = new java.util.ArrayList<>();
        this.publishYear = 0;
        this.genres =  new java.util.ArrayList<>();
        this.evaluation = new model.Evaluation();
    }
    
    public Book(String title, List<Author> authors, Integer publishYear, List<String> genres) {
        this.title = title;
        this.authors = authors;
        this.publishYear = publishYear;
        this.genres = genres;
        this.evaluation = new model.Evaluation();
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Integer getPublishYear() {
        return publishYear;
    }

    public List<String> getGenres() {
        return genres;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }
    
    @com.fasterxml.jackson.annotation.JsonIgnore
    public Double getGrade() {
        return evaluation.getGrade();
    }
    
    public void edit(String jsonData) {
//        Book temp = model.persistence.JSONService.fromJson(jsonData, Book.class).get(0);
//        this.title = temp.getTitle();
//        this.authors = temp.getAuthors();
//        this.publishYear = temp.getPublishYear();
//        this.genres = temp.getGenres();
//        this.evaluation = temp.getEvaluation();        
    }
    
    public void addGrade(Integer grade) {
        this.evaluation.addGrade(grade);
    }
    
    public void addAuthor(model.entity.Author author) {
        this.authors.add(author);
    }
    
    public void removeAuthor(model.entity.Author author) {
        int index = 0;
        for (model.entity.Author a: this.authors) {
            if (a.equals(author)) {
                break;
            }
            index ++;
        }
        this.authors.remove(index);
    }
    
    public String getFormattedData(int index) {
        return "--------Livro: " + index + "------\n"
                + "Título: " + title + "\n"
                + "Autores: " + authors + "\n"
                + "Ano de publicação: " + publishYear + "\n"
                + "Gêneros: " + genres + "\n"
                + "Nota: " + this.getGrade() + "\n"
                + "----------------\n";
    }

    @Override
    public String toString() {
        return "{título: " + title + ", autores: " + authors + ", ano de publicação: " + publishYear + ", gêneros: " + genres + ", nota: " + this.getGrade() + '}';
    }

    @Override
    public Object getValueInReference(String fieldName) {
        switch (fieldName) {
            case "title": 
                return this.title;
            case "authors":
                return this.authors;
            case "publishYear":
                return this.publishYear;
            case "genres": 
                return this.genres;
            case "evaluation": 
                return this.evaluation;
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
        
        for (String name: fieldsNames) {
            fields.put(name, this.getValueInReference(name));
        }
        
        return fields;
        
    }
    
}
