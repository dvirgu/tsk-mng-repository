
package org.tsk.mng.taskmanagement.header.soapheader;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tsk.mng.taskmanagement.header.soapheader package. 
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

    private final static QName _UserAuthInfo_QNAME = new QName("http://mng.tsk.org/taskManagement/header/soapHeader", "userAuthInfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tsk.mng.taskmanagement.header.soapheader
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UserAuthInfo }
     * 
     */
    public UserAuthInfo createUserAuthInfo() {
        return new UserAuthInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserAuthInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/header/soapHeader", name = "userAuthInfo")
    public JAXBElement<UserAuthInfo> createUserAuthInfo(UserAuthInfo value) {
        return new JAXBElement<UserAuthInfo>(_UserAuthInfo_QNAME, UserAuthInfo.class, null, value);
    }

}
