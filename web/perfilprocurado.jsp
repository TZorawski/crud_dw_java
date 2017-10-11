<%-- 
    Document   : perfilprocurado
    Created on : 15/11/2016, 16:29:29
    Author     : zorawski
--%>

<%@page import="Entidades.Habilidade"%>
<%@page import="DAOs.DAOHabilidade"%>
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
        <h1>Cadastro de Perfil Procurado</h1>
        <a href="index.jsp"> Voltar </a>

        <form method="post" action ="PerfilProcuradoServlet" class="form-horizontal">
            <div class="form-group"><label class="col-sm-2 control-label">Id</label>
                <div class="col-sm-6"><input type="text" name="id" class="form-control"/></div></div>
            <div class="form-group"><label class="col-sm-2 control-label">Área Atuação:</label>
                <div class="col-sm-6"><input type="text" name="area_atuacao" class="form-control"/></div></div>
            <div class="form-group"><label class="col-sm-2 control-label">Escolaridade: </label>
                <div class="col-sm-6"><input type="text" name="escolaridade" class="form-control"/></div></div>
            <div class="form-group"><label class="col-sm-2 control-label">Quantidade Vagas: </label>
                <div class="col-sm-6"><input type="text" name="quant_vagas" class="form-control"/></div></div>
            <div class="form-group"><label class="col-sm-2 control-label">Faixa Etária: </label>
                <div class="col-sm-6"><input type="text" name="faixa_etaria" class="form-control"/></div></div>
            <div class="form-group"><label class="col-sm-2 control-label">Tempo Experiência: </label>
                <div class="col-sm-6"><input type="text" name="tempo_experiencia" class="form-control"/></div></div>
            <div class="form-group"><label class="col-sm-2 control-label">Empresa: </label>
                <div class="col-sm-6"><select name="id_empresa" class="form-control">
                        <option value="null">--Escolha uma empresa--</option>
                        <%
                            DAOEmpresa daoEmpresa = new DAOEmpresa();
                            List<Empresa> empresas = daoEmpresa.listEmpresa();
                            for (Empresa emp : empresas) {
                                out.print("<option value=\"" + emp.getId() + "\">" + emp.getRazaoSocial() + "</option>");
                            }
                        %>
                    </select></div></div>
            <hr/><div class="form-group"><label class="col-sm-1 control-label">Habilidades</label>
                <div class="col-sm-7 col-sm-offset-1"><%
                    DAOHabilidade daoHab = new DAOHabilidade();
                    List<Habilidade> habs = daoHab.list();
                    for (Habilidade hab : habs) {
                        out.print("<div class=\"checkbox\"><label><input type=\"checkbox\" name=\"habilidades\" value=\"" + hab.getId() + "\">" + hab.getNome() + "</label></div>");
                    }

                    %></div>
            </div>
            <hr/>

            <div class="form-group"><input type="submit" name="op" value="Inserir" class="btn btn-primary botao"/></div>
        </form>
        <hr/>

        <div class="col-sm-9 col-sm-offset-1">
            <h2>Listagem</h2>

            <form method="post" action ="PerfilProcuradoServlet" class="form-inline">
                <div class="form-group"><div class="col-sm-2"><input type="text" name="busca" class="form-control"/></div>
                    <input type="submit" name="op" value="Buscar" class="btn btn-primary botao"/></div>
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
                        <th> Habilidades </th>
                        <th> Ações </th>
                    </tr>
                </thead>
                <%                DAOPerfilprocurado dao = new DAOPerfilprocurado();
                    List<PerfilProcurado> pps = dao.list();
                    for (PerfilProcurado pp : pps) {
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
                    }
                %>
            </table></div>
    </body>
</html>