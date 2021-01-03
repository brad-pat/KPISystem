package com.brad.project.objects;

public class SubKPI {
    
    private String sname;
    private String sparent;
    private String stype;
    private boolean mon;
    private String math;
    
    public SubKPI(String name, String parentKPIName, String type, boolean monitor, String maths)
    {
        sname = name;
        sparent = parentKPIName;
        stype = type;
        mon = monitor;
        math = maths;
    }

    public String getName() {
        return sname;
    }

    public String getParent() {
        return sparent;
    }

    public String getType() {
        return stype;
    }

    public boolean isMonitored() {
        return mon;
    }

    public String getMaths() {
        return math;
    }
    
    public void setName(String sname) {
        this.sname = sname;
    }

    public void setParent(String sparent) {
        this.sparent = sparent;
    }

    public void setType(String stype) {
        this.stype = stype;
    }

    public void setMonitor(boolean mon) {
        this.mon = mon;
    }

    public void setMaths(String math) {
        this.math = math;
    }
    
    

}
