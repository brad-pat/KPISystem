package com.brad.project.objects;

import java.util.ArrayList;

public class KPI {
    
    private String name;
    private int value;
    private String type;
    private ArrayList<SubKPI> subkpis;
    
    public KPI(String kpiname, int kpivalue, String kpitype, ArrayList<SubKPI> sub)
    {
        name = kpiname;
        value = kpivalue;
        type = kpitype;
        subkpis = sub;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSubKPIs(ArrayList<SubKPI> subkpis) {
        this.subkpis = subkpis;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public ArrayList<SubKPI> getSubkpis() {
        return subkpis;
    }
    
    

}
