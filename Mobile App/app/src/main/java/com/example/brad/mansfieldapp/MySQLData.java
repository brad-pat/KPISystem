package com.example.brad.mansfieldapp;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

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
import java.nio.charset.StandardCharsets;

public class MySQLData extends AsyncTask<String,Void,String> {
    Context context;

    public MySQLData(Context c) {
        context = c;
    }

   @Override
   protected String doInBackground(String... params) {
       String type = params[0];
       String data = params[1];
       if(type.equals("PROCESSSALE")) {
           String url = Storage.getInstance().pi_ip + "sales/php/processsale.php";
           return submitSale(url, data);
       }
       if(type.equals("USERPERFORMANCEKPI")) {
           String url = Storage.getInstance().pi_ip + "targets/php/workoutoverallperformance.php";
           return fetchKPIDataForUser(url, data);
       }
       if(type.equals("STOREPERFORMANCEKPI")) {
           String url = Storage.getInstance().pi_ip + "targets/php/workoutoverallperformance.php";
           return fetchKPIDataForUser(url, data);
       }
       if(type.equals("FETCHKPIS")) {
           String url = Storage.getInstance().pi_ip + "setup/php/getkpisettingsfromconfigfile.php";
           String test = getKPISettings(url);
           return test;
       }
       if(type.equals("LOGINCHECK")) {
           String url = Storage.getInstance().pi_ip + "users/php/checkuser.php";
           return login(url, data);
       }
       if(type.equals("STORETIMESCALES")) {
           String url = Storage.getInstance().pi_ip + "setup/php/getstoretimes.php";
           return getStoreTimes(url);
       }
       if(type.equals("EMPLOYEETIMESCALES")) {
           String url = Storage.getInstance().pi_ip + "setup/php/getemployeetimes.php";
           return getStoreTimes(url);
       }
       return null;
   }

   private String submitSale(String url_address, String data) {
        try {
            URL url = new URL(url_address);
            String[] info = data.split(":");
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
            String post_data =
                    URLEncoder.encode("kpi","UTF-8")+"="+URLEncoder.encode(info[0] + "","UTF-8")+"&"+
                            URLEncoder.encode("subkpi","UTF-8")+"="+URLEncoder.encode(info[1] + "","UTF-8")+"&"+
                            URLEncoder.encode("sale","UTF-8")+"="+URLEncoder.encode(info[2] + "","UTF-8")+"&"+
                            URLEncoder.encode("user","UTF-8")+"="+URLEncoder.encode(info[3] + "", "UTF-8");
            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1));
            String result="";
            String line="";
            while((line = bufferedReader.readLine())!= null) {
                result += line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

   private String fetchKPIDataForUser(String url_address, String data) {
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

   private String getKPISettings(String ur) {
       try {
           URL url = new URL(ur);
           HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
           httpURLConnection.setRequestMethod("POST");
           httpURLConnection.setDoOutput(true);
           httpURLConnection.setDoInput(true);
           OutputStream outputStream = httpURLConnection.getOutputStream();
           BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
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

    private String getStoreTimes(String deet_url) {
        try {
            URL url = new URL(deet_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
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

   private String login(String url_address, String data) {
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
                   URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(info[0] + "","UTF-8")+"&"+
                           URLEncoder.encode("company_name","UTF-8")+"="+URLEncoder.encode(info[1] + "", "UTF-8");
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
       } catch (IOException e) {
           e.printStackTrace();
       }
       return null;
   }

   @Override
   protected void onPreExecute() {

   }

   @Override
   protected void onPostExecute(String result) {
      String[] bits = result.trim().split("=");
      if(bits[0].trim().equalsIgnoreCase("USERPERFORMANCEKPI")) {
          Storage.getInstance().personal_performance_kpi_data.add(bits[1]);
      }
      if(bits[0].trim().equalsIgnoreCase("KPISTRING")) {
          String test =  bits[1].trim();
          MainActivity ma = new MainActivity();
          ma.setUpKPIs(test);
      }
       if(bits[0].trim().equalsIgnoreCase("EMPLOYEETIMES")) {
           String[] times = bits[1].split("__");
           for(String s : times) {
               if(s.equalsIgnoreCase("") || s == null) {}
               Storage.getInstance().employee_times.add(s.trim());
           }
       }
      if(bits[0].trim().equalsIgnoreCase("STORETIMES")) {
          String[] times = bits[1].split("__");
          for(String s : times) {
              if(s.equalsIgnoreCase("") || s == null) {}
              Storage.getInstance().store_times.add(s.trim());
          }
      }
   }
}