<%-- 
    Document   : perfilprocuradoBuscar
    Created on : 15/11/2016, 16:29:29
    Author     : zorawski
--%>

<%@page import="Entidades.Habilidade"%>
<%@page import="Entidades.Empresa"%>
<%@page import="DAOs.DAOEmpresa"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.PerfilProcurado"%>
<%@page import="DAOs.DAOPerfilprocurado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wanteds|Cadastros</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/estilo.css" />
    </head>
    <body>
        <div class="col-sm-9 col-sm-offset-1">
            <h2>Busca: </h2><h3><%=request.getParameter("busca")%></h3>
            <a href="index.jsp"> Voltar </a>
            
            <form method="post" action ="PerfilProcuradoServlet" class="form-horizontal">
                <div class="col-sm-2"><input type="text" name="busca" class="form-control"/></div>
                <div class="form-group"><input type="submit" name="op" value="Buscar" class="btn btn-primary botao"/></div>
            </form>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th> ID </th>
                        <th> Área Atuação </th>
                        <th> Escolaridade </th>
                        <th> Quantidade Vagas </th>
                        <th> Faixa Etária </th>
                        <th> Tempo Experiência </th>
                        <th> Empresa </th>
                        <th> Ações </th>
                    </tr>
                </thead>
                <%
                    String busca = request.getParameter("busca");
                    DAOPerfilprocurado dao = new DAOPerfilprocurado();
                    List<PerfilProcurado> pps = dao.list();

                    for (PerfilProcurado pp : pps) {
                        if (pp.getAreaAtuacao().contains(busca)) {
                            out.print("<tr>");
                            out.print("<td>" + pp.getId() + "</td>");
                            out.print("<td>" + pp.getAreaAtuacao() + "</td>");
                            out.print("<td>" + pp.getEscolaridade() + "</td>");
                            out.print("<td>" + pp.getQuantVagas() + "</td>");
                            out.print("<td>" + pp.getFaixaEtaria() + "</td>");
                            out.print("<td>" + pp.getTempoExperiencia() + "</td>");
                            out.print("<td>" + pp.getIdEmpresa() + "</td>");
                            List<Habilidade> habilidades = pp.getHabilidadeList();
                            String stringHab = new String();
                            for (Habilidade h : habilidades) {
                                stringHab += h.getNome() + ",";
                            }
                            out.print("<td>" + stringHab + "</td>");
                            out.print("<td> <a href=\"perfilprocuradoAtualizar.jsp?id=" + pp.getId() + "\"> "
                                    + "Atualizar </a> | <a href=\"PerfilProcuradoServlet?id=" + pp.getId() + "\"> Remover </a></td>");
                            out.print("</tr>");
                        } else {
                            out.print("<tr>Nenhum registro encontrado.</tr>");
                        }
                    }


                %>
            </table></div>
    </body>
</html>