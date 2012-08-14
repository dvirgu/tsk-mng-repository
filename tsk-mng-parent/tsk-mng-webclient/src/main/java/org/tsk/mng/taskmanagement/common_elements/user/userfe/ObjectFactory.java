
package org.tsk.mng.taskmanagement.common_elements.user.userfe;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tsk.mng.taskmanagement.common_elements.user.userfe package. 
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

    private final static QName _UserFE_QNAME = new QName("http://mng.tsk.org/taskManagement/common_elements/user/userFE", "userFE");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tsk.mng.taskmanagement.common_elements.user.userfe
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UserFE }
     * 
     */
    public UserFE createUserFE() {
        return new UserFE();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserFE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/common_elements/user/userFE", name = "userFE")
    public JAXBElement<UserFE> createUserFE(UserFE value) {
        return new JAXBElement<UserFE>(_UserFE_QNAME, UserFE.class, null, value);
    }

}
