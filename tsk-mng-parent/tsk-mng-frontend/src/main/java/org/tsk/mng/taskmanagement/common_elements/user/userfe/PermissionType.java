
package org.tsk.mng.taskmanagement.common_elements.user.userfe;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PermissionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PermissionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Admin"/>
 *     &lt;enumeration value="User"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PermissionType")
@XmlEnum
public enum PermissionType {

    @XmlEnumValue("Admin")
    ADMIN("Admin"),
    @XmlEnumValue("User")
    USER("User");
    private final String value;

    PermissionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PermissionType fromValue(String v) {
        for (PermissionType c: PermissionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
