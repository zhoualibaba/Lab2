package org.zhou.view;

import java.util.Collection;

import org.zhou.model.AuthorDao;
import org.zhou.model.BookDao;
import org.zhou.model.Book;
import org.zhou.model.Author;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
    private static final long serialVersionUID = 872316812305356L;
    
    private String isbn;
    private String[] isbns;
    private Book book;
    private Author author;
    private Collection<Book> books;
    private BookDao bookdao =  new BookDao();
    private AuthorDao authordao = AuthorDao.getInstance();
        
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String[] getIsbns() {
        return isbns;
    }

    public void setIsbns(String[] isbns) {
        this.isbns = isbns;
    }
        
    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    public String load() {
        book = bookdao.getBook(isbn);
        author = authordao.getAuthor(book.getAuthorID());
        return SUCCESS;
    }

    public String list() {
        books = bookdao.getBooks();
        return SUCCESS;
    }
    
    public String change() {
    	bookdao.updateBook(book);
    	return SUCCESS;
    }
        
    public String store() {
        bookdao.storeBook(book);
        return SUCCESS;
    }
    
    public String remove() {
        if(isbn != null) {
            bookdao.removeBook(isbn);
        }else {
            bookdao.removeBooks(isbns);
        }
        return SUCCESS;
    }
}