package Entidades;

import Entidades.Habilidade;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T11:37:30")
@StaticMetamodel(Candidato.class)
public class Candidato_ { 

    public static volatile SingularAttribute<Candidato, String> areaInteresse3;
    public static volatile SingularAttribute<Candidato, String> hobbie;
    public static volatile SingularAttribute<Candidato, String> telefone;
    public static volatile SingularAttribute<Candidato, String> areaInteresse1;
    public static volatile SingularAttribute<Candidato, String> areaInteresse2;
    public static volatile SingularAttribute<Candidato, String> nome;
    public static volatile SingularAttribute<Candidato, String> rg;
    public static volatile SingularAttribute<Candidato, String> areaAtuacao;
    public static volatile SingularAttribute<Candidato, String> cpf;
    public static volatile SingularAttribute<Candidato, String> tempoExperiencia;
    public static volatile SingularAttribute<Candidato, Integer> id;
    public static volatile SingularAttribute<Candidato, String> escolaridade;
    public static volatile SingularAttribute<Candidato, Date> dataNascimento;
    public static volatile ListAttribute<Candidato, Habilidade> habilidadeList;
    public static volatile SingularAttribute<Candidato, String> email;

}