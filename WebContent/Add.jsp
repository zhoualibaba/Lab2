<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Add Book</title>
</head>
<body>    
    <h2>Add Book</h2>
    <s:form action="Store" >
        <s:textfield name="book.isbn" label="ISBN" />
        <s:textfield name="book.title" label="Title" />
        <s:textfield name="book.authorID" label="AuthorID" />
        <s:textfield name="book.publisher" label="Publisher" />
        <s:textfield name="book.publishdate" label="PublishDate" />
        <s:textfield name="book.price" label="Price" />
        <s:submit value = "BACK"/>
    </s:form>
</body>
</html>