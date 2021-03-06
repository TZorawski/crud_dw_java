<%-- 
    Document   : candidatoAtualizar
    Created on : 15/11/2016, 16:29:29
    Author     : zorawski
--%>

<%@page import="Entidades.Habilidade"%>
<%@page import="DAOs.DAOHabilidade"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.Candidato"%>
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
        <h1>Atualizar Candidato</h1>
        <%
            int id= Integer.valueOf(request.getParameter("id"));
            DAOCandidato daoCandidato = new DAOCandidato();
            Candidato cand = daoCandidato.listByIdUnico(id);
        %>
        <form method="post" action ="CandidatoServlet">
            <input type="hidden" name="id" value="<%=cand.getId()%>"/>
            Nome: <br/>
            <input type="text" name="nome" value="<%=cand.getNome()%>"/><br/><br/>
            CPF: <br/>
            <input type="text" name="cpf" value="<%=cand.getCpf()%>"/><br/><br/>
            RG: <br/>
            <input type="text" name="rg" value="<%=cand.getRg()%>"/><br/><br/>
            Data Nascimento: <br/>
            <div class="col-sm-6"><input type="text" name="data_nascimento" value="<%=cand.getDataNascimento()%>" id="calendario" class="form-control"/></div></div>
            Área atuação: <br/>
            <input type="text" name="area_atuacao" value="<%=cand.getAreaAtuacao()%>"/><br/><br/>
            Escolaridade: <br/>
            <input type="text" name="escolaridade" value="<%=cand.getEscolaridade()%>"/><br/><br/>
            Tempo Experiência: <br/>
            <input type="text" name="tempo_experiencia" value="<%=cand.getTempoExperiencia()%>"/><br/><br/>
            Telefone: <br/>
            <input type="text" name="telefone" value="<%=cand.getTelefone()%>"/><br/><br/>
            Email: <br/>
            <input type="text" name="email" value="<%=cand.getEmail()%>"/><br/><br/>
            Área interesse 1: <br/>
            <input type="text" name="area_interesse1" value="<%=cand.getAreaInteresse1()%>"/><br/><br/>
            Área interesse 2: <br/>
            <input type="text" name="area_interesse2" value="<%=cand.getAreaInteresse2()%>"/><br/><br/>
            Área interesse 3: <br/>
            <input type="text" name="area_interesse3" value="<%=cand.getAreaInteresse3()%>"/><br/><br/>
            Hobbie: <br/>
            <input type="text" name="hobbie" value="<%=cand.getHobbie()%>"/><br/><br/>
            <hr/>
            <div class="form-group"><label class="col-sm-1 control-label">Habilidades</label>
                <div class="col-sm-7 col-sm-offset-1"><%
                    DAOHabilidade daoHab = new DAOHabilidade();
                    List<Habilidade> habs = daoHab.list();
                    List<Habilidade> habsChecked = cand.getHabilidadeList();
                    for (Habilidade hab : habs) {
                        if (habsChecked.contains(hab)) {
                                out.print("<div class=\"checkbox\"><label><input type=\"checkbox\" name=\"habilidades\" value=\""+hab.getId()+"\" checked=\"checked\">"+hab.getNome()+"</label></div>");
                            }else{
                            out.print("<div class=\"checkbox\"><label><input type=\"checkbox\" name=\"habilidades\" value=\""+hab.getId()+"\">"+hab.getNome()+"</label></div>");
                        }
                            
                        }
                    
                %></div>
            </div>
            <hr/>
    
            <input type="submit" name="op" value="Atualizar" />
        </form>
        <hr/>
        
    </body>
</html>