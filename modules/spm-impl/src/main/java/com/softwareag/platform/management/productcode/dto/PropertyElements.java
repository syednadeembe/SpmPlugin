package com.softwareag.platform.management.productcode.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Properties")
public class PropertyElements {

    @XmlElement(name = "Property")
    protected List<Property> property;

    public List<Property> getProperty() {
        if (property == null) {
            property = new ArrayList<>();
        }
        return this.property;
    }
    
    public void setProperty(List<Property> property) {
        this.property = property;
    }

}
