package com.brad.project;

import com.brad.project.objects.TempKPI;
import java.awt.List;
import java.io.File;
import java.util.ArrayList;

public class Storage {

    private static Storage instance = null;

    private Storage() {
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }
    public String company_name = "";
    String tracking_type;
    public String pi_ip = "http://81.110.252.31/";
    boolean track_store;
    boolean track_employees;
    public ArrayList<String> store_time_scales_to_track = new ArrayList<String>();
    public ArrayList<String> individual_time_scales_to_track = new ArrayList<String>();
    
    public String current_user_id = "bradley.patrick@telefonica.com";
    
    ArrayList<TempKPI> tempkpi_list = new ArrayList<TempKPI>();
    public int templistindex = 0;
    
    public ArrayList<TempKPI> getTempKPIList() {
        return tempkpi_list;
    }

    public void printSettings() {
        System.out.println("Company Name: " + company_name);
        System.out.println("Pi IP: " + pi_ip);
        System.out.println("Tracking Type: " + tracking_type);
        System.out.println("isStoreTracked? " + track_store);
        System.out.println("isEmployeesTracked? " + track_employees);
    }

    public void printEmployeeTrackTimings() {
        System.out.println("Employee Timings to Track:");
        for (String s : individual_time_scales_to_track) {
            System.out.println(s);
        }
    }

    public void printStoreTrackTimings() {
        System.out.println("Store Timings to Track:");
        for (String s : store_time_scales_to_track) {
            System.out.println(s);
        }
    }
}