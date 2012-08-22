
package org.tsk.mng.taskmanagement.common_elements.resultbase;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tsk.mng.taskmanagement.common_elements.resultbase package. 
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

    private final static QName _ResultBase_QNAME = new QName("http://mng.tsk.org/taskManagement/common_elements/resultBase", "resultBase");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tsk.mng.taskmanagement.common_elements.resultbase
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ResultBase }
     * 
     */
    public ResultBase createResultBase() {
        return new ResultBase();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResultBase }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://mng.tsk.org/taskManagement/common_elements/resultBase", name = "resultBase")
    public JAXBElement<ResultBase> createResultBase(ResultBase value) {
        return new JAXBElement<ResultBase>(_ResultBase_QNAME, ResultBase.class, null, value);
    }

}
