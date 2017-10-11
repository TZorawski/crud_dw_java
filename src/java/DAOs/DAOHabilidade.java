package DAOs;


import Entidades.Habilidade;
import java.util.ArrayList;
import java.util.List;

public class DAOHabilidade extends DAOGenerico<Habilidade> {

    public DAOHabilidade() {
        super(Habilidade.class);
    }
    

    public List<Habilidade> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Habilidade e WHERE e.nome LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Habilidade> listById(int id) {
        return em.createQuery("SELECT e FROM Habilidade e WHERE e.id = :id").setParameter("id", id).getResultList();
    }
    
    public Habilidade listByIdUnico(int id) {//retorna uma habilidade
        List<Habilidade> lista=  em.createQuery("SELECT e FROM Habilidade e WHERE e.id = :id").setParameter("id", id).getResultList();
        //System.out.println("Lista byIdUnico: "+lista);
        Habilidade habilidade= new Habilidade();
        
        if (!lista.isEmpty()) {
            habilidade= lista.get(0);
        }else{
            habilidade= null;
        }
        
        return habilidade;
    }

    public List<Habilidade> listInOrderNome() {
        return em.createQuery("SELECT e FROM Habilidade e ORDER BY e.nome").getResultList();
    }

    public List<Habilidade> listHabilidade() {
        return em.createQuery("SELECT e FROM Habilidade e ").getResultList();
    }

    public List<String> getListaHabilidade() {
        List<Habilidade> lf = listHabilidade();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getId()+ " - "
                    + lf.get(i).getNome()
            );
        }
        return ls;
    }
    
    public List<String> getListaHabilidadeFormatada() {
        List<Habilidade> lf = listHabilidade();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(
                    lf.get(i).toString()
            );
        }
        return ls;
    }
    
        //esse método faz com que o BD seja "RE-lido".
//    public List<Habilidadescandidato> HabilidadescandidatoListExtra(int id) {
//        return em.createQuery("SELECT e FROM Habilidadescandidato e WHERE e.habilidadescandidatoPK.idCardapio = :id").
//                setParameter("id", id).getResultList();
//    }
}
