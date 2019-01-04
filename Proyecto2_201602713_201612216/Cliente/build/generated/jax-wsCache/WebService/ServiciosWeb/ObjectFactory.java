
package ServiciosWeb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ServiciosWeb package. 
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

    private final static QName _CargarResponse_QNAME = new QName("http://ServiciosWeb/", "CargarResponse");
    private final static QName _Cargar_QNAME = new QName("http://ServiciosWeb/", "Cargar");
    private final static QName _InicioSesion_QNAME = new QName("http://ServiciosWeb/", "InicioSesion");
    private final static QName _InicioSesionResponse_QNAME = new QName("http://ServiciosWeb/", "InicioSesionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ServiciosWeb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InicioSesionResponse }
     * 
     */
    public InicioSesionResponse createInicioSesionResponse() {
        return new InicioSesionResponse();
    }

    /**
     * Create an instance of {@link Cargar }
     * 
     */
    public Cargar createCargar() {
        return new Cargar();
    }

    /**
     * Create an instance of {@link InicioSesion }
     * 
     */
    public InicioSesion createInicioSesion() {
        return new InicioSesion();
    }

    /**
     * Create an instance of {@link CargarResponse }
     * 
     */
    public CargarResponse createCargarResponse() {
        return new CargarResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CargarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ServiciosWeb/", name = "CargarResponse")
    public JAXBElement<CargarResponse> createCargarResponse(CargarResponse value) {
        return new JAXBElement<CargarResponse>(_CargarResponse_QNAME, CargarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Cargar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ServiciosWeb/", name = "Cargar")
    public JAXBElement<Cargar> createCargar(Cargar value) {
        return new JAXBElement<Cargar>(_Cargar_QNAME, Cargar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InicioSesion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ServiciosWeb/", name = "InicioSesion")
    public JAXBElement<InicioSesion> createInicioSesion(InicioSesion value) {
        return new JAXBElement<InicioSesion>(_InicioSesion_QNAME, InicioSesion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InicioSesionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ServiciosWeb/", name = "InicioSesionResponse")
    public JAXBElement<InicioSesionResponse> createInicioSesionResponse(InicioSesionResponse value) {
        return new JAXBElement<InicioSesionResponse>(_InicioSesionResponse_QNAME, InicioSesionResponse.class, null, value);
    }

}
