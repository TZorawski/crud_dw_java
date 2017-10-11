<%-- 
    Document   : candidato
    Created on : 15/11/2016, 16:29:29
    Author     : zorawski
--%>

<%@page import="DAOs.DAOHabilidade"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Candidato"%>
<%@page import="Entidades.Habilidade"%>
<%@page import="DAOs.DAOCandidato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wanteds|Cadastros</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/estilo.css" />
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
        <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
        <script>
$(function() {
    $( "#calendario" ).datepicker();
});
</script>
    </head>
    <body>
        <h1>Cadastro de Candidatos</h1>

        <form method="post" action ="CandidatoCalendarioServlet" class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-1 control-label">Id</label>
                <div class="col-sm-6">            <input type="text" name="id" class="form-control"/></div></div>
            <div class="form-group">
                <label class="col-sm-1 control-label">Nome</label>
                <div class="col-sm-6"><input type="text" name="nome" class="form-control"/></div></div>

            <div class="form-group"><label class="col-sm-1 control-label">CPF</label>
                <div class="col-sm-6"><input type="text" name="cpf" class="form-control"/></div></div>
            <div class="form-group"><label class="col-sm-1 control-label">RG</label>
                <div class="col-sm-6"><input type="text" name="rg" class="form-control"/></div></div>
            <div class="form-group"><label class="col-sm-1 control-label">Data Nascimento</label>
            <div class="col-sm-6"><input type="text" name="data_nascimento" id="calendario" class="form-control"/></div></div>
        <div class="form-group"><label class="col-sm-1 control-label">Área Atuação</label>
            <div class="col-sm-6"><input type="text" name="area_atuacao" class="form-control"/></div></div>
        <div class="form-group"><label class="col-sm-1 control-label">Escolaridade</label>
            <div class="col-sm-6"><input type="text" name="escolaridade" class="form-control"/></div></div>
        <div class="form-group"><label class="col-sm-1 control-label">Tempo Experiência</label>
            <div class="col-sm-6"><input type="text" name="tempo_experiencia" class="form-control"/></div></div>
        <div class="form-group"><label class="col-sm-1 control-label">Telefone</label>
            <div class="col-sm-6"><input type="text" name="telefone" class="form-control"/></div></div>
        <div class="form-group"><label class="col-sm-1 control-label">Email</label>
            <div class="col-sm-6"><input type="text" name="email" class="form-control"/></div></div>
        <div class="form-group"><label class="col-sm-1 control-label">Área Interesse 1</label>
            <div class="col-sm-6"><input type="text" name="area_interesse1" class="form-control"/></div></div>
        <div class="form-group"><label class="col-sm-1 control-label">Área Interesse 2</label>
            <div class="col-sm-6"><input type="text" name="area_interesse2" class="form-control"/></div></div>
        <div class="form-group"><label class="col-sm-1 control-label">Área Interesse 3</label>
            <div class="col-sm-6"><input type="text" name="area_interesse3" class="form-control"/></div></div>
        <div class="form-group"><label class="col-sm-1 control-label">Hobbie</label>
            <div class="col-sm-6"><input type="text" name="hobbie" class="form-control"/></div></div>
        <hr/>
        <div class="form-group"><label class="col-sm-1 control-label">Habilidades</label>
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

    <div class="col-sm-7 col-sm-offset-1">
        <h2>Listagem</h2>

        <form method="post" action ="CandidatoCalendarioServlet" class="form-inline">
            <div class="form-group"><div class="col-sm-2"><input type="text" name="busca" class="form-control"/></div>
                <input type="submit" name="op" value="Buscar" class="btn btn-primary botao"/></div>
        </form>

        <table class="table table-striped">
            <thead>
                <tr>
                    <th> ID </th>
                    <th> Nome </th>
                    <th> CPF </th>
                    <th> RG </th>
                    <th> Data Nascimento </th>
                    <th> Área atuação </th>
                    <th> Escolaridade </th>
                    <th> Tempo Experiência </th>
                    <th> Telefone </th>
                    <th> Email </th>
                    <th> Área interesse 1 </th>
                    <th> Área interesse 2 </th>
                    <th> Área interesse 3 </th>
                    <th> Hobbie </th>
                    <th> Habilidades </th>
                    <th> Ações </th>
                </tr>
            </thead>
            <%                DAOCandidato dao = new DAOCandidato();
                List<Candidato> candidato = dao.list();
                for (Candidato cand : candidato) {
                    out.print("<tr>");
                    out.print("<td>" + cand.getId() + "</td>");
                    out.print("<td>" + cand.getNome() + "</td>");
                    out.print("<td>" + cand.getCpf() + "</td>");
                    out.print("<td>" + cand.getRg() + "</td>");
                    out.print("<td>" + cand.getDataNascimento() + "</td>");
                    out.print("<td>" + cand.getAreaAtuacao() + "</td>");
                    out.print("<td>" + cand.getEscolaridade() + "</td>");
                    out.print("<td>" + cand.getTempoExperiencia() + "</td>");
                    out.print("<td>" + cand.getTelefone() + "</td>");
                    out.print("<td>" + cand.getEmail() + "</td>");
                    out.print("<td>" + cand.getAreaInteresse1() + "</td>");
                    out.print("<td>" + cand.getAreaInteresse2() + "</td>");
                    out.print("<td>" + cand.getAreaInteresse3() + "</td>");
                    out.print("<td>" + cand.getHobbie() + "</td>");
                    List<Habilidade> habilidades = cand.getHabilidadeList();
                    String stringHab = new String();
                    for (Habilidade h : habilidades) {
                        stringHab += h.getNome() + ",";
                    }
                    out.print("<td>" + stringHab + "</td>");
                    out.print("<td> <a href=\"candidatoAtualizarCalendario.jsp?id=" + cand.getId() + "\"> "
                            + "Atualizar </a> | <a href=\"CandidatoServlet?id=" + cand.getId() + "\"> Remover </a></td>");
                    out.print("</tr>");
                }
            %>
        </table>
    </div>
</body>
</html>