
package org.tsk.mng.taskmanagement.common_elements.task.taskfe;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TaskStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TaskStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Done"/>
 *     &lt;enumeration value="InProgress"/>
 *     &lt;enumeration value="NotStarted"/>
 *     &lt;enumeration value="Waiting"/>
 *     &lt;enumeration value="Failed"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TaskStatusType")
@XmlEnum
public enum TaskStatusType {

    @XmlEnumValue("Done")
    DONE("Done"),
    @XmlEnumValue("InProgress")
    IN_PROGRESS("InProgress"),
    @XmlEnumValue("NotStarted")
    NOT_STARTED("NotStarted"),
    @XmlEnumValue("Waiting")
    WAITING("Waiting"),
    @XmlEnumValue("Failed")
    FAILED("Failed");
    private final String value;

    TaskStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TaskStatusType fromValue(String v) {
        for (TaskStatusType c: TaskStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
