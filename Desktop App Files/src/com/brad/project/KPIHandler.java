package com.brad.project;

import com.brad.project.objects.KPI;
import com.brad.project.objects.SubKPI;
import java.util.ArrayList;
import java.util.List;

public class KPIHandler {
    
    private KPIHandler() {}
    private static KPIHandler instance = null;
    public static KPIHandler getInstance()
    {
        if(instance == null) instance = new KPIHandler();
        return instance;
    }
    
    public void printKPIs() {
        for(KPI kpi : kpi_list) {
            System.out.println("----\nKPI Name: " + kpi.getName());
            System.out.println("KPI Type: " + kpi.getType());
            System.out.println("KPI Value: " + kpi.getValue());
            System.out.println("---- SubKPIs: ----");
            for(SubKPI skpi : kpi.getSubkpis()) {
                System.out.println("Sub Name: " + skpi.getName());
                System.out.println("Sub Main: " + skpi.getParent());
                System.out.println("Sub Maths: " + skpi.getMaths());
                System.out.println("Sub Type: " + skpi.getType());
                System.out.println("Sub is Monitored: " + skpi.isMonitored());
                System.out.println("-----");
            }
        }
    }
    
    public ArrayList<KPI> kpi_list = new ArrayList<KPI>();
    
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
