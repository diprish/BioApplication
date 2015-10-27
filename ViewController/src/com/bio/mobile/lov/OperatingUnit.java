package com.bio.mobile.lov;

import java.math.BigDecimal;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class OperatingUnit {
    private String name;
    private BigDecimal organizationId;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public OperatingUnit() {
        super();
    }

    public OperatingUnit(String name, BigDecimal organizationId) {
        setName(name);
        setOrganizationId(organizationId);
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        propertyChangeSupport.firePropertyChange("name", oldName, name);
    }

    public String getName() {
        return name;
    }

    public void setOrganizationId(BigDecimal organizationId) {
        BigDecimal oldOrganizationId = this.organizationId;
        this.organizationId = organizationId;
        propertyChangeSupport.firePropertyChange("organizationId", oldOrganizationId, organizationId);
    }

    public BigDecimal getOrganizationId() {
        return organizationId;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
