package com.softwareag.platform.management.sdk.democases.configuration.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.w3c.dom.Element;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "UiBindingDemosJsonBindings")
public class UiBindingDemosJsonBindingsConfiguration {

    private static final String DEMO_VALUE = "DemoValue"; //$NON-NLS-1$

    private static final String DEMO_NAME = "DemoName"; //$NON-NLS-1$

    @XmlElement(name = "CheckBoxBooleanBinding")
    protected Boolean checkBoxBooleanBinding;

    @XmlElement(name = "Enabled")
    protected Boolean enabled;

    @XmlElement(name = "StringBinding")
    protected String stringBinding;

    @XmlElement(name = "Values")
    protected List<String> values;

    @XmlElement(name = "Password")
    protected String password;

    @XmlElement(name = "Name")
    protected String name;

    @XmlElement(name = "Description")
    protected String description;

    @XmlElement(name = "BindingCollection")
    protected BindingCollection collection;

    @XmlElement(name = "Properties")
    protected PropertyElements properties;

    @XmlElement(name = "ServiceProperties")
    protected PropertyElements serviceProperties;

    @XmlAnyElement
    protected List<Element> any;

    public void setValues(List<String> elements) {
        this.values = elements;
    }

    public List<String> getValues() {
        if (values == null) {
            values = new ArrayList<>();
        }
        return this.values;
    }

    public String getDescription() {
        return description;
    }
    
    @XmlElement(name = "NameNavigation")
    public String getNameNavigation() {
        return "to:" + name; //$NON-NLS-1$
    }
    
    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setCheckBoxBooleanBinding(Boolean checkBoxBooleanBinding) {
        this.checkBoxBooleanBinding = checkBoxBooleanBinding;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStringBinding(String stringBinding) {
        this.stringBinding = stringBinding;
    }

    public String getStringBinding() {
        return stringBinding;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public BindingCollection getInnerCollection() {
        if (collection == null) {
            collection = new BindingCollection();
        }
        return collection;
    }

    public PropertyElements getProperties() {
        if (properties == null) {
            properties = new PropertyElements();
        }
        return properties;
    }

    public PropertyElements getServiceProperties() {
        if (serviceProperties == null) {
            serviceProperties = new PropertyElements();
        }
        return serviceProperties;
    }

    @XmlElement(name = "ReadOnlyProperties")
    public PropertyElements getReadOnlyProperties() {
        PropertyElements readOnlyProperties = new PropertyElements();
        List<Property> property = new ArrayList<>();
        readOnlyProperties.setProperty(property);
        for (int i = 0; i < 4; i++) {
            Property addedItem = new Property();
            addedItem.setName(DEMO_NAME + i);
            addedItem.setValue(DEMO_VALUE + i);
            property.add(addedItem);
        }
        return readOnlyProperties;
    }

    public void setAny(List<Element> any) {
        this.any = any;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class BindingCollection {

        @XmlElement(name = "Item")
        protected List<Item> item;

        @XmlAnyElement
        protected List<Element> any;

        public List<Item> getItem() {
            if (item == null) {
                item = new ArrayList<>();
            }
            return this.item;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Item {

            @XmlElement(name = "Properties")
            protected PropertyElements properties;

            @XmlAnyElement
            protected List<Element> any;

            @XmlAttribute(name = "name")
            protected String name;

            @XmlAttribute(name = "type")
            protected String type;

            @XmlElement(name = "Description")
            protected String description;

            public PropertyElements getProperties() {
                if (properties == null) {
                    properties = new PropertyElements();
                }
                return properties;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public void setName(String value) {
                this.name = value;
            }

            public void setType(String type) {
                this.type = type;
            }

        }

    }

}
