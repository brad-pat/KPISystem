package com.brad.project.objects;

public class Sale {
    
    private int sid;
    private KPI kkpi;
    private SubKPI subkpi;
    private double saledata;
    private User usr;
    
    public Sale(int id, KPI kpi, SubKPI skpi, double data) {
        sid = id;
        kkpi = kpi;
        subkpi = skpi;
        saledata = data;
    }

    public KPI getKkpi() {
        return kkpi;
    }

    public void setKkpi(KPI kkpi) {
        this.kkpi = kkpi;
    }

    public SubKPI getSubkpi() {
        return subkpi;
    }

    public void setSubkpi(SubKPI subkpi) {
        this.subkpi = subkpi;
    }

    public double getSaledata() {
        return saledata;
    }

    public void setSaledata(double saledata) {
        this.saledata = saledata;
    }

    public User getUsr() {
        return usr;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public void setUsr(User usr) {
        this.usr = usr;
    }
    

}
