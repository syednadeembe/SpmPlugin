package com.softwareag.platform.management.productcode.mysql.dto;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.namespace.QName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Property")
public class Property {

    @XmlValue
    protected String value;

    @XmlAttribute(name = "localServiceAvailable")
    protected String localServiceAvailable;

    @XmlAttribute(name = "serviceActivated")
    protected String serviceActivated;

    @XmlAttribute(name = "name")
    protected String name;

    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<>();

    public void setLocalServiceAvailable(String localServiceAvailable) {
        this.localServiceAvailable = localServiceAvailable;
    }

    public void setServiceActivated(String serviceActivated) {
        this.serviceActivated = serviceActivated;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setName(String value) {
        this.name = value;
    }

    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
