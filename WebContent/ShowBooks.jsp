<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The author's book</title>
    <style type="text/css">
        div{
  				font:bold italic  25px "楷体";
			}
    </style>
</head>

<body>
<div>The author's book:</div>
<s:form action="Ret" >
<s:iterator value="books">
<s:property value="title" /><br>
</s:iterator>
<s:submit value = "BACK"/>
</s:form>

</body>
</html>