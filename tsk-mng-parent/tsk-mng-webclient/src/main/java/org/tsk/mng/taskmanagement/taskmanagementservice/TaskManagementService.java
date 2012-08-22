
/*
 * 
 */

package org.tsk.mng.taskmanagement.taskmanagementservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.2
 * Wed Aug 22 00:09:44 IDT 2012
 * Generated source version: 2.2
 * 
 */


@WebServiceClient(name = "TaskManagementService", 
                  wsdlLocation = "http://localhost:8080/tsk-mng-frontend-0.0.1-REVISION/services/TaskManagementServicePort?wsdl",
                  targetNamespace = "http://mng.tsk.org/taskManagement/TaskManagementService/") 
public class TaskManagementService extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://mng.tsk.org/taskManagement/TaskManagementService/", "TaskManagementService");
    public final static QName TaskManagementServicePort = new QName("http://mng.tsk.org/taskManagement/TaskManagementService/", "TaskManagementServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/tsk-mng-frontend-0.0.1-REVISION/services/TaskManagementServicePort?wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from http://localhost:8080/tsk-mng-frontend-0.0.1-REVISION/services/TaskManagementServicePort?wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public TaskManagementService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TaskManagementService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TaskManagementService() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns TaskManagementServicePortType
     */
    @WebEndpoint(name = "TaskManagementServicePort")
    public TaskManagementServicePortType getTaskManagementServicePort() {
        return super.getPort(TaskManagementServicePort, TaskManagementServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TaskManagementServicePortType
     */
    @WebEndpoint(name = "TaskManagementServicePort")
    public TaskManagementServicePortType getTaskManagementServicePort(WebServiceFeature... features) {
        return super.getPort(TaskManagementServicePort, TaskManagementServicePortType.class, features);
    }

}
