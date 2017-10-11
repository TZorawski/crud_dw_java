<%-- 
    Document   : empresaAtualizar
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
        <h1>Atualizar Empresa</h1>
        <a href="index.jsp"> Voltar </a>
        
        <%
            int id= Integer.valueOf(request.getParameter("id"));
            DAOEmpresa daoEmpresa = new DAOEmpresa();
            Empresa emp= daoEmpresa.listByIdUnico(id);
        %>
        <form method="post" action ="EmpresaServlet">
            <input type="hidden" name="id" value="<%=emp.getId()%>"/>
            CNPJ: <br/>
            <input type="text" name="cnpj" value="<%=emp.getCnpj()%>"/><br/><br/>
            Razão Social: <br/>
            <input type="text" name="razao_social" value="<%=emp.getRazaoSocial()%>"/><br/><br/>
            Nome Fantasia: <br/>
            <input type="text" name="nome_fantasia" value="<%=emp.getNomeFantasia()%>"/><br/><br/>
            Endereço- rua: <br/>
            <input type="text" name="endereco_rua" value="<%=emp.getEnderecoRua()%>"/><br/><br/>
            Número: <br/>
            <input type="text" name="endereco_num" value="<%=emp.getEnderecoNum()%>"/><br/><br/>
            Cidade: <br/>
            <input type="text" name="cidade" value="<%=emp.getCidade()%>"/><br/><br/>
            CEP: <br/>
            <input type="text" name="cep" value="<%=emp.getCep()%>"/><br/><br/>
            Telefone: <br/>
            <input type="text" name="telefone" value="<%=emp.getTelefone()%>"/><br/><br/>
            Email: <br/>
            <input type="text" name="email" value="<%=emp.getEmail()%>"/><br/><br/>
    
            <input type="submit" name="op" value="Atualizar" />
        </form>
        <hr/>
    </body>
</html>