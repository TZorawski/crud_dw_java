<%-- 
    Document   : habilidade
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
        <title>Wanteds|Cadastros</title>
        <!-- Latest compiled and minified CSS -->
        <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">-->
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/estilo.css" />
    </head>
    <body>
        <h1>Cadastro de Habilidade</h1>
        <a href="index.jsp"> Voltar </a>
        <br/>
        <form method="post" action ="HabilidadeServlet" class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-1 control-label">Id</label>
                <div class="col-sm-6">            <input type="text" name="id" class="form-control"/></div></div>
            <div class="form-group">
                <label class="col-sm-1 control-label">Nome</label>
                <div class="col-sm-6"><input type="text" name="nome" class="form-control"/></div></div>

            <div class="form-group"><input type="submit" name="op" value="Inserir" class="btn btn-primary botao"/></div>
        </form>
        <hr/>
        
        <div class="col-sm-7 col-sm-offset-2">
        <h2>Listagem</h2>
        
        <form method="post" action ="HabilidadeServlet" class="form-inline">
                <div class="form-group"><div class="col-sm-2"><input type="text" name="busca" class="form-control"/></div>
                <input type="submit" name="op" value="Buscar" class="btn btn-primary botao"/></div>
            </form>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th> ID </th>
                    <th> Nome </th>
                    <th> Ações </th>
                </tr>
            </thead>
            <%
                DAOHabilidade dao = new DAOHabilidade();
                List<Habilidade> habilidades = dao.list();
                for (Habilidade hab : habilidades) {
                    out.print("<tr>");
                    out.print("<td>" + hab.getId() + "</td>");
                    out.print("<td>" + hab.getNome() + "</td>");
                    out.print("<td> <a href=\"habilidadeAtualizar.jsp?id=" + hab.getId() + "\"> "
                            + "Atualizar </a> | <a href=\"HabilidadeServlet?id=" + hab.getId() + "\"> Remover </a></td>");
                    out.print("</tr>");
                }
            %>
        </table></div>
    </body>
</html>