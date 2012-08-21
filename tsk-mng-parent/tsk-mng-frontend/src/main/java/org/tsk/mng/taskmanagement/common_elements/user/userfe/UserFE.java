
package org.tsk.mng.taskmanagement.common_elements.user.userfe;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.tsk.mng.taskmanagement.common_elements.task.taskfe.TaskFE;


/**
 * <p>Java class for userFE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="userFE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nickName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tasks" type="{http://mng.tsk.org/taskManagement/common_elements/task/taskFE}taskFE" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="superiors" type="{http://mng.tsk.org/taskManagement/common_elements/user/userFE}userFE" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="workers" type="{http://mng.tsk.org/taskManagement/common_elements/user/userFE}userFE" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="permission" type="{http://mng.tsk.org/taskManagement/common_elements/user/userFE}PermissionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "userFE", propOrder = {
    "mail",
    "firstName",
    "lastName",
    "nickName",
    "tasks",
    "superiors",
    "workers",
    "password",
    "permission"
})
public class UserFE {

    @XmlElement(required = true)
    protected String mail;
    @XmlElement(required = true)
    protected String firstName;
    @XmlElement(required = true)
    protected String lastName;
    @XmlElement(required = true)
    protected String nickName;
    protected List<TaskFE> tasks;
    protected List<UserFE> superiors;
    protected List<UserFE> workers;
    @XmlElement(required = true)
    protected String password;
    @XmlElement(required = true)
    protected PermissionType permission;

    /**
     * Gets the value of the mail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMail() {
        return mail;
    }

    /**
     * Sets the value of the mail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMail(String value) {
        this.mail = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the nickName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Sets the value of the nickName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickName(String value) {
        this.nickName = value;
    }

    /**
     * Gets the value of the tasks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tasks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTasks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaskFE }
     * 
     * 
     */
    public List<TaskFE> getTasks() {
        if (tasks == null) {
            tasks = new ArrayList<TaskFE>();
        }
        return this.tasks;
    }

    /**
     * Gets the value of the superiors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the superiors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSuperiors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserFE }
     * 
     * 
     */
    public List<UserFE> getSuperiors() {
        if (superiors == null) {
            superiors = new ArrayList<UserFE>();
        }
        return this.superiors;
    }

    /**
     * Gets the value of the workers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWorkers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserFE }
     * 
     * 
     */
    public List<UserFE> getWorkers() {
        if (workers == null) {
            workers = new ArrayList<UserFE>();
        }
        return this.workers;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the permission property.
     * 
     * @return
     *     possible object is
     *     {@link PermissionType }
     *     
     */
    public PermissionType getPermission() {
        return permission;
    }

    /**
     * Sets the value of the permission property.
     * 
     * @param value
     *     allowed object is
     *     {@link PermissionType }
     *     
     */
    public void setPermission(PermissionType value) {
        this.permission = value;
    }

    /**
     * Sets the value of the tasks property.
     * 
     * @param tasks
     *     allowed object is
     *     {@link TaskFE }
     *     
     */
    public void setTasks(List<TaskFE> tasks) {
        this.tasks = tasks;
    }

    /**
     * Sets the value of the superiors property.
     * 
     * @param superiors
     *     allowed object is
     *     {@link UserFE }
     *     
     */
    public void setSuperiors(List<UserFE> superiors) {
        this.superiors = superiors;
    }

    /**
     * Sets the value of the workers property.
     * 
     * @param workers
     *     allowed object is
     *     {@link UserFE }
     *     
     */
    public void setWorkers(List<UserFE> workers) {
        this.workers = workers;
    }

}
