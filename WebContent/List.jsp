<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Book List</title>
    <style type="text/css">
        div{
  				font:bold italic  35px "楷体";
			}
    </style>
</head>
<body>    
    <div>Book List</div>
    <s:form action="Search" theme="simple">
        <h2>Please input the author's name:</h2>
        <s:textfield name="name" label="ISBN" />
        <s:submit value = "search"/>
        <table cellspacing="0">
            <thead>
                <tr>
                    <th>ISBN</th>
                    <th>Title</th>
                    <th>AuthorID</th>
                    <th>Publisher</th>
                    <th>PublishDate</th>
                    <th>Price</th>
                    <th>Operation</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="books">
                    <tr>
                        <td><s:property value="isbn" /></td>
                        <td>
                            <a href='<s:url action="Show"><s:param name="isbn" value="isbn" /></s:url>'>
                                <s:property value="title" />
                            </a>
                        </td>
                        <td><s:property value="authorID" /></td>
                        <td><s:property value="publisher" /></td>
                        <td><s:property value="publishdate" /></td>
                        <td>$<s:property value="price" /></td>
                        <td>
                            &nbsp;
                            <a href='<s:url action="Remove"><s:param name="isbn" value="isbn" /></s:url>'>
                                Delete
                            </a>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </s:form>
    
    <s:form action="Add">
    	<s:submit value = "Add Book"/>
    </s:form>
</body>
</html>