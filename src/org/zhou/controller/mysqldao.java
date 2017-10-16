package org.zhou.controller;

import java.sql.Connection;
//efgwgerf
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.zhou.model.Author;
import org.zhou.model.Book;
import com.mysql.jdbc.PreparedStatement;

public class mysqldao {
	
	static String driver = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3306/app_zhouzhou";
	static String user = "jy1ll23y40";
	static String password = "mjlx35mylzkh1h14jhwxxz2yxhiwzhmhyhwji25y";
	
	private static Connection conn;  
    
	private static void init() {
        try {
	        Class.forName(driver);
	    } catch(ClassNotFoundException e) {  
	        System.out.println("sorry, can't find the driver!");  
	        e.printStackTrace();  
  	    }  catch(Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private static Connection getConn(){
		init();
		try {  
            conn = DriverManager.getConnection(url, user, password);  
            conn.setAutoCommit(false); 
        } catch (Exception e) {  
            System.out.println("sorry, can't connect the driver!");  
            System.out.println(e.getMessage());  
        }  
		return conn; 
	}

	public ConcurrentMap<String, Book> list() {
		
	    ConcurrentMap<String, Book> data = new ConcurrentHashMap<String, Book>();
		try {
			Statement statement = getConn().createStatement();
	        String sql = "select ISBN,Title,AuthorID,Publisher,PublishDate,Price from book";
	        ResultSet rs = statement.executeQuery(sql);
	        while(rs.next()) {
	    	    Book bookmessage = new Book(rs.getString("ISBN"),rs.getString("Title"),
	    	    		rs.getInt("AuthorID"),rs.getString("Publisher"),
	    	    		rs.getString("PublishDate"),rs.getDouble("Price"));    	
	    	    data.put(rs.getString("ISBN"), bookmessage);
	        } 
	        rs.close(); 
	        statement.close();
	        conn.close();
	    } catch (SQLException e) {
			e.printStackTrace();
		}  
		return data;
	}

	public void update(Book book) {
		init();
		try {
			String sql="update book set Title=?,AuthorID=?,Publisher=?,PublishDate=?,Price=? where isbn=?";
			PreparedStatement pst = (PreparedStatement) getConn().prepareStatement(sql);
			
			pst.setString(1, book.getIsbn());
			pst.setString(2, book.getTitle());
            pst.setInt(3, book.getAuthorID());
            pst.setString(4, book.getPublisher());
            pst.setString(5, book.getPublishdate());
            pst.setDouble(6, book.getPrice());
            pst.executeUpdate();
            pst.close();
            conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void store(Book book) {
		init();
		try {
			String sql = "insert into book(ISBN,Title,AuthorID,Publisher,PublishDate,Price) values(?,?,?,?,?,?)";
			PreparedStatement pst = (PreparedStatement) getConn().prepareStatement(sql);
			pst.setString(1, book.getIsbn());
			pst.setString(2, book.getTitle());
            pst.setInt(3, book.getAuthorID());
            pst.setString(4, book.getPublisher());
            pst.setString(5, book.getPublishdate());
            pst.setDouble(6, book.getPrice());
            pst.executeUpdate();
            pst.close();
            conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void remove(String isbn) {
		init();
		try {
			String sql = "delete from book where ISBN= '" + isbn + "'"; 
			PreparedStatement pst = (PreparedStatement) getConn().prepareStatement(sql);
			pst.executeUpdate();
			pst.close();
            conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private int findID(String authorname) {
		init();
		int authorid = 0;
		try {
			Statement statement = getConn().createStatement();
	        String sql = "select AuthorID,Name,Age,Country from author";
	        ResultSet rs = statement.executeQuery(sql);
	        while(rs.next()) {
	        	if(rs.getString("Name").equals(authorname)){
	        		authorid = rs.getInt("authorID");
	    	        break;
	        	}
	        } 
	        rs.close(); 
	        statement.close();
	        conn.close();
	    } catch (SQLException e) {
			e.printStackTrace();
		}  
		return authorid;
	}
	
    public ConcurrentMap<String, Book> authorlist(String authorname) {
		
	    ConcurrentMap<String, Book> data = new ConcurrentHashMap<String, Book>();
        int authorid = findID(authorname);
        init();
        
		try {
			Statement statement = getConn().createStatement();
	        String sql = "select ISBN,Title,AuthorID,Publisher,PublishDate,Price from book";
	        ResultSet rs = statement.executeQuery(sql);
	        while(rs.next()) {
	        	if(rs.getInt("authorid") == authorid){
	    	        Book bookmessage = new Book(rs.getString("isbn"),rs.getString("title"),
	    	    		rs.getInt("authorID"),rs.getString("publisher"),
	    	    		rs.getString("publishdate"),rs.getDouble("price"));    	
	    	        data.put(rs.getString("isbn"), bookmessage);
	        	}
	        } 
	        rs.close(); 
	        statement.close();
	        conn.close();
	    } catch (SQLException e) {
			e.printStackTrace();
		}  
		return data;
	}
    
    public Author findauthor(int authorID) {
    	init();
		Author author = new Author();
		try {
			Statement statement = getConn().createStatement();
	        String sql = "select AuthorID,Name,Age,Country from author";
	        ResultSet rs = statement.executeQuery(sql);
	        while(rs.next()) {
	        	if( rs.getInt("authorid")== authorID ){
	    	        author.setAuthorID(rs.getInt("authorid"));
	    	        author.setAuthorname(rs.getString("name"));
	    	        author.setAuthorage(rs.getInt("age"));
	    	        author.setAuthorcountry(rs.getString("country"));
	    	        break;
	        	}
	        } 
	        rs.close(); 
	        statement.close();
	        conn.close();
	    } catch (SQLException e) {
			e.printStackTrace();
		}  
		return author;
    }
	
}