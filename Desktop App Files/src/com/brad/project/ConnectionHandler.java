package com.brad.project;

import com.brad.project.objects.KPI;
import com.brad.project.objects.SubKPI;
import com.brad.project.objects.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ConnectionHandler {

    private String generalString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Storage.getInstance().company_name);
        sb.append("££");
        sb.append(Storage.getInstance().tracking_type);
        sb.append("££");
        sb.append(Storage.getInstance().track_store);
        sb.append("££");
        sb.append(Storage.getInstance().track_employees);
        return sb.toString();
    }

    private String usersString() {
        StringBuilder sb = new StringBuilder();
        for (User user : UserHandler.getInstance().users) {
            sb.append(user.getId());
            sb.append("££");
            sb.append(user.getName().split(" ")[0]);
            sb.append("££");
            sb.append(user.getName().split(" ")[1]);
            sb.append("££");
            sb.append(user.getCont_hours());
            sb.append("££");
            sb.append(user.getOvertime());
            sb.append("££");
            sb.append(user.getRole());
            sb.append("££");
            sb.append(user.isManager());
            if ((UserHandler.getInstance().users.size() - 1) != UserHandler.getInstance().users.indexOf(user)) {
                sb.append("???");
            }

        }
        return sb.toString();
    }

    private String kpiString() {
        StringBuilder sb = new StringBuilder();
        for (KPI kpi : KPIHandler.getInstance().kpi_list) {
            sb.append(kpi.getName());
            sb.append("££");
            sb.append(kpi.getValue());
            sb.append("££");
            sb.append(kpi.getType());
            sb.append("££");
            for (SubKPI skpi : kpi.getSubkpis()) {
                sb.append(skpi.getName());
                sb.append("ZQZ");
                sb.append(skpi.getType());
                sb.append("ZQZ");
                sb.append(skpi.getMaths());
                sb.append("ZQZ");
                sb.append(skpi.isMonitored());
                if ((kpi.getSubkpis().size() - 1) != kpi.getSubkpis().indexOf(skpi)) {
                    sb.append("@@@");
                }
            }
            if ((KPIHandler.getInstance().kpi_list.size() - 1) != KPIHandler.getInstance().kpi_list.indexOf(kpi)) {
                sb.append("???");
            }
        }
        return sb.toString();
    }

    private String otherString() {
        StringBuilder sb = new StringBuilder();
        for (String s : Storage.getInstance().store_time_scales_to_track) {
            sb.append(s);
            if ((Storage.getInstance().store_time_scales_to_track.size() - 1) != Storage.getInstance().store_time_scales_to_track.indexOf(s)) {
                sb.append("££");
            }
        }
        sb.append("ZQZ");
        for (String s : Storage.getInstance().individual_time_scales_to_track) {
            sb.append(s);
            if ((Storage.getInstance().individual_time_scales_to_track.size() - 1) != Storage.getInstance().individual_time_scales_to_track.indexOf(s)) {
                sb.append("££");
            }
        }
        return sb.toString();
    }

    private String generateUserString(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append(user.getId());
        sb.append("££");
        sb.append(user.getName().split(" ")[0]);
        sb.append("££");
        sb.append(user.getName().split(" ")[1]);
        sb.append("££");
        sb.append(user.getCont_hours());
        sb.append("££");
        sb.append(user.getOvertime());
        sb.append("££");
        sb.append(user.getRole());
        sb.append("££");
        sb.append(user.isManager());
        return sb.toString();
    }

    public String getSettings() {
         try {
            URL url = new URL(Storage.getInstance().pi_ip + "setup/php/sendsettings.php");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setDoInput(true);
            InputStream in = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "iso-8859-1"));
            String result = "";
            String line = "";
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            reader.close();
            in.close();
            http.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            //TODO - Some error handling        
        } catch (IOException ex) {
            ex.printStackTrace();
            //TODO - Some error handling
        }
        return null;       
    }
    
    public String editUser(User user) {
        try {
            URL url = new URL(Storage.getInstance().pi_ip + "users/php/edituser.php");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setDoInput(true);
            OutputStream out = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            String data
                    = URLEncoder.encode("userdetails", "UTF-8") + "=" + URLEncoder.encode(generateUserString(user), "UTF-8");
            //                       variable name                      variable result
            writer.write(data);
            writer.flush();
            writer.close();
            out.close();
            InputStream in = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "iso-8859-1"));
            String result = "";
            String line = "";
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            reader.close();
            in.close();
            http.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            //TODO - Some error handling        
        } catch (IOException ex) {
            ex.printStackTrace();
            //TODO - Some error handling
        }
        return null;
    }
    
    public String fetchKPIData(String url_address, String data) {
        try {
            URL url = new URL(url_address);
            String[] info = data.split(":");
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data =
                    URLEncoder.encode("dowhat","UTF-8")+"="+URLEncoder.encode(info[0] + "","UTF-8")+"&"+
                    URLEncoder.encode("kpiname","UTF-8")+"="+URLEncoder.encode(info[1] + "","UTF-8")+"&"+
                    URLEncoder.encode("timescale","UTF-8")+"="+URLEncoder.encode(info[2] + "","UTF-8")+"&"+
                    URLEncoder.encode("user","UTF-8")+"="+URLEncoder.encode(info[3] + "", "UTF-8");
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
            String result="";
            String line="";
            while((line = bufferedReader.readLine())!= null) {
                result += line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String checkUser(String comp, String email) {
        try {
            URL url = new URL(Storage.getInstance().pi_ip + "users/php/checkuser.php");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setDoInput(true);
            OutputStream out = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            String data
                    = URLEncoder.encode("company_name", "UTF-8") + "=" + URLEncoder.encode(comp, "UTF-8") + "&"
                    + URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8");
            //                       variable name                      variable result
            writer.write(data);
            writer.flush();
            writer.close();
            out.close();
            InputStream in = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "iso-8859-1"));
            String result = "";
            String line = "";
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            reader.close();
            in.close();
            http.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            //TODO - Some error handling        
        } catch (IOException ex) {
            ex.printStackTrace();
            //TODO - Some error handling
        }
        return null;
    }

    public String deleteUser(String userid) {
        try {
            URL url = new URL(Storage.getInstance().pi_ip + "users/php/deleteuser.php");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setDoInput(true);
            OutputStream out = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            String data
                    = URLEncoder.encode("userid", "UTF-8") + "=" + URLEncoder.encode(userid, "UTF-8");
            //                       variable name                      variable result
            writer.write(data);
            writer.flush();
            writer.close();
            out.close();
            InputStream in = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "iso-8859-1"));
            String result = "";
            String line = "";
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            reader.close();
            in.close();
            http.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            //TODO - Some error handling        
        } catch (IOException ex) {
            ex.printStackTrace();
            //TODO - Some error handling
        }
        return null;
    }

    public String createUser(User user) {
        try {
            URL url = new URL(Storage.getInstance().pi_ip + "users/php/createuser.php");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setDoInput(true);
            OutputStream out = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            String data
                    = URLEncoder.encode("userdetails", "UTF-8") + "=" + URLEncoder.encode(generateUserString(user), "UTF-8");
            //                       variable name                      variable result
            writer.write(data);
            writer.flush();
            writer.close();
            out.close();
            InputStream in = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "iso-8859-1"));
            String result = "";
            String line = "";
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            reader.close();
            in.close();
            http.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            //TODO - Some error handling        
        } catch (IOException ex) {
            ex.printStackTrace();
            //TODO - Some error handling
        }
        return null;
    }

    public String setup() {
        try {
            URL url = new URL(Storage.getInstance().pi_ip + "setup/php/create.php");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setDoInput(true);
            OutputStream out = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            String data
                    = URLEncoder.encode("general", "UTF-8") + "=" + URLEncoder.encode(generalString(), "UTF-8") + "&"
                    + URLEncoder.encode("users", "UTF-8") + "=" + URLEncoder.encode(usersString(), "UTF-8") + "&"
                    + URLEncoder.encode("kpis", "UTF-8") + "=" + URLEncoder.encode(kpiString(), "UTF-8") + "&"
                    + URLEncoder.encode("other", "UTF-8") + "=" + URLEncoder.encode(otherString(), "UTF-8");
            //                       variable name                      variable result
            writer.write(data);
            writer.flush();
            writer.close();
            out.close();
            InputStream in = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "iso-8859-1"));
            String result = "";
            String line = "";
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            reader.close();
            in.close();
            http.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            //TODO - Some error handling        
        } catch (IOException ex) {
            ex.printStackTrace();
            //TODO - Some error handling
        }
        return null;
    }

    public String placeholder(String detail_url) {
        try {
            URL url = new URL(detail_url);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setDoInput(true);
            OutputStream out = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            String data
                    = URLEncoder.encode("", "UTF-8") + "=" + URLEncoder.encode("", "UTF-8");
            //                       variable name                      variable result
            writer.write(data);
            writer.flush();
            writer.close();
            out.close();
            InputStream in = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "iso-8859-1"));
            String result = "";
            String line = "";
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            reader.close();
            in.close();
            http.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            //TODO - Some error handling        
        } catch (IOException ex) {
            ex.printStackTrace();
            //TODO - Some error handling
        }
        return null;
    }
    
    public String submitTarget(String kpiname, double target, String timescale) {
        try {
            URL url = new URL(Storage.getInstance().pi_ip + "targets/php/workouttargets.php");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setDoInput(true);
            OutputStream out = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            String data
                    = URLEncoder.encode("kpiname", "UTF-8") + "=" + URLEncoder.encode(kpiname, "UTF-8") + "&"
                    + URLEncoder.encode("target", "UTF-8") + "=" + URLEncoder.encode(target + "", "UTF-8") + "&"
                    + URLEncoder.encode("timescale", "UTF-8") + "=" + URLEncoder.encode(timescale, "UTF-8");
            //                       variable name                      variable result
            writer.write(data);
            writer.flush();
            writer.close();
            out.close();
            InputStream in = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "iso-8859-1"));
            String result = "";
            String line = "";
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            reader.close();
            in.close();
            http.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            //TODO - Some error handling        
        } catch (IOException ex) {
            ex.printStackTrace();
            //TODO - Some error handling
        }
        return null;
    }
    
    public String submitSale(String kpiname, String subkpi, double sale, String user) {
        try {
            URL url = new URL(Storage.getInstance().pi_ip + "sales/php/processsale.php");
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setDoInput(true);
            OutputStream out = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            String data
                    = URLEncoder.encode("kpi", "UTF-8") + "=" + URLEncoder.encode(kpiname, "UTF-8") + "&"
                    + URLEncoder.encode("subkpi", "UTF-8") + "=" + URLEncoder.encode(subkpi, "UTF-8") + "&"
                    + URLEncoder.encode("sale", "UTF-8") + "=" + URLEncoder.encode(sale + "", "UTF-8") + "&"
                    + URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8");
            //                       variable name                      variable result
            writer.write(data);
            writer.flush();
            writer.close();
            out.close();
            InputStream in = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "iso-8859-1"));
            String result = "";
            String line = "";
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            reader.close();
            in.close();
            http.disconnect();
            return result;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            //TODO - Some error handling        
        } catch (IOException ex) {
            ex.printStackTrace();
            //TODO - Some error handling
        }
        return null;
    }

}
