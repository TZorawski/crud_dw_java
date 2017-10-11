/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAOs.DAOCandidato;
import DAOs.DAOGenerico;
import DAOs.DAOHabilidade;
import Entidades.Candidato;
import Entidades.Habilidade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tools.EnviaEmail;

/**
 *
 * @author zorawski
 */
@WebServlet(name = "CandidatoServlet", urlPatterns = {"/CandidatoServlet"})
public class CandidatoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOGenerico dao = new DAOGenerico(Candidato.class);
        int id = Integer.parseInt(request.getParameter("id"));
        Candidato cand = (Candidato) dao.obter(id);
        dao.remover(cand);
        //Redireciona para candidato.jsp
        response.sendRedirect("candidato.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recebe a opcao
        String op = request.getParameter("op");

        DAOCandidato dao = new DAOCandidato();
        Candidato cand = new Candidato();

        if ("Inserir".equals(op)) {
            //Atribui cada parametro a respectiva variavel
            int id = Integer.valueOf(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String rg = request.getParameter("rg");
            String data_nascimento = request.getParameter("data_nascimento");
            String area_atuacao = request.getParameter("area_atuacao");
            String escolaridade = request.getParameter("escolaridade");
            String tempo_experiencia = request.getParameter("tempo_experiencia");
            String telefone = request.getParameter("telefone");
            String email = request.getParameter("email");
            String area_interesse1 = request.getParameter("area_interesse1");
            String area_interesse2 = request.getParameter("area_interesse2");
            String area_interesse3 = request.getParameter("area_interesse3");
            String hobbie = request.getParameter("hobbie");
            //Cria lista de ids das habilidades (checkbox)
            String[] habs = request.getParameterValues("habilidades");
            //Atribui variaveis para candidato
            cand.setId(id);
            cand.setNome(nome);
            cand.setCpf(cpf);
            cand.setRg(rg);
            cand.setDataNascimento(Date.valueOf(data_nascimento));
            cand.setAreaAtuacao(area_atuacao);
            cand.setEscolaridade(escolaridade);
            cand.setTempoExperiencia(tempo_experiencia);
            cand.setTelefone(telefone);
            cand.setEmail(email);
            cand.setAreaInteresse1(area_interesse1);
            cand.setAreaInteresse2(area_interesse2);
            cand.setAreaInteresse3(area_interesse3);
            cand.setHobbie(hobbie);
            //Cria lista de habilidades
            List<Habilidade> habsCand= new ArrayList<Habilidade>();
            DAOHabilidade daoHab= new DAOHabilidade();
            for (String h : habs) {
                int idHab= Integer.valueOf(h);
                //Busca a habilidade correspondente ao id
                Habilidade hab= daoHab.listByIdUnico(idHab);
                habsCand.add(hab);
            }
            //Atribui lista de habilidades ao candidato
            cand.setHabilidadeList(habsCand);
            dao.inserir(cand);

            //Envia email de confirmação
            //EnviaEmail tool= new EnviaEmail(cand);
            
            //Redireciona
            response.sendRedirect("candidato.jsp");
            
        } else if ("Atualizar".equals(op)) {
            //Atribui cada parametro a respectiva variavel
            int id = Integer.valueOf(request.getParameter("id"));
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String rg = request.getParameter("rg");
            String data_nascimento = request.getParameter("data_nascimento");
            String area_atuacao = request.getParameter("area_atuacao");
            String escolaridade = request.getParameter("escolaridade");
            String tempo_experiencia = request.getParameter("tempo_experiencia");
            String telefone = request.getParameter("telefone");
            String email = request.getParameter("email");
            String area_interesse1 = request.getParameter("area_interesse1");
            String area_interesse2 = request.getParameter("area_interesse2");
            String area_interesse3 = request.getParameter("area_interesse3");
            String hobbie = request.getParameter("hobbie");
            //Cria lista de ids das habilidades (checkbox)
            String[] habs = request.getParameterValues("habilidades");
            //Busca candidato
            cand = dao.listByIdUnico(id);
            //Atribui variaveis para candidato
            cand.setNome(nome);
            cand.setCpf(cpf);
            cand.setRg(rg);
            cand.setDataNascimento(Date.valueOf(data_nascimento));
            cand.setAreaAtuacao(area_atuacao);
            cand.setEscolaridade(escolaridade);
            cand.setTempoExperiencia(tempo_experiencia);
            cand.setTelefone(telefone);
            cand.setEmail(email);
            cand.setAreaInteresse1(area_interesse1);
            cand.setAreaInteresse2(area_interesse2);
            cand.setAreaInteresse3(area_interesse3);
            cand.setHobbie(hobbie);
            //Cria lista de habilidades
            List<Habilidade> habsCand= new ArrayList<Habilidade>();
            DAOHabilidade daoHab= new DAOHabilidade();
            for (String h : habs) {
                int idHab= Integer.valueOf(h);
                //Busca a habilidade correspondente ao id
                Habilidade hab= daoHab.listByIdUnico(idHab);
                habsCand.add(hab);
            }
            //Atribui lista de habilidades ao candidato
            cand.setHabilidadeList(habsCand);

            dao.atualizar(cand);
            //Redireciona
            response.sendRedirect("candidato.jsp");
            
        } else {
            String busca = request.getParameter("busca");
            //Redireciona com parametro de busca
            response.sendRedirect("candidatoBuscar.jsp?busca=" + busca);
        }
    }
}
