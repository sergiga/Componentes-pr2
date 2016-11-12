package dominio;

import dominio.Configuracionpc;
import dominio.Empresa;
import dominio.Estadoventapcs;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-12T13:26:32")
@StaticMetamodel(Pedidopc.class)
public class Pedidopc_ { 

    public static volatile SingularAttribute<Pedidopc, Configuracionpc> configuracionsolicitada;
    public static volatile SingularAttribute<Pedidopc, Empresa> encargadopor;
    public static volatile SingularAttribute<Pedidopc, Estadoventapcs> estado;
    public static volatile SingularAttribute<Pedidopc, Integer> idpedido;
    public static volatile SingularAttribute<Pedidopc, Integer> cantidadsolicitada;

}