package Entidades;

import Entidades.Empresa;
import Entidades.Habilidade;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T11:37:30")
@StaticMetamodel(PerfilProcurado.class)
public class PerfilProcurado_ { 

    public static volatile SingularAttribute<PerfilProcurado, String> faixaEtaria;
    public static volatile SingularAttribute<PerfilProcurado, String> areaAtuacao;
    public static volatile SingularAttribute<PerfilProcurado, Integer> quantVagas;
    public static volatile SingularAttribute<PerfilProcurado, String> tempoExperiencia;
    public static volatile SingularAttribute<PerfilProcurado, Empresa> idEmpresa;
    public static volatile SingularAttribute<PerfilProcurado, Integer> id;
    public static volatile SingularAttribute<PerfilProcurado, String> escolaridade;
    public static volatile ListAttribute<PerfilProcurado, Habilidade> habilidadeList;

}