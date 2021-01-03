package com.brad.project.objects;

public class DisplayPacket {
    
    private KPI kpi;
    private User user;
    private Target target;
    
    public DisplayPacket(KPI kpi, User usr, Target tgt) {        
        this.kpi = kpi;
        user = usr;
        target = tgt;
    }

    public KPI getKpi() {
        return kpi;
    }

    public void setKpi(KPI kpi) {
        this.kpi = kpi;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }
    
    

}
