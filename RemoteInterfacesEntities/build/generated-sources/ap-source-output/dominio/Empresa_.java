package dominio;

import dominio.Pedidopc;
import dominio.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-12T13:40:50")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile ListAttribute<Empresa, Pedidopc> pedidopcList;
    public static volatile SingularAttribute<Empresa, String> nifcif;
    public static volatile SingularAttribute<Empresa, Usuario> usuario;
    public static volatile SingularAttribute<Empresa, Short> esproveedor;
    public static volatile SingularAttribute<Empresa, Short> escliente;

}