package dominio;

import dominio.Cpu;
import dominio.Descripcioncomponente;
import dominio.Pedidopc;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-12T13:26:32")
@StaticMetamodel(Configuracionpc.class)
public class Configuracionpc_ { 

    public static volatile SingularAttribute<Configuracionpc, Integer> idconfiguracion;
    public static volatile ListAttribute<Configuracionpc, Descripcioncomponente> descripcioncomponenteList;
    public static volatile ListAttribute<Configuracionpc, Pedidopc> pedidopcList;
    public static volatile SingularAttribute<Configuracionpc, Double> velocidadcpu;
    public static volatile SingularAttribute<Configuracionpc, Cpu> tipocpu;
    public static volatile SingularAttribute<Configuracionpc, Double> velocidadtarjetagrafica;
    public static volatile SingularAttribute<Configuracionpc, Integer> capacidadram;
    public static volatile SingularAttribute<Configuracionpc, Integer> capacidaddd;
    public static volatile SingularAttribute<Configuracionpc, Integer> memoriatarjetagrafica;

}