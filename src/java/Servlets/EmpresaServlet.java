/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAOs.DAOEmpresa;
import DAOs.DAOGenerico;
import Entidades.Empresa;
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
@WebServlet(name = "EmpresaServlet", urlPatterns = {"/EmpresaServlet"})
public class EmpresaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAOGenerico dao = new DAOGenerico(Empresa.class);
        int id = Integer.parseInt(request.getParameter("id"));
        Empresa emp = (Empresa) dao.obter(id);
        dao.remover(emp);
        response.sendRedirect("empresa.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");

        DAOEmpresa dao = new DAOEmpresa();
        Empresa emp = new Empresa();

        if ("Inserir".equals(op)) {
            int id = Integer.valueOf(request.getParameter("id"));
            String cnpj = request.getParameter("cnpj");
            String razao_social = request.getParameter("razao_social");
            String nome_fantasia = request.getParameter("nome_fantasia");
            String endereco_rua = request.getParameter("endereco_rua");
            String endereco_num = request.getParameter("endereco_num");
            String cidade = request.getParameter("cidade");
            String cep = request.getParameter("cep");
            String telefone = request.getParameter("telefone");
            String email = request.getParameter("email");
            emp.setId(id);
            emp.setCnpj(cnpj);
            emp.setRazaoSocial(razao_social);
            emp.setNomeFantasia(nome_fantasia);
            emp.setEnderecoRua(endereco_rua);
            emp.setEnderecoNum(endereco_num);
            emp.setCidade(cidade);
            emp.setCep(cep);
            emp.setTelefone(telefone);
            emp.setEmail(email);

            dao.inserir(emp);
            response.sendRedirect("empresa.jsp");
        } else if ("Atualizar".equals(op)) {
            int id = Integer.valueOf(request.getParameter("id"));
            String cnpj = request.getParameter("cnpj");
            String razao_social = request.getParameter("razao_social");
            String nome_fantasia = request.getParameter("nome_fantasia");
            String endereco_rua = request.getParameter("endereco_rua");
            String endereco_num = request.getParameter("endereco_num");
            String cidade = request.getParameter("cidade");
            String cep = request.getParameter("cep");
            String telefone = request.getParameter("telefone");
            String email = request.getParameter("email");
            emp = dao.listByIdUnico(id);
            emp.setCnpj(cnpj);
            emp.setRazaoSocial(razao_social);
            emp.setNomeFantasia(nome_fantasia);
            emp.setEnderecoRua(endereco_rua);
            emp.setEnderecoNum(endereco_num);
            emp.setCidade(cidade);
            emp.setCep(cep);
            emp.setTelefone(telefone);
            emp.setEmail(email);

            dao.atualizar(emp);
            response.sendRedirect("empresa.jsp");
        } else {
            String busca = request.getParameter("busca");

            response.sendRedirect("empresaBuscar.jsp?busca=" + busca);
        }

    }
}
