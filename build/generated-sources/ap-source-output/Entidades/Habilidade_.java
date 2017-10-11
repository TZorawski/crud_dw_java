package Entidades;

import Entidades.Candidato;
import Entidades.PerfilProcurado;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T11:37:30")
@StaticMetamodel(Habilidade.class)
public class Habilidade_ { 

    public static volatile SingularAttribute<Habilidade, String> nome;
    public static volatile SingularAttribute<Habilidade, Integer> id;
    public static volatile ListAttribute<Habilidade, PerfilProcurado> perfilProcuradoList;
    public static volatile ListAttribute<Habilidade, Candidato> candidatoList;

}