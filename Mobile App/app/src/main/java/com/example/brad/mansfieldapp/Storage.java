package com.example.brad.mansfieldapp;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private static Storage instance = null;

    private Storage()
    {}

    public static Storage getInstance()
    {
        if(instance == null)
        {
            instance = new Storage();
        }
        return instance;
    }

    public List<KPI> kpi_list = new ArrayList<>();

    public List<String> personal_performance_kpi_data = new ArrayList<>();
    public List<String> store_performance_kpi_data = new ArrayList<>();
    public List<String> store_times = new ArrayList<>();
    public List<String> employee_times = new ArrayList<>();
    public String kpi_string;
    public String pi_ip = "http://81.110.252.31/";
    public String uid = "brad@telefonica.com";
    public String uname = "Brad";

    public List<String> getKPINamesAsList() {
        List<String> kpis = new ArrayList<String>();
        for(KPI kpi : kpi_list) {
            kpis.add(kpi.getName());
        }
        return kpis;
    }

    public List<String> getSubKPINamesAsList(KPI kpi) {
        List<String> subkpis = new ArrayList<String>();
        for(SubKPI skpi : kpi.getSubkpis()) {
            subkpis.add(skpi.getName());
        }
        return subkpis;
    }

    public SubKPI getSubKPIByNameAndKPI(String name, KPI kpi) {
        for(SubKPI skpi : kpi.getSubkpis()) {
            if(skpi.getName().equalsIgnoreCase(name)) {
                return skpi;
            }
        }
        return null;
    }

    public SubKPI getSubKPIByName(String name)
    {
        for(KPI kpi : kpi_list)
        {
            for(SubKPI sub : kpi.getSubkpis())
            {
                if(sub.getName().equalsIgnoreCase(name))
                {
                    return sub;
                }
            }
        }
        return null;
    }

    public KPI getKPIByName(String name)
    {
        for(KPI kpi : kpi_list)
        {
            if(kpi.getName().equalsIgnoreCase(name))
            {
                return kpi;
            }
        }
        return null;
    }

}
