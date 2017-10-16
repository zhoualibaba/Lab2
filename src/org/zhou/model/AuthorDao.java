package org.zhou.model;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.zhou.model.Author;
import org.zhou.model.Book;
import org.zhou.controller.mysqldao;

public class AuthorDao {
	private static final AuthorDao instance;
    static mysqldao databasea;
    
    static {
    	instance= new AuthorDao();
    	databasea = new mysqldao();
    }
    
    private AuthorDao() {
    	
    }
    
    public static AuthorDao getInstance() {
		return instance;
	}
    
    public Collection<Book> listBooks(String name) {
	    ConcurrentMap<String, Book> data = new ConcurrentHashMap<String, Book>();
	    data = databasea.authorlist(name); 
    	return data.values();
    }
    
    public Author getAuthor(int authorID) {
    	Author author = new Author();
    	author = databasea.findauthor(authorID);
    	return author;
    }
}
