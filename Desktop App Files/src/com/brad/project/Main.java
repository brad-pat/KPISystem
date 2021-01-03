package com.brad.project;

import com.brad.project.GUI.HomeScreen;
import com.brad.project.GUI.LoginScreen;
import com.brad.project.GUI.TrackerScreen;
import com.brad.project.GUI.setup.Welcome;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        File f = new File("config.yml");
        if(f.exists()) {
            //Login
            YAMLHandler yaml = new YAMLHandler();
            yaml.read();
            new LoginScreen();
        } else {
            //Setup
            new Welcome();
        }
    }

}
