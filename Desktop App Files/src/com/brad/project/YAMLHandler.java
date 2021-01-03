package com.brad.project;

import com.brad.project.objects.KPI;
import com.brad.project.objects.SubKPI;
import com.brad.project.objects.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;

public class YAMLHandler {

    public void write() throws IOException {
        File f = new File("config.yml");
        //Map<String, Object> data = new HashMap<>();
        f.createNewFile();
        StringBuilder sb = new StringBuilder();
        sb.append("---\n");
        sb.append("company-name: ").append("\"").append(Storage.getInstance().company_name).append("\"");
        //sb.append("\ntracking-type: ").append("\"").append(Storage.getInstance().tracking_type).append("\"");
        sb.append("\npi_ip: ").append("\"").append(Storage.getInstance().pi_ip).append("\"");
        
        /*
        sb.append("\ntrack-store: ").append(Storage.getInstance().track_store);
        sb.append("\ntrack-individually: ").append(Storage.getInstance().track_employees);
        sb.append("\n---\n");
        String kpis = formKPIStrings();
        sb.append(kpis);
        sb.append("\n---\n");
        String users = formUserSettings();
        sb.append(users);
        sb.append("\n---\n");
        String storesettings = formStoreSettings();
        String employeesettings = formEmployeeSettings();
        sb.append(storesettings);
        sb.append("\n---\n");
        sb.append(employeesettings);
*/
        FileWriter fw = new FileWriter(f);
        fw.write(sb.toString());
        fw.close();
    }

    private String formEmployeeSettings() {
        StringBuilder sb = new StringBuilder();
        sb.append("individual-settings:");
        sb.append("\n    time-scales-to-track:");
        ArrayList<String> times = Storage.getInstance().individual_time_scales_to_track;
        for (String s : times) {
            sb.append("\n        - ").append(s);
        }
        return sb.toString();
    }

    private static String formStoreSettings() {
        StringBuilder sb = new StringBuilder();
        sb.append("store-settings:");
        sb.append("\n    time-scales-to-track:");
        ArrayList<String> times = Storage.getInstance().store_time_scales_to_track;
        for (String s : times) {
            sb.append("\n        - ").append(s);
        }
        return sb.toString();
    }

    private String formUserSettings() {
        StringBuilder sb = new StringBuilder();
        sb.append("users:");
        ArrayList<User> users = UserHandler.getInstance().users;
        for (User user : users) {
            sb.append("\n    ").append(user.getId()).append(":");
            String[] names = user.getName().split(" ");
            sb.append("\n        firstname: ").append(names[0]);
            int namesize = names.length;
            int lasttoget = namesize - 1;
            sb.append("\n        lastname: ").append(names[lasttoget]);
            sb.append("\n        contracted_hours: ").append(user.getCont_hours());
            sb.append("\n        overtime: ").append(user.getOvertime());
            sb.append("\n        role: ").append(user.getRole());
            sb.append("\n        manager: ").append(user.isManager());
        }
        return sb.toString();
    }

    private String formKPIStrings() {
        StringBuilder sb = new StringBuilder();
        sb.append("kpis:");
        ArrayList<KPI> kpis = KPIHandler.getInstance().kpi_list;
        for (KPI kpi : kpis) {
            sb.append("\n    ").append(kpi.getName()).append(":");
            sb.append("\n        kpi_value: ").append(kpi.getValue());
            sb.append("\n        type: ").append(kpi.getType());
            sb.append("\n        sub-kpis:");
            for (SubKPI skpi : kpi.getSubkpis()) {
                sb.append("\n            ").append(skpi.getName()).append(":");
                sb.append("\n                type: \"").append(skpi.getType()).append("\"");
                sb.append("\n                maths: \"").append(skpi.getMaths()).append("\"");
                sb.append("\n                show: ").append(skpi.isMonitored());
            }
        }
        return sb.toString();
    }

    public void read() {
        try {
            File f = new File("config.yml");
            Yaml yaml = new Yaml();
            InputStream input = new FileInputStream(f.getAbsolutePath());
            Iterable<Object> irt = yaml.loadAll(input);
            for (Object o : irt) {
                if (o.toString().startsWith("{company-name")) {
                    readGeneralSettings(o);
                }
            }
        } catch (FileNotFoundException e) {

        }
    }

    private void readEmployeeTimings(Object o) {
        //System.out.println("\nStore Settings:\n" + o.toString());
        String[] ss = o.toString().split("time-scales-to-track=");
        String time = ss[1].replace("}", "").replace("[", "").replace("]", "");
        String[] timings = time.split(", ");
        for (String s : timings) {
            Storage.getInstance().individual_time_scales_to_track.add(s);
        }
        Storage.getInstance().printEmployeeTrackTimings();
    }

    private void readStoreTimings(Object o) {
        //System.out.println("\nStore Settings:\n" + o.toString());
        String[] ss = o.toString().split("time-scales-to-track=");
        String time = ss[1].replace("}", "").replace("[", "").replace("]", "");
        String[] timings = time.split(", ");
        for (String s : timings) {
            Storage.getInstance().store_time_scales_to_track.add(s);
        }
        //Storage.getInstance().printStoreTrackTimings();
    }

    private void readKPISettings(Object o) {
        //System.out.println("\nKPI Settings:\n" + o.toString());
        String[] kpis = o.toString().replace("{kpis={", "").split("}}, ");
        for (String s : kpis) {
            //System.out.println("\n" + s);
            String[] subk = s.split("sub-kpis=");
            //System.out.println("\n" + subk[0]);
            //KPI Stuff
            String[] kpistuff = subk[0].split("=\\{");
            //KPI VARIABLES
            String kpi_name = kpistuff[0];
            int value = 0;
            String kpi_type = null;
            ArrayList<SubKPI> subkpi_list = new ArrayList<SubKPI>();
            //System.out.println(kpistuff[1]);
            String[] kpi_info = kpistuff[1].split(", ");
            for (String kd : kpi_info) {
                String[] k = kd.split("=");
                if (k[0].equalsIgnoreCase("kpi_value")) {
                    value = Integer.parseInt(k[1]);
                }
                if (k[0].equalsIgnoreCase("type")) {
                    kpi_type = k[1];
                }
            }
            //Sub KPI Stuff
            String[] subkpis = subk[1].split("}, ");
            for (String str : subkpis) {
                //Sub KPI VARIABLES
                String subkpiname;
                KPI partentKPI;
                String type = null;
                boolean monitor = false;
                String maths = null;
                String subkpi = str.replace("}", "");
                //System.out.println(subkpi);
                String[] sk = subkpi.split("=\\{");
                subkpiname = sk[0].replace("{", "");
                String[] subkpidetails = sk[1].split(", ");
                for (String skp : subkpidetails) {
                    String[] sbk = skp.split("=");
                    if (sbk[0].equalsIgnoreCase("type")) {
                        type = sbk[1];
                    }
                    if (sbk[0].equalsIgnoreCase("maths")) {
                        maths = sbk[1];
                    }
                    if (sbk[0].equalsIgnoreCase("show")) {
                        monitor = Boolean.parseBoolean(sbk[1]);
                    }
                }
                subkpi_list.add(new SubKPI(subkpiname, kpi_name, type, monitor, maths));
            }
            KPIHandler.getInstance().kpi_list.add(new KPI(kpi_name, value, kpi_type, subkpi_list));
        }
        //KPIHandler.getInstance().printKPIs();
    }

    private void readGeneralSettings(Object o) {
        //System.out.println("\nGeneral Settings:\n" + o.toString());
        String data = o.toString().replace("{", "").replace("}", "");
        String[] info = data.split(", ");
        for (String str : info) {
            String[] s = str.split("=");
            if (s[0].equalsIgnoreCase("company-name")) {
                Storage.getInstance().company_name = s[1];
            }
            if (s[0].equalsIgnoreCase("pi_ip")) {
                Storage.getInstance().pi_ip = s[1];
            }
        }
        //Storage.getInstance().printSettings();
    }

    private void readUsers(Object o) {
        //System.out.println("\nUser Settings:\n" + o.toString() + "\n" + o.getClass());
        String[] test = o.toString().replace("{users={", "").split("}, ");
        for (String detail : test) {
            String[] usersplit = detail.replace("}", "").split("=\\{");
            String id = usersplit[0];
            String firstname = null;
            String lastname = null;
            String role = null;
            int contracted_hours = 0;
            int overtime = 0;
            boolean manager = false;
            String[] details = usersplit[1].split(", ");
            for (String s : details) {
                String[] info = s.split("=");
                if (info[0].equalsIgnoreCase("firstname")) {
                    firstname = info[1];
                }
                if (info[0].equalsIgnoreCase("lastname")) {
                    lastname = info[1];
                }
                if (info[0].equalsIgnoreCase("role")) {
                    role = info[1];
                }
                if (info[0].equalsIgnoreCase("contracted_hours")) {
                    contracted_hours = Integer.parseInt(info[1]);
                }
                if (info[0].equalsIgnoreCase("overtime")) {
                    overtime = Integer.parseInt(info[1]);
                }
                if (info[0].equalsIgnoreCase("manager")) {
                    manager = Boolean.parseBoolean(info[1]);
                }
            }
            User user = new User(id, firstname + " " + lastname, role, manager, contracted_hours, overtime);
            UserHandler.getInstance().users.add(user);
        }
        //UserHandler.getInstance().printUsers();
    }

}
