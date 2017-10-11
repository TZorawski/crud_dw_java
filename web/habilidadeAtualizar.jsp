<%-- 
    Document   : habilidadeAtualizar
    Created on : 15/11/2016, 16:29:29
    Author     : zorawski
--%>

<%@page import="java.util.List"%>
<%@page import="Entidades.Habilidade"%>
<%@page import="DAOs.DAOHabilidade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Atualizar Habilidade</h1>
        <a href="index.jsp"> Voltar </a>
        
        <%
            int id= Integer.valueOf(request.getParameter("id"));
            DAOHabilidade daoHabilidade = new DAOHabilidade();
            Habilidade hab= daoHabilidade.listByIdUnico(id);
        %>
        <form method="post" action ="HabilidadeServlet">
            <input type="hidden" name="id" value="<%=hab.getId()%>"/>
            Nome: <br/>
            <input type="text" name="nome" value="<%=hab.getNome()%>"/><br/><br/>
    
            <input type="submit" name="op" value="Atualizar"/>
        </form>
        <hr/>
        
    </body>
</html>