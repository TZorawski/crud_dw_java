<%-- 
    Document   : habilidadeBuscar
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
        <div class="col-sm-9 col-sm-offset-1">
            <h2>Busca: </h2><h3><%=request.getParameter("busca")%></h3>
            <a href="index.jsp"> Voltar </a>
            
            <form method="post" action ="HabilidadeServlet" class="form-horizontal">
                <div class="col-sm-2"><input type="text" name="busca" class="form-control"/></div>
                <div class="form-group"><input type="submit" name="op" value="Buscar" class="btn btn-primary botao"/></div>
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
                String busca = request.getParameter("busca");
                    DAOHabilidade dao = new DAOHabilidade();
                    List<Habilidade> habilidades = dao.listByNome(busca);
                    if (habilidades.size()!=0) {
                        for (Habilidade hab : habilidades) {
                            out.print("<tr>");
                    out.print("<td>" + hab.getId() + "</td>");
                    out.print("<td>" + hab.getNome() + "</td>");
                    out.print("<td> <a href=\"habilidadeAtualizar.jsp?id=" + hab.getId() + "\"> "
                            + "Atualizar </a> | <a href=\"HabilidadeServlet?id=" + hab.getId() + "\"> Remover </a></td>");
                    out.print("</tr>");
                        }
                    } else {
                        out.print("<tr><td colspan=\"2\">Nenhum registro encontrado.</td></tr>");
                    }
            %>
        </table></div>
    </body>
</html>