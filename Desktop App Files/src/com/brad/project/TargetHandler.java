package com.brad.project;

import com.brad.project.objects.KPI;
import com.brad.project.objects.Target;
import java.util.ArrayList;

public class TargetHandler {

    private static TargetHandler instance = null;

    private TargetHandler() {
    }

    public static TargetHandler getInstance() {
        if (instance == null) {
            instance = new TargetHandler();
        }
        return instance;
    }

    public ArrayList<Target> targets = new ArrayList<Target>();
    public ArrayList<String> target_times = new ArrayList<String>();
    public ArrayList<String> general_times = new ArrayList<String>();

    public Target getTargetForKPIByName(String name) {
        for (Target t : targets) {
            if (t.getKpiname().equalsIgnoreCase(name)) {
                return t;
            }
        }
        return null;
    }

    public Target getTargetForKPIByKPIObject(KPI kpi) {
        String kpiname = kpi.getName();
        for (Target t : targets) {
            if (t.getKpiname().equalsIgnoreCase(kpiname)) {
                return t;
            }
        }
        return null;
    }

    }
