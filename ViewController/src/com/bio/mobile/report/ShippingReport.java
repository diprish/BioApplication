package com.bio.mobile.report;

import java.math.BigDecimal;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class ShippingReport {
    private String warehouse;
    private BigDecimal noOfSalesOrders;
    private String salesOrderValues;
    private String itemQuantity;
    private String shipmentDate;
    private BigDecimal recId;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public ShippingReport(String warehouse, BigDecimal noOfSalesOrders, String salesOrderValues, String itemQuantity,
                          String shipmentDate, BigDecimal recId) {
        super();
        setWarehouse(warehouse);
        setNoOfSalesOrders(noOfSalesOrders);
        setSalesOrderValues(salesOrderValues);
        setItemQuantity(itemQuantity);
        setShipmentDate(shipmentDate);
        setRecId(recId);
    }

    public void setWarehouse(String warehouse) {
        String oldWarehouse = this.warehouse;
        this.warehouse = warehouse;
        propertyChangeSupport.firePropertyChange("warehouse", oldWarehouse, warehouse);
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setNoOfSalesOrders(BigDecimal noOfSalesOrders) {
        BigDecimal oldNoOfSalesOrders = this.noOfSalesOrders;
        this.noOfSalesOrders = noOfSalesOrders;
        propertyChangeSupport.firePropertyChange("noOfSalesOrders", oldNoOfSalesOrders, noOfSalesOrders);
    }

    public BigDecimal getNoOfSalesOrders() {
        return noOfSalesOrders;
    }

    public void setSalesOrderValues(String salesOrderValues) {
        String oldSalesOrderValues = this.salesOrderValues;
        this.salesOrderValues = salesOrderValues;
        propertyChangeSupport.firePropertyChange("salesOrderValues", oldSalesOrderValues, salesOrderValues);
    }

    public String getSalesOrderValues() {
        return salesOrderValues;
    }

    public void setItemQuantity(String itemQuantity) {
        String oldItemQuantity = this.itemQuantity;
        this.itemQuantity = itemQuantity;
        propertyChangeSupport.firePropertyChange("itemQuantity", oldItemQuantity, itemQuantity);
    }

    public String getItemQuantity() {
        return itemQuantity;
    }

    public void setShipmentDate(String shipmentDate) {
        String oldShipmentDate = this.shipmentDate;
        this.shipmentDate = shipmentDate;
        propertyChangeSupport.firePropertyChange("shipmentDate", oldShipmentDate, shipmentDate);
    }

    public String getShipmentDate() {
        return shipmentDate;
    }

    public void setRecId(BigDecimal recId) {
        BigDecimal oldRecId = this.recId;
        this.recId = recId;
        propertyChangeSupport.firePropertyChange("recId", oldRecId, recId);
    }

    public BigDecimal getRecId() {
        return recId;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
