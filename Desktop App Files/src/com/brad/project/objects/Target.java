package com.brad.project.objects;

public class Target {
    
    private String kpiname;
    private double target;
    private String timescale;
    
    public Target(String kpi, double targ, String time) {
        kpiname = kpi;
        target = targ;
        timescale = time;
    }

    public String getKpiname() {
        return kpiname;
    }

    public void setKpiname(String kpiname) {
        this.kpiname = kpiname;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public String getTimescale() {
        return timescale;
    }

    public void setTimescale(String timescale) {
        this.timescale = timescale;
    }

}
