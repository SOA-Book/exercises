package au.edu.unsw.soacourse.books.dao;

import java.util.HashMap;
import java.util.Map;

import au.edu.unsw.soacourse.books.model.Book;


public enum BooksDao {
    instance;

    private Map<String, Book> contentStore = new HashMap<String, Book>();

    private BooksDao() {

        Book b = new Book("1", "RESTful Web Services");
        b.setDetail("http://oreilly.com/catalog/9780596529260");
        contentStore.put("1", b);
        b = new Book("2", "RESTful Java with JAX-RS");
        b.setDetail("http://oreilly.com/catalog/9780596158057");
        contentStore.put("2", b);
    }
    public Map<String, Book> getStore(){
        return contentStore;
    }

}
