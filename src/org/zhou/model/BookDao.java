package org.zhou.model;

import java.util.Collection;
import java.util.concurrent.ConcurrentMap;

import org.zhou.model.Book;
import org.zhou.controller.mysqldao;

public class BookDao {
	
    private static mysqldao database = new mysqldao();
    private static ConcurrentMap<String, Book> data = database.list();
    private static BookDao instance = new BookDao();
    
    
    public static BookDao getInstance() {
        return instance;
    }
    
    public Collection<Book> getBooks() {
        return data.values();
    }
    
    public Book getBook(String isbn) {
        return data.get(isbn);
    }
    
    public void updateBook(Book book) {
    	database.update(book);
    	data.replace(book.getIsbn(), book);
    }
    
    public void storeBook(Book book) {
    	database.store(book);
        data.put(book.getIsbn(), book);
    }
        
    public void removeBook(String isbn) {
    	database.remove(isbn);
        data.remove(isbn);
    }
    
    public void removeBooks(String[] isbns) {
        for(String isbn : isbns) {
        	database.remove(isbn);
            data.remove(isbn);
        }
    }
}