package com.brad.project;

import com.brad.project.objects.User;
import java.util.ArrayList;
import java.util.List;

public class UserHandler {
    
    private UserHandler() {}
    private static UserHandler instance = null;
    public static UserHandler getInstance()
    {
        if(instance == null) instance = new UserHandler();
        return instance;
    }
    
    public User currentUser;
    
    public ArrayList<User> users = new ArrayList<User>();
    
    public void printUsers() {
        System.out.println("--- User Details: ---");
        for(User usr : users) {
            System.out.println("-----\nID: " + usr.getId());
            System.out.println("Name: " + usr.getName());
            System.out.println("Role: " + usr.getRole());
            System.out.println("Hours: " + usr.getCont_hours());
            System.out.println("isManager: " + usr.isManager());
        }
    }
    
    public List<String> getUsersAsStringList() {
        List<String> temp = new ArrayList<String>();
        for(User u : users) {
            temp.add(u.getId());
        }
        return temp;
    }
    
    public User getUserObjectByID(String id)
    {
        for(User user : users)
        {
            if(user.getId().equalsIgnoreCase(id))
            {
                return user;
            }
        }
        return null;
    }
    
    public User getUserObjectByName(String name)
    {
        for(User user : users)
        {
            if(user.getName().equalsIgnoreCase(name))
            {
                return user;
            }
        }
        return null;
    }

}
