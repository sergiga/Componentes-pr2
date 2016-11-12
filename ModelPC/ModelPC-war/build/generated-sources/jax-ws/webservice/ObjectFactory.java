
package webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCatalogoResponse_QNAME = new QName("http://webservice/", "getCatalogoResponse");
    private final static QName _GetConfiguracionResponse_QNAME = new QName("http://webservice/", "getConfiguracionResponse");
    private final static QName _GetCatalogo_QNAME = new QName("http://webservice/", "getCatalogo");
    private final static QName _GetConfiguracion_QNAME = new QName("http://webservice/", "getConfiguracion");
    private final static QName _Cpu_QNAME = new QName("http://webservice/", "cpu");
    private final static QName _AddConfiguracion_QNAME = new QName("http://webservice/", "addConfiguracion");
    private final static QName _Configuracionpc_QNAME = new QName("http://webservice/", "configuracionpc");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetConfiguracionResponse }
     * 
     */
    public GetConfiguracionResponse createGetConfiguracionResponse() {
        return new GetConfiguracionResponse();
    }

    /**
     * Create an instance of {@link GetCatalogoResponse }
     * 
     */
    public GetCatalogoResponse createGetCatalogoResponse() {
        return new GetCatalogoResponse();
    }

    /**
     * Create an instance of {@link Cpu }
     * 
     */
    public Cpu createCpu() {
        return new Cpu();
    }

    /**
     * Create an instance of {@link GetCatalogo }
     * 
     */
    public GetCatalogo createGetCatalogo() {
        return new GetCatalogo();
    }

    /**
     * Create an instance of {@link GetConfiguracion }
     * 
     */
    public GetConfiguracion createGetConfiguracion() {
        return new GetConfiguracion();
    }

    /**
     * Create an instance of {@link Configuracionpc }
     * 
     */
    public Configuracionpc createConfiguracionpc() {
        return new Configuracionpc();
    }

    /**
     * Create an instance of {@link AddConfiguracion }
     * 
     */
    public AddConfiguracion createAddConfiguracion() {
        return new AddConfiguracion();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCatalogoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getCatalogoResponse")
    public JAXBElement<GetCatalogoResponse> createGetCatalogoResponse(GetCatalogoResponse value) {
        return new JAXBElement<GetCatalogoResponse>(_GetCatalogoResponse_QNAME, GetCatalogoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConfiguracionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getConfiguracionResponse")
    public JAXBElement<GetConfiguracionResponse> createGetConfiguracionResponse(GetConfiguracionResponse value) {
        return new JAXBElement<GetConfiguracionResponse>(_GetConfiguracionResponse_QNAME, GetConfiguracionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCatalogo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getCatalogo")
    public JAXBElement<GetCatalogo> createGetCatalogo(GetCatalogo value) {
        return new JAXBElement<GetCatalogo>(_GetCatalogo_QNAME, GetCatalogo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetConfiguracion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getConfiguracion")
    public JAXBElement<GetConfiguracion> createGetConfiguracion(GetConfiguracion value) {
        return new JAXBElement<GetConfiguracion>(_GetConfiguracion_QNAME, GetConfiguracion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cpu }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "cpu")
    public JAXBElement<Cpu> createCpu(Cpu value) {
        return new JAXBElement<Cpu>(_Cpu_QNAME, Cpu.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddConfiguracion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "addConfiguracion")
    public JAXBElement<AddConfiguracion> createAddConfiguracion(AddConfiguracion value) {
        return new JAXBElement<AddConfiguracion>(_AddConfiguracion_QNAME, AddConfiguracion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Configuracionpc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "configuracionpc")
    public JAXBElement<Configuracionpc> createConfiguracionpc(Configuracionpc value) {
        return new JAXBElement<Configuracionpc>(_Configuracionpc_QNAME, Configuracionpc.class, null, value);
    }

}
