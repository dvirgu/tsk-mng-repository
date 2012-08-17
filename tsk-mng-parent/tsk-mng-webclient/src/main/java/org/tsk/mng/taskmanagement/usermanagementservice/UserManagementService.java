
/*
 * 
 */

package org.tsk.mng.taskmanagement.usermanagementservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.2
 * Fri Aug 17 17:15:00 IDT 2012
 * Generated source version: 2.2
 * 
 */


@WebServiceClient(name = "UserManagementService", 
                  wsdlLocation = "http://localhost:8080/TaskManagementService/services/UserManagementService?wsdl",
                  targetNamespace = "http://mng.tsk.org/taskManagement/UserManagementService/") 
public class UserManagementService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://mng.tsk.org/taskManagement/UserManagementService/", "UserManagementService");
    public final static QName UserManagementServicePort = new QName("http://mng.tsk.org/taskManagement/UserManagementService/", "UserManagementServicePort");
    static {
        URL url = null;
        try {
        	url = new URL("http://localhost:8080/tsk-mng-frontend-0.0.1-REVISION/services/UserManagementServicePort?wsdl");
//TODO            url = new URL("http://localhost:8080/TaskManagementService/services/UserManagementService?wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from http://localhost:8080/TaskManagementService/services/UserManagementService?wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public UserManagementService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public UserManagementService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UserManagementService() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns UserManagementServicePortType
     */
    @WebEndpoint(name = "UserManagementServicePort")
    public UserManagementServicePortType getUserManagementServicePort() {
        return super.getPort(UserManagementServicePort, UserManagementServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UserManagementServicePortType
     */
    @WebEndpoint(name = "UserManagementServicePort")
    public UserManagementServicePortType getUserManagementServicePort(WebServiceFeature... features) {
        return super.getPort(UserManagementServicePort, UserManagementServicePortType.class, features);
    }

}
