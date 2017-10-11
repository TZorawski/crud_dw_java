<%-- 
    Document   : empresa
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
        <h1>Cadastro de Empresas</h1>
        <a href="index.jsp"> Voltar </a>
        
        <form method="post" action ="EmpresaServlet">
            Id: <br/>
            <input type="text" name="id" /><br/><br/>
            CNPJ: <br/>
            <input type="text" name="cnpj" /><br/><br/>
            Razão Social: <br/>
            <input type="text" name="razao_social" /><br/><br/>
            Nome Fantasia: <br/>
            <input type="text" name="nome_fantasia" /><br/><br/>
            Endereço- rua: <br/>
            <input type="text" name="endereco_rua" /><br/><br/>
            Número: <br/>
            <input type="text" name="endereco_num" /><br/><br/>
            Cidade: <br/>
            <input type="text" name="cidade" /><br/><br/>
            CEP: <br/>
            <input type="text" name="cep" /><br/><br/>
            Telefone: <br/>
            <input type="text" name="telefone" /><br/><br/>
            Email: <br/>
            <input type="text" name="email" /><br/><br/>
    
            <input type="submit" name="op" value="Inserir" />
        </form>
        <hr/>
        <br/><br/><br/>
        
        <form method="post" action ="EmpresaServlet" class="form-inline">
                <div class="form-group"><div class="col-sm-2"><input type="text" name="busca" class="form-control"/></div>
                <input type="submit" name="op" value="Buscar" class="btn btn-primary botao"/></div>
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
            DAOEmpresa dao = new DAOEmpresa();
            List<Empresa> empresas = dao.list();
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
            }
        %>
        </table>
    </body>
</html>