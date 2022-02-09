<%--
  Created by IntelliJ IDEA.
  User: usr088
  Date: 08.02.2022
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Main page</title>
    <style type="text/css">
    .tg {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
    .tg td{font-family:Arial, sans-serif;
           font-size:14px;padding:10px 5px;
           border-style:solid;
           border-width:1px;overflow:hidden;word-break:normal;
           border-color:#ccc;color:#333;background-color:#fff;}
    .tg th{font-family:Arial, sans-serif;
           font-size:14px;font-weight:normal;
           padding:10px 5px;border-style:solid;
           border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
    .tg .tg-4eph{background-color:#f9f9f9}
    </style>
  </head>
  <body>
  <h1>Welcome</h1>
  <p>
  ${message}<br/>
  <a href="${pageContext.request.contextPath}/roles">Click here to generate the Role List</a><br/>
  </p>
  </body>
</html>
