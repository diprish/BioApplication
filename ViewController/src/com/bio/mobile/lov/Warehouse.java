package com.bio.mobile.lov;

import java.math.BigDecimal;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class Warehouse {
    private String organizationCode;
    private BigDecimal organizationId;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Warehouse() {
        super();
    }

    public Warehouse(String organizationCode, BigDecimal organizationId) {
        setOrganizationCode(organizationCode);
        setOrganizationId(organizationId);
    }


    public void setOrganizationCode(String organizationCode) {
        String oldOrganizationCode = this.organizationCode;
        this.organizationCode = organizationCode;
        propertyChangeSupport.firePropertyChange("organizationCode", oldOrganizationCode, organizationCode);
    }

    public String getOrganizationCode() {
        return organizationCode;
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
