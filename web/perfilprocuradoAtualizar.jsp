<%-- 
    Document   : perfilprocuradoAtualizar
    Created on : 15/11/2016, 16:29:29
    Author     : zorawski
--%>

<%@page import="Entidades.Empresa"%>
<%@page import="DAOs.DAOEmpresa"%>
<%@page import="Entidades.Habilidade"%>
<%@page import="DAOs.DAOHabilidade"%>
<%@page import="java.util.List"%>
<%@page import="Entidades.PerfilProcurado"%>
<%@page import="DAOs.DAOPerfilprocurado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de Perfil Procurado</h1>
        <a href="index.jsp"> Voltar </a>
        
        <%
            int id= Integer.valueOf(request.getParameter("id"));
            DAOPerfilprocurado daoPP = new DAOPerfilprocurado();
            PerfilProcurado pp= daoPP.obter(id);
        %>
        <form method="post" action ="PerfilProcuradoServlet">
            <input type="hidden" name="id" value="<%=pp.getId()%>"/>
            Área Atuação: <br/>
            <input type="text" name="area_atuacao" value="<%=pp.getAreaAtuacao()%>"/><br/><br/>
            Escolaridade: <br/>
            <input type="text" name="escolaridade" value="<%=pp.getEscolaridade()%>"/><br/><br/>
            Quantidade Vagas: <br/>
            <input type="text" name="quant_vagas" value="<%=pp.getQuantVagas()%>"/><br/><br/>
            Faixa Etária: <br/>
            <input type="text" name="faixa_etaria" value="<%=pp.getFaixaEtaria()%>"/><br/><br/>
            Tempo Experiência: <br/>
            <input type="text" name="tempo_experiencia" value="<%=pp.getTempoExperiencia()%>"/><br/><br/>
            
            <div class="form-group"><label class="col-sm-2 control-label">Empresa: </label>
                <div class="col-sm-6"><select name="id_empresa" class="form-control">
                        <option value="null">--Escolha uma empresa--</option>
                        <%
                            DAOEmpresa daoEmpresa = new DAOEmpresa();
                            List<Empresa> empresas = daoEmpresa.listEmpresa();
                            for (Empresa emp : empresas) {
                                if (emp.getId()==pp.getIdEmpresa().getId()) {
                                        out.print("<option value=\"" + emp.getId() + "\" selected=\"selected\">" + emp.getRazaoSocial() + "</option>");
                                    }else{
                                    out.print("<option value=\"" + emp.getId() + "\">" + emp.getRazaoSocial() + "</option>");
                                }
                                
                            }
                        %>
                    </select></div></div>
            
            <hr/>
            <div class="form-group"><label class="col-sm-1 control-label">Habilidades</label>
                <div class="col-sm-7 col-sm-offset-1"><%
                    DAOHabilidade daoHab = new DAOHabilidade();
                    List<Habilidade> habs = daoHab.list();
                    List<Habilidade> habsChecked = pp.getHabilidadeList();
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