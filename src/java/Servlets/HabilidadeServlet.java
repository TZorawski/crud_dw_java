/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAOs.DAOGenerico;
import DAOs.DAOHabilidade;
import Entidades.Habilidade;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zorawski
 */
@WebServlet(name = "HabilidadeServlet", urlPatterns = {"/HabilidadeServlet"})
public class HabilidadeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOGenerico dao = new DAOGenerico(Habilidade.class);
        int id = Integer.parseInt(request.getParameter("id"));
        Habilidade hab = (Habilidade) dao.obter(id);
        dao.remover(hab);
        response.sendRedirect("habilidade.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        
        DAOHabilidade dao = new DAOHabilidade();
        Habilidade hab = new Habilidade();
        if ("Inserir".equals(op)) {
            int id = Integer.valueOf(request.getParameter("id"));
        String nome = request.getParameter("nome");
            hab.setId(id);
            hab.setNome(nome);

            dao.inserir(hab);
            response.sendRedirect("habilidade.jsp");
        }else if("Atualizar".equals(op)){
            int id = Integer.valueOf(request.getParameter("id"));
        String nome = request.getParameter("nome");
            hab= dao.listByIdUnico(id);
            hab.setNome(nome);
            
            dao.atualizar(hab);
            response.sendRedirect("habilidade.jsp");
        }else{
            String busca = request.getParameter("busca");
                        
            response.sendRedirect("habilidadeBuscar.jsp?busca="+busca);
        }
    }
}
