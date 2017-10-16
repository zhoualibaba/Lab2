package org.zhou.view;

import java.util.Collection;
import org.zhou.model.AuthorDao;
import org.zhou.model.Book;
import com.opensymphony.xwork2.ActionSupport;

public class AuthorAction extends ActionSupport {
	private static final long serialVersionUID = -1154781281228131458L;
	
    private String name;
    private String age;
    private String country;
    private Collection<Book> books;
    private AuthorDao authordao =  AuthorDao.getInstance();
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    public String getAge() {
    	return age;
    }
    
    public void setAge(String age) {
    	this.age = age;
    }
    public String getCountry() {
    	return country;
    }
    
    public void setCountry(String country) {
    	this.country = country;
    }
    public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}
	
    
    public String showBooks() {
    	books = authordao.listBooks(name);
    	return SUCCESS;
    }
}
