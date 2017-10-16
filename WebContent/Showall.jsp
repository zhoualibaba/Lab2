<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show the detials</title>
</head>
<body>
    <h2>Book Information</h2>
    <s:form action="Ret" >
        ISBN:		  <s:property value="book.isbn"/><br>
        Title:		  <s:property value="book.title"/><br>
        AuthorID:	  <s:property value="book.authorID"/><br>
        Publisher:	  <s:property value="book.publisher"/><br>
        publishdate:  <s:property value="book.publishdate"/><br>
        price:		  <s:property value="book.price"/><br>
        AuthorName	  <s:property value="author.authorname"/><br>
        AuthorAge	  <s:property value="author.authorage"/><br>
        AuthorCountry <s:property value="author.authorcountry"/><br>
        <a href='<s:url action="Update"><s:param name="isbn" value="book.isbn" /></s:url>'>
             Change the book's information
        </a>
        <s:submit value = "BACK"/>
    </s:form>

</body>
</html>