package com.bio.mobile.lov.service;

import com.bio.mobile.lov.OperatingUnit;

import com.bio.mobile.report.ShippingReport;
import com.bio.mobile.rest.RestURIs;
import com.bio.mobile.rest.ServiceManager;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import oracle.adfmf.json.JSONArray;
import oracle.adfmf.json.JSONObject;

public class OperatingUnitService {
    private static List<OperatingUnit> operatingUnitList = new ArrayList<OperatingUnit>();

    public OperatingUnitService() {
        super();
    }

    public OperatingUnit[] getOperatingUnit() {
        OperatingUnit[] operatingUnitArray = null;
        ServiceManager serviceManager = new ServiceManager();

        String jsonArrayAsString = serviceManager.invokeREAD(RestURIs.getOuLov());

        try {
            JSONObject jsonObject = new JSONObject(jsonArrayAsString);

            JSONArray nodeArray = jsonObject.getJSONArray("HrOperatingUnits");

            int size = nodeArray.length();
            for (int i = 0; i < size; i++) {

                JSONObject temp = nodeArray.getJSONObject(i);

                String name = temp.getString("name");
                BigDecimal organizationId = new BigDecimal(temp.getString("organizationId"));

                OperatingUnit operatingUnit = new OperatingUnit(name, organizationId);
                operatingUnitList.add(operatingUnit);
            }
            operatingUnitArray = operatingUnitList.toArray(new OperatingUnit[operatingUnitList.size()]);
        } catch (Exception e) {
            e.getMessage();
        }
        return operatingUnitArray;

    }
}
