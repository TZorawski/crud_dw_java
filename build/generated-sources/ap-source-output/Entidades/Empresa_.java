package Entidades;

import Entidades.PerfilProcurado;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-12-12T11:37:30")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile SingularAttribute<Empresa, String> cidade;
    public static volatile SingularAttribute<Empresa, String> telefone;
    public static volatile SingularAttribute<Empresa, String> nomeFantasia;
    public static volatile SingularAttribute<Empresa, String> enderecoRua;
    public static volatile SingularAttribute<Empresa, Integer> id;
    public static volatile SingularAttribute<Empresa, String> cnpj;
    public static volatile SingularAttribute<Empresa, String> enderecoNum;
    public static volatile ListAttribute<Empresa, PerfilProcurado> perfilProcuradoList;
    public static volatile SingularAttribute<Empresa, String> razaoSocial;
    public static volatile SingularAttribute<Empresa, String> email;
    public static volatile SingularAttribute<Empresa, String> cep;

}