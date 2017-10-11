<%-- 
    Document   : index
    Created on : 15/11/2016, 15:02:39
    Author     : zorawski
--%>


<%@page import="java.util.List"%>
<%@page import="Entidades.Habilidade"%>
<%@page import="DAOs.DAOGenerico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wanteds</title>
        <!-- css usado pela Google-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
        <link rel="stylesheet" href="https://code.getmdl.io/1.3.0/material.min.css">
    </head>
    <body>
        <h3>Cadastros</h3>
        <p><a href="habilidade.jsp" class="mdl-button">Cadastro de habilidades</a></p>
        <br/>
        <p><a href="empresa.jsp" class="mdl-button">Cadastro de Empresas</a></p>
        <br/>
        <p><a href="candidato.jsp" class="mdl-button">Cadastro de Candidatos</a></p>
        <br/>
        <p><a href="perfilprocurado.jsp" class="mdl-button">Cadastro de Perfils</a></p>
        
    </body>
</html>
