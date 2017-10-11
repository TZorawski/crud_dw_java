<%-- 
    Document   : candidato
    Created on : 15/11/2016, 16:29:29
    Author     : zorawski
--%>

<%@page import="Entidades.Habilidade"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Candidato"%>
<%@page import="DAOs.DAOCandidato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wanteds|Cadastros</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <link rel="stylesheet" href="css/estilo.css" />
    </head>
    <body>
        <div class="col-sm-9 col-sm-offset-1">
            <h2>Busca: </h2><h3><%=request.getParameter("busca")%></h3>
            <a href="index.jsp"> Voltar </a>
            
            <!-- Botao buscar -->
            <!-- Envia o parametro recebido para o Servvlet -->
            <form method="post" action ="CandidatoServlet" class="form-horizontal">
                <div class="col-sm-2"><input type="text" name="busca" class="form-control"/></div>
                <div class="form-group"><input type="submit" name="op" value="Buscar" class="btn btn-primary botao"/></div>
            </form>
            
            <!-- Lista com resultados -->
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
                    <th> Ações </th>
                </tr>
            </thead>
            <%
                //Atribui parametro recebido pela url para variavel
                String busca = request.getParameter("busca");
                DAOCandidato dao = new DAOCandidato();
                List<Candidato> candidatos = dao.listByNome(busca);
                if (candidatos.size()!=0) {
                for (Candidato cand : candidatos) {
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
                    List<Habilidade> habilidades= cand.getHabilidadeList();
                        String stringHab= new String();
                        for (Habilidade h : habilidades) {
                                stringHab+= h.getNome()+",";
                            }
                        out.print("<td>" + stringHab + "</td>");
                    out.print("<td> <a href=\"candidatoAtualizar.jsp?id=" + cand.getId() + "\"> "
                            + "Atualizar </a> | <a href=\"CandidatoServlet?id=" + cand.getId() + "\"> Remover </a></td>");
                    out.print("</tr>");
                }}else{
                    out.print("<tr><td colspan=\"15\">Nenhum registro encontrado.</td></tr>");
                }
            %>
        </table>
        </div>
    </body>
</html>