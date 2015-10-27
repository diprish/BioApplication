package com.bio.mobile.report.service;

import com.bio.mobile.report.ShippingReport;

import com.bio.mobile.rest.RestURIs;
import com.bio.mobile.rest.ServiceManager;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.json.JSONArray;
import oracle.adfmf.json.JSONObject;

public class ShippingReportService {
    private static List<ShippingReport> shippingReportList = new ArrayList<ShippingReport>();

    public ShippingReportService() {
        super();
    }

    public ShippingReport[] getShippingReport() {
        ServiceManager serviceManager = new ServiceManager();
        ShippingReport[] shipmentReportArray = null;
        String ou = AdfmfJavaUtilities.getELValue("#{pageFlowScope.ou}").toString();
        String whse = AdfmfJavaUtilities.getELValue("#{pageFlowScope.whse}").toString();
        String days = AdfmfJavaUtilities.getELValue("#{pageFlowScope.bdays}").toString();
        String groupBy = AdfmfJavaUtilities.getELValue("#{pageFlowScope.groupBy}").toString();

        String jsonArrayAsString = serviceManager.invokeREAD(RestURIs.getOmShippingReportURI(whse, days, groupBy, ou));

        try {
            JSONObject jsonObject = new JSONObject(jsonArrayAsString);
            JSONObject parent = jsonObject.getJSONObject("P_SHIPPING_TAB");
            JSONArray nodeArray = parent.getJSONArray("P_SHIPPING_TAB_ITEM");
            int size = nodeArray.length();
            for (int i = 0; i < size; i++) {

                JSONObject temp = nodeArray.getJSONObject(i);

                String warehouse = temp.getString("WAREHOUSE");
                BigDecimal noOfSalesOrders = new BigDecimal(temp.getString("NO_OF_SALES_ORDERS"));
                String salesOrderValues = temp.getString("SALES_ORDER_VALUES");
                String itemQuantity = temp.getString("ITEM_QUANTITY");
                String shipmentDate = temp.getString("SHIPMENT_DATE");
                BigDecimal recId = new BigDecimal(temp.getString("REC_ID"));
                ShippingReport shipment =
                    new ShippingReport(warehouse, noOfSalesOrders, salesOrderValues, itemQuantity, shipmentDate, recId);
             

                shippingReportList.add(shipment);
            }
            shipmentReportArray = shippingReportList.toArray(new ShippingReport[shippingReportList.size()]);
        } catch (Exception e) {
            e.getMessage();
        }
        return shipmentReportArray;
    }
}
