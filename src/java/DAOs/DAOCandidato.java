package DAOs;


import Entidades.Candidato;
//import Entidades.Habilidadescandidato;
import java.util.ArrayList;
import java.util.List;

public class DAOCandidato extends DAOGenerico<Candidato> {

    public DAOCandidato() {
        super(Candidato.class);
    }
    

    public List<Candidato> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Candidato e WHERE e.nome LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Candidato> listById(int id) {
        return em.createQuery("SELECT e FROM Candidato e WHERE e.id = :id").setParameter("id", id).getResultList();
    }
    
    public List<String> listCpfs() {
        return em.createQuery("SELECT e.cpf FROM Candidato e").getResultList();
    }
    
    public Candidato listByIdUnico(int id) {//retorna uma areasinteresse
        List<Candidato> lista=  em.createQuery("SELECT e FROM Candidato e WHERE e.id = :id").setParameter("id", id).getResultList();
        //System.out.println("Lista byIdUnico: "+lista);
        Candidato candidato= new Candidato();
        
        if (lista.size()!=0) {
            candidato= lista.get(0);
        }else{
            candidato= null;
        }
        
        return candidato;
    }

    public List<Candidato> listInOrderNome() {
        return em.createQuery("SELECT e FROM Candidato e ORDER BY e.nome").getResultList();
    }

    public List<Candidato> listCandidato() {
        return em.createQuery("SELECT e FROM Candidato e ").getResultList();
    }

    public List<String> getListaCandidato() {
        List<Candidato> lf = listCandidato();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getId()+ " - Candidato: "
                    + lf.get(i).getNome()
            );
        }
        return ls;
    }
    
    public List<String> getListaCandidatoFormatada() {
        List<Candidato> lf = listCandidato();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(
                    lf.get(i).toString()
            );
        }
        return ls;
    }
    
}
