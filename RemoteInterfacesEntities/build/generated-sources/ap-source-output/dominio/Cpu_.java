package dominio;

import dominio.Configuracionpc;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-13T19:45:02")
@StaticMetamodel(Cpu.class)
public class Cpu_ { 

    public static volatile SingularAttribute<Cpu, String> nombretipocpu;
    public static volatile ListAttribute<Cpu, Configuracionpc> configuracionpcList;
    public static volatile SingularAttribute<Cpu, Short> idtipocpu;

}