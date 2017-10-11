/*
 * Classe gerada pelo Netbeans.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author zorawski
 */
@Entity
@Table(name = "Candidato")
@NamedQueries({
    @NamedQuery(name = "Candidato.findAll", query = "SELECT c FROM Candidato c")
    , @NamedQuery(name = "Candidato.findById", query = "SELECT c FROM Candidato c WHERE c.id = :id")
    , @NamedQuery(name = "Candidato.findByNome", query = "SELECT c FROM Candidato c WHERE c.nome = :nome")
    , @NamedQuery(name = "Candidato.findByCpf", query = "SELECT c FROM Candidato c WHERE c.cpf = :cpf")
    , @NamedQuery(name = "Candidato.findByRg", query = "SELECT c FROM Candidato c WHERE c.rg = :rg")
    , @NamedQuery(name = "Candidato.findByDataNascimento", query = "SELECT c FROM Candidato c WHERE c.dataNascimento = :dataNascimento")
    , @NamedQuery(name = "Candidato.findByAreaAtuacao", query = "SELECT c FROM Candidato c WHERE c.areaAtuacao = :areaAtuacao")
    , @NamedQuery(name = "Candidato.findByEscolaridade", query = "SELECT c FROM Candidato c WHERE c.escolaridade = :escolaridade")
    , @NamedQuery(name = "Candidato.findByTelefone", query = "SELECT c FROM Candidato c WHERE c.telefone = :telefone")
    , @NamedQuery(name = "Candidato.findByEmail", query = "SELECT c FROM Candidato c WHERE c.email = :email")
    , @NamedQuery(name = "Candidato.findByTempoExperiencia", query = "SELECT c FROM Candidato c WHERE c.tempoExperiencia = :tempoExperiencia")
    , @NamedQuery(name = "Candidato.findByAreaInteresse1", query = "SELECT c FROM Candidato c WHERE c.areaInteresse1 = :areaInteresse1")
    , @NamedQuery(name = "Candidato.findByAreaInteresse2", query = "SELECT c FROM Candidato c WHERE c.areaInteresse2 = :areaInteresse2")
    , @NamedQuery(name = "Candidato.findByAreaInteresse3", query = "SELECT c FROM Candidato c WHERE c.areaInteresse3 = :areaInteresse3")
    , @NamedQuery(name = "Candidato.findByHobbie", query = "SELECT c FROM Candidato c WHERE c.hobbie = :hobbie")})
public class Candidato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "rg")
    private String rg;
    @Basic(optional = false)
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataNascimento;
    @Basic(optional = false)
    @Column(name = "area_atuacao")
    private String areaAtuacao;
    @Basic(optional = false)
    @Column(name = "escolaridade")
    private String escolaridade;
    @Basic(optional = false)
    @Column(name = "telefone")
    private String telefone;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "tempo_experiencia")
    private String tempoExperiencia;
    @Basic(optional = false)
    @Column(name = "area_interesse1")
    private String areaInteresse1;
    @Column(name = "area_interesse2")
    private String areaInteresse2;
    @Column(name = "area_interesse3")
    private String areaInteresse3;
    @Column(name = "hobbie")
    private String hobbie;
    @JoinTable(name = "Habilidades_candidato", joinColumns = {
        @JoinColumn(name = "id_candidato", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "id_habilidade", referencedColumnName = "id")})
    @ManyToMany
    private List<Habilidade> habilidadeList;

    public Candidato() {
    }

    public Candidato(Integer id) {
        this.id = id;
    }

    public Candidato(Integer id, String nome, String cpf, String rg, Date dataNascimento, String areaAtuacao, String escolaridade, String telefone, String email, String tempoExperiencia, String areaInteresse1) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.areaAtuacao = areaAtuacao;
        this.escolaridade = escolaridade;
        this.telefone = telefone;
        this.email = email;
        this.tempoExperiencia = tempoExperiencia;
        this.areaInteresse1 = areaInteresse1;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTempoExperiencia() {
        return tempoExperiencia;
    }

    public void setTempoExperiencia(String tempoExperiencia) {
        this.tempoExperiencia = tempoExperiencia;
    }

    public String getAreaInteresse1() {
        return areaInteresse1;
    }

    public void setAreaInteresse1(String areaInteresse1) {
        this.areaInteresse1 = areaInteresse1;
    }

    public String getAreaInteresse2() {
        return areaInteresse2;
    }

    public void setAreaInteresse2(String areaInteresse2) {
        this.areaInteresse2 = areaInteresse2;
    }

    public String getAreaInteresse3() {
        return areaInteresse3;
    }

    public void setAreaInteresse3(String areaInteresse3) {
        this.areaInteresse3 = areaInteresse3;
    }

    public String getHobbie() {
        return hobbie;
    }

    public void setHobbie(String hobbie) {
        this.hobbie = hobbie;
    }

    public List<Habilidade> getHabilidadeList() {
        return habilidadeList;
    }

    public void setHabilidadeList(List<Habilidade> habilidadeList) {
        this.habilidadeList = habilidadeList;
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
        if (!(object instanceof Candidato)) {
            return false;
        }
        Candidato other = (Candidato) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Candidato[ id=" + id + " ]";
    }
    
}
