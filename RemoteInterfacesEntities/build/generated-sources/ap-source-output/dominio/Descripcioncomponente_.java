package dominio;

import dominio.Configuracionpc;
import dominio.Tipocomponente;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-12T13:40:50")
@StaticMetamodel(Descripcioncomponente.class)
public class Descripcioncomponente_ { 

    public static volatile SingularAttribute<Descripcioncomponente, String> marca;
    public static volatile SingularAttribute<Descripcioncomponente, Integer> iddescripcion;
    public static volatile SingularAttribute<Descripcioncomponente, Integer> precio;
    public static volatile SingularAttribute<Descripcioncomponente, Tipocomponente> tipo;
    public static volatile ListAttribute<Descripcioncomponente, Configuracionpc> configuracionpcList;
    public static volatile SingularAttribute<Descripcioncomponente, String> modelo;
    public static volatile SingularAttribute<Descripcioncomponente, String> caracteristicastecnicas;

}