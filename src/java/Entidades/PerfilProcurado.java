/*
 * Classe gerada pelo Netbeans.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author zorawski
 */
@Entity
@Table(name = "perfil_procurado")
@NamedQueries({
    @NamedQuery(name = "PerfilProcurado.findAll", query = "SELECT p FROM PerfilProcurado p")
    , @NamedQuery(name = "PerfilProcurado.findById", query = "SELECT p FROM PerfilProcurado p WHERE p.id = :id")
    , @NamedQuery(name = "PerfilProcurado.findByAreaAtuacao", query = "SELECT p FROM PerfilProcurado p WHERE p.areaAtuacao = :areaAtuacao")
    , @NamedQuery(name = "PerfilProcurado.findByEscolaridade", query = "SELECT p FROM PerfilProcurado p WHERE p.escolaridade = :escolaridade")
    , @NamedQuery(name = "PerfilProcurado.findByQuantVagas", query = "SELECT p FROM PerfilProcurado p WHERE p.quantVagas = :quantVagas")
    , @NamedQuery(name = "PerfilProcurado.findByFaixaEtaria", query = "SELECT p FROM PerfilProcurado p WHERE p.faixaEtaria = :faixaEtaria")
    , @NamedQuery(name = "PerfilProcurado.findByTempoExperiencia", query = "SELECT p FROM PerfilProcurado p WHERE p.tempoExperiencia = :tempoExperiencia")})
public class PerfilProcurado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "area_atuacao")
    private String areaAtuacao;
    @Basic(optional = false)
    @Column(name = "escolaridade")
    private String escolaridade;
    @Basic(optional = false)
    @Column(name = "quant_vagas")
    private int quantVagas;
    @Column(name = "faixa_etaria")
    private String faixaEtaria;
    @Column(name = "tempo_experiencia")
    private String tempoExperiencia;
    @JoinTable(name = "habilidades_perfil_pp", joinColumns = {
        @JoinColumn(name = "id_perfil_pro", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "id_habilidade", referencedColumnName = "id")})
    @ManyToMany
    private List<Habilidade> habilidadeList;
    @JoinColumn(name = "id_empresa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empresa idEmpresa;

    public PerfilProcurado() {
    }

    public PerfilProcurado(Integer id) {
        this.id = id;
    }

    public PerfilProcurado(Integer id, String areaAtuacao, String escolaridade, int quantVagas) {
        this.id = id;
        this.areaAtuacao = areaAtuacao;
        this.escolaridade = escolaridade;
        this.quantVagas = quantVagas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public int getQuantVagas() {
        return quantVagas;
    }

    public void setQuantVagas(int quantVagas) {
        this.quantVagas = quantVagas;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getTempoExperiencia() {
        return tempoExperiencia;
    }

    public void setTempoExperiencia(String tempoExperiencia) {
        this.tempoExperiencia = tempoExperiencia;
    }

    public List<Habilidade> getHabilidadeList() {
        return habilidadeList;
    }

    public void setHabilidadeList(List<Habilidade> habilidadeList) {
        this.habilidadeList = habilidadeList;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
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
        if (!(object instanceof PerfilProcurado)) {
            return false;
        }
        PerfilProcurado other = (PerfilProcurado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.PerfilProcurado[ id=" + id + " ]";
    }
    
}
