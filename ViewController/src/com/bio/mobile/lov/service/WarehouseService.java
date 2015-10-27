package com.bio.mobile.lov.service;

import com.bio.mobile.lov.OperatingUnit;
import com.bio.mobile.lov.Warehouse;

import com.bio.mobile.rest.RestURIs;
import com.bio.mobile.rest.ServiceManager;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.json.JSONArray;
import oracle.adfmf.json.JSONObject;

public class WarehouseService {
    private static List<Warehouse> warehouseList = new ArrayList<Warehouse>();

    public WarehouseService() {
        super();
    }
    
    public Warehouse[] getWarehouse(){
        Warehouse[] warehouseArray = null;
        ServiceManager serviceManager = new ServiceManager();
        String ou = AdfmfJavaUtilities.getELValue("#{pageFlowScope.ou}").toString();
        String jsonArrayAsString = serviceManager.invokeREAD(RestURIs.getWarehouseLov(ou));

        try {
            JSONObject jsonObject = new JSONObject(jsonArrayAsString);
            JSONObject parentNode = jsonObject.getJSONObject("P_WHSE_TAB");
            JSONArray nodeArray = parentNode.getJSONArray("P_WHSE_TAB_ITEM");

            int size = nodeArray.length();
            for (int i = 0; i < size; i++) {

                JSONObject temp = nodeArray.getJSONObject(i);

                String organizationCode = temp.getString("ORGANIZATION_CODE");
                BigDecimal organizationId = new BigDecimal(temp.getString("ORGANIZATION_ID"));

                Warehouse warehouse = new Warehouse(organizationCode, organizationId);
                warehouseList.add(warehouse);
            }
            warehouseArray = warehouseList.toArray(new Warehouse[warehouseList.size()]);
        } catch (Exception e) {
            e.getMessage();
        }
        return warehouseArray;

    }
}
