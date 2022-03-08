<%-- 
    Document   : report
    Created on : Jul 20, 2020, 6:16:39 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .error {
                color: #ff0000;
            }

        </style>
    </head>
    <body>
        <h2>Report example</h2>

        <form:form method="POST" action="reportView" commandName="reportInputForm">

            <table id="reptbl" width="350px" border="1">
                <tr>
                    <td colspan="2"> <form:errors path="Rep_Title" cssClass="error"/></td> </tr>
                <tr>
                    <td>
                        Enter Report Title <form:input path="Rep_Title" id="Rep_Title"/>
                        <input type="submit"  value="Generate Report"  />
                    </td> 

                </tr>
            </table>  
        </form:form>
    </body>
</html>

