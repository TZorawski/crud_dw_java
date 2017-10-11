package DAOs;


import Entidades.PerfilProcurado;
import java.util.ArrayList;
import java.util.List;

public class DAOPerfilprocurado extends DAOGenerico<PerfilProcurado> {

    public DAOPerfilprocurado() {
        super(PerfilProcurado.class);
    }
    

//    public List<Perfilprocurado> listByNome(String nome) {
//        return em.createQuery("SELECT e FROM Perfil_procurado e WHERE e.nome LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
//    }

    public List<PerfilProcurado> listById(int id) {
        return em.createQuery("SELECT e FROM Perfilprocurado e WHERE e.id = :id").setParameter("id", id).getResultList();
    }
    
    public List<PerfilProcurado> listBusca(String busca) {
        return em.createQuery("SELECT e FROM Perfilprocurado e WHERE e.Area_atuacao = :Area_atuacao").setParameter("Area_atuacao", busca).getResultList();
    }
    
    public PerfilProcurado listByIdUnico(int id) {//retorna um funcionario procurado
        List<PerfilProcurado> lista=  em.createQuery("SELECT e FROM Perfilprocurado e WHERE e.id = :id").setParameter("id", id).getResultList();
        //System.out.println("Lista byIdUnico: "+lista);
        PerfilProcurado funcProcurado= new PerfilProcurado();
        
        if (!lista.isEmpty()) {
            funcProcurado= lista.get(0);
        }else{
            funcProcurado= null;
        }
        
        return funcProcurado;
    }

//    public List<Perfilprocurado> listInOrderNome() {
//        return em.createQuery("SELECT e FROM Perfilprocurado e ORDER BY e.nome").getResultList();
//    }

    public List<PerfilProcurado> listPerfilprocurado() {
        return em.createQuery("SELECT e FROM Perfilprocurado e ").getResultList();
    }

    public List<String> getListaPerfilprocurado() {
        List<PerfilProcurado> lf = listPerfilprocurado();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getId()+ " - Perfil procurado: "
                    + lf.get(i).getIdEmpresa()
            );
        }
        return ls;
    }
    
    public List<String> getListaPerfilprocuradoFormatada() {
        List<PerfilProcurado> lf = listPerfilprocurado();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(
                    lf.get(i).toString()
            );
        }
        return ls;
    }
}
