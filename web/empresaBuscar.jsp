<%-- 
    Document   : empresaBuscar
    Created on : 15/11/2016, 16:29:29
    Author     : zorawski
--%>

<%@page import="java.util.List"%>
<%@page import="Entidades.Empresa"%>
<%@page import="DAOs.DAOEmpresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="index.jsp"> Voltar </a>
        
        <form method="post" action ="EmpresaServlet" class="form-horizontal">
                <div class="col-sm-2"><input type="text" name="busca" class="form-control"/></div>
                <div class="form-group"><input type="submit" name="op" value="Buscar" class="btn btn-primary botao"/></div>
            </form>
        
        <table border="1" >
            <thead>
                <tr>
                <td> ID </td>
                <td> CNPJ </td>
                <td> Razão Social </td>
                <td> Nome Fantasia </td>
                <td> Rua </td>
                <td> Número </td>
                <td> Cidade </td>
                <td> CEP </td>
                <td> Telefone </td>
                <td> Email </td>
                </tr>
            </thead>
        <%
            String busca = request.getParameter("busca");
            DAOEmpresa dao = new DAOEmpresa();
            List<Empresa> empresas = dao.listByNomeFantasia(busca);
            if (empresas.size()!=0) {
            for(Empresa emp: empresas){
                out.print("<tr>");
                out.print("<td>"+emp.getId()+"</td>");
                out.print("<td>"+emp.getCnpj()+"</td>");
                out.print("<td>"+emp.getRazaoSocial()+"</td>");
                out.print("<td>"+emp.getNomeFantasia()+"</td>");
                out.print("<td>"+emp.getEnderecoRua()+"</td>");
                out.print("<td>"+emp.getEnderecoNum()+"</td>");
                out.print("<td>"+emp.getCidade()+"</td>");
                out.print("<td>"+emp.getCep()+"</td>");
                out.print("<td>"+emp.getTelefone()+"</td>");
                out.print("<td>"+emp.getEmail()+"</td>");
                out.print("<td> <a href=\"empresaAtualizar.jsp?id="+emp.getId()+"\"> "
                        + "Atualizar </a> | <a href=\"EmpresaServlet?id="+emp.getId()+"\"> Remover </a></td>");
                out.print("</tr>");
            }}else{
                out.print("<tr><td colspan=\"10\">Nenhum registro encontrado.</td></tr>");
            }
        %>
        </table>
    </body>
</html>