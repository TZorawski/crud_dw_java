/*
 * Classe gerada pelo Netbeans.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author zorawski
 */
@Entity
@Table(name = "Habilidade")
@NamedQueries({
    @NamedQuery(name = "Habilidade.findAll", query = "SELECT h FROM Habilidade h")
    , @NamedQuery(name = "Habilidade.findById", query = "SELECT h FROM Habilidade h WHERE h.id = :id")
    , @NamedQuery(name = "Habilidade.findByNome", query = "SELECT h FROM Habilidade h WHERE h.nome = :nome")})
public class Habilidade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @ManyToMany(mappedBy = "habilidadeList")
    private List<Candidato> candidatoList;
    @ManyToMany(mappedBy = "habilidadeList")
    private List<PerfilProcurado> perfilProcuradoList;

    public Habilidade() {
    }

    public Habilidade(Integer id) {
        this.id = id;
    }

    public Habilidade(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Candidato> getCandidatoList() {
        return candidatoList;
    }

    public void setCandidatoList(List<Candidato> candidatoList) {
        this.candidatoList = candidatoList;
    }

    public List<PerfilProcurado> getPerfilProcuradoList() {
        return perfilProcuradoList;
    }

    public void setPerfilProcuradoList(List<PerfilProcurado> perfilProcuradoList) {
        this.perfilProcuradoList = perfilProcuradoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Habilidade)) {
            return false;
        }
        Habilidade other = (Habilidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
}
