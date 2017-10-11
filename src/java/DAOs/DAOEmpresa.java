package DAOs;


import Entidades.Empresa;
import java.util.ArrayList;
import java.util.List;

public class DAOEmpresa extends DAOGenerico<Empresa> {

    public DAOEmpresa() {
        super(Empresa.class);
    }
    

    public List<Empresa> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Empresa e WHERE e.nome LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }
    
    public List<Empresa> listByNomeFantasia(String nome) {
        return em.createQuery("SELECT e FROM Empresa e WHERE e.nomeFantasia LIKE :nomeFantasia").setParameter("nomeFantasia", "%" + nome + "%").getResultList();
    }

    public List<Empresa> listById(int id) {
        return em.createQuery("SELECT e FROM Empresa e WHERE e.id = :id").setParameter("id", id).getResultList();
    }
    
    public List<String> listCnpjs() {
        return em.createQuery("SELECT e.cnpj FROM Empresa e").getResultList();
    }
    
    public Empresa listByIdUnico(int id) {//retorna uma empresa
        List<Empresa> lista=  em.createQuery("SELECT e FROM Empresa e WHERE e.id = :id").setParameter("id", id).getResultList();
        System.out.println("Lista byIdUnico: "+lista);
        Empresa empresa= new Empresa();
        
        if (!lista.isEmpty()) {
            empresa= lista.get(0);
        }else{
            empresa= null;
        }
        
        return empresa;
    }

    public List<Empresa> listInOrderNome() {
        return em.createQuery("SELECT e FROM Empresa e ORDER BY e.nome").getResultList();
    }

    public List<Empresa> listEmpresa() {
        return em.createQuery("SELECT e FROM Empresa e ").getResultList();
    }

    public List<String> getListaEmpresa() {
        List<Empresa> lf = listEmpresa();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getId()+ " - "
                    + lf.get(i).getRazaoSocial()
            );
        }
        return ls;
    }
    
    public List<String> getListaEmpresaFormatada() {
        List<Empresa> lf = listEmpresa();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(
                    lf.get(i).toString()
            );
        }
        return ls;
    }
}
