package com.brad.project.objects;

public class User {
    
    private String id;
    private String name;
    private String role;
    private boolean manager;
    private int cont_hours;
    private int overtime;
    
    public User(String ident, String fullname, String storerole, boolean storemanager, int hours, int over_time)
    {
        id = ident;
        name = fullname;
        role = storerole;
        manager = storemanager;
        cont_hours = hours;
        overtime = over_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public int getCont_hours() {
        return cont_hours;
    }

    public void setCont_hours(int cont_hours) {
        this.cont_hours = cont_hours;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    
    
}
