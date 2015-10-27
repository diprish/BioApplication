package com.bio.mobile.rest;

public class RestURIs {

    private static final String GL_COST_CENTER_REPORT =
        "XxDmaGlCostCtrExpRevReport/GetGlCostCtrExpRevRestService//GlCostCtrExpRev/";

    private static final String LEDGER_LOV = "XxDmaGlLedgerLov/GetGlLedgerLovRestService/GetGlLedgerLov";

    private static final String GL_PERIOD_LOV = "XxDmaGLPeriodLov/GetGLPeriodLovRestService/GetGLPeriodLov/";

    private static final String OM_SHIPPING_REPORT =
        "XxDmaOntShippingReport/GetShippingDetailsRestService/GetShippingDetails/";

    private static final String OU_LOV = "XxDmaFndOULov/GetOULovRestService/OULov";
    private static final String WAREHOUSE_LOV = "XxDmaGetWhseLov/GetWhseLovRestService/";

    public RestURIs() {
        super();
    }

    /*
     * Gl Cost Center Report URIs
     */
    public static String getGlCostCenterReportURI(String ledgerId, String fromPeriod, String toPeriod) {
        return GL_COST_CENTER_REPORT + ledgerId + "/" + fromPeriod + "/" + toPeriod;
    }

    public static String getGlPeriodLovURI() {
        return GL_PERIOD_LOV + 1;
    }

    public static String getLedgerLovURI() {
        return LEDGER_LOV;
    }

    /*
     * Om Shipping Report
     */
    public static String getOmShippingReportURI(String warehouse, String bucketDays, String groupBy, String ouName
                                         ) {
        return OM_SHIPPING_REPORT + warehouse + "/" + bucketDays + "/" + groupBy + "/" + ouName + "/" + "0" + "/" +
               "20559" + "/" + "300";
    }

    public static String getOuLov() {
        return OU_LOV;
    }

    public static String getWarehouseLov(String operatingUnit) {
        return WAREHOUSE_LOV + operatingUnit;
    }
}
