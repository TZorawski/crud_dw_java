/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAOs.DAOEmpresa;
import DAOs.DAOGenerico;
import DAOs.DAOHabilidade;
import DAOs.DAOPerfilprocurado;
import Entidades.PerfilProcurado;
import Entidades.Empresa;
import Entidades.Habilidade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zorawski
 */
@WebServlet(name = "PerfilProcuradoServlet", urlPatterns = {"/PerfilProcuradoServlet"})
public class PerfilProcuradoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOGenerico dao = new DAOGenerico(PerfilProcurado.class);
        int id = Integer.parseInt(request.getParameter("id"));
        PerfilProcurado pp = (PerfilProcurado) dao.obter(id);
        dao.remover(pp);
        response.sendRedirect("perfilprocurado.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        
        DAOEmpresa daoEmpresa = new DAOEmpresa();
        DAOPerfilprocurado dao = new DAOPerfilprocurado();
        PerfilProcurado pp = new PerfilProcurado();

        if ("Inserir".equals(op)) {
            int id = Integer.valueOf(request.getParameter("id"));
        String area_atuacao = request.getParameter("area_atuacao");
        String escolaridade = request.getParameter("escolaridade");
        String quant_vagas = request.getParameter("quant_vagas");
        String faixa_etaria = request.getParameter("faixa_etaria");
        String tempo_experiencia = request.getParameter("tempo_experiencia");
        int id_empresa = Integer.valueOf(request.getParameter("id_empresa").trim());
        Empresa empresa= daoEmpresa.obter(id_empresa);
        String[] habs = request.getParameterValues("habilidades");
            
            pp.setId(id);
            pp.setAreaAtuacao(area_atuacao);
            pp.setEscolaridade(escolaridade);
            pp.setQuantVagas(Integer.valueOf(quant_vagas));
            pp.setFaixaEtaria(faixa_etaria);
            pp.setTempoExperiencia(tempo_experiencia);
            pp.setIdEmpresa(empresa);
            List<Habilidade> habsPP= new ArrayList<Habilidade>();
            DAOHabilidade daoHab= new DAOHabilidade();
            for (String h : habs) {
                int idHab= Integer.valueOf(h);
                Habilidade hab= daoHab.listByIdUnico(idHab);
                habsPP.add(hab);
            }
            pp.setHabilidadeList(habsPP);

            dao.inserir(pp);
            response.sendRedirect("perfilprocurado.jsp");
        } else if("Atualizar".equals(op)) {
            int id = Integer.valueOf(request.getParameter("id"));
        String area_atuacao = request.getParameter("area_atuacao");
        String escolaridade = request.getParameter("escolaridade");
        String quant_vagas = request.getParameter("quant_vagas");
        String faixa_etaria = request.getParameter("faixa_etaria");
        String tempo_experiencia = request.getParameter("tempo_experiencia");
        int id_empresa = Integer.valueOf(request.getParameter("id_empresa").trim());
        Empresa empresa= daoEmpresa.obter(id_empresa);
        String[] habs = request.getParameterValues("habilidades");
            
            pp = dao.obter(id);
            pp.setAreaAtuacao(area_atuacao);
            pp.setEscolaridade(escolaridade);
            pp.setQuantVagas(Integer.valueOf(quant_vagas));
            pp.setFaixaEtaria(faixa_etaria);
            pp.setTempoExperiencia(tempo_experiencia);
            pp.setIdEmpresa(empresa);
            List<Habilidade> habsPP= new ArrayList<Habilidade>();
            DAOHabilidade daoHab= new DAOHabilidade();
            for (String h : habs) {
                int idHab= Integer.valueOf(h);
                Habilidade hab= daoHab.listByIdUnico(idHab);
                habsPP.add(hab);
            }
            pp.setHabilidadeList(habsPP);

            dao.atualizar(pp);
            response.sendRedirect("perfilprocurado.jsp");
        } else {
            String busca = request.getParameter("busca");
                        
            response.sendRedirect("perfilprocuradoBuscar.jsp?busca="+busca);
        }

        
    }
}
