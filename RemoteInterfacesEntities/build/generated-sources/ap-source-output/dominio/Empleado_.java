package dominio;

import dominio.Rolempleado;
import dominio.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-13T19:45:02")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> nifcif;
    public static volatile SingularAttribute<Empleado, Usuario> usuario;
    public static volatile SingularAttribute<Empleado, Date> fechacontratacion;
    public static volatile SingularAttribute<Empleado, Rolempleado> rol;

}