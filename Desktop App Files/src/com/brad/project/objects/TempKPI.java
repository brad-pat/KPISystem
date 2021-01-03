package com.brad.project.objects;

public class TempKPI {
    
    private String KPIName;
    private int Value;
    private int amountOfSubKPIs;
    
    public TempKPI(String name, int value, int subkpis) {
        KPIName = name;
        Value = value;
        amountOfSubKPIs = subkpis;
    }

    public String getKPIName() {
        return KPIName;
    }

    public void setKPIName(String KPIName) {
        this.KPIName = KPIName;
    }

    public int getValue() {
        return Value;
    }

    public void setValue(int Value) {
        this.Value = Value;
    }

    public int getAmountOfSubKPIs() {
        return amountOfSubKPIs;
    }

    public void setAmountOfSubKPIs(int amountOfSubKPIs) {
        this.amountOfSubKPIs = amountOfSubKPIs;
    }

}
