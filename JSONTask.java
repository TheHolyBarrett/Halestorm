package edu.milton.appforteacher;

import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;



public class JSONTask extends AsyncTask<URL,String,String > {
public Context con;
    public JSONTask(Context applicationContext) {
        con=applicationContext;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected String doInBackground(URL... urls) {

        System.out.println("Reached doInBackground");

        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            System.out.println("Reached try 1");

            URL url = new URL("http://signin.ma1geek.org/getStudents.php");

            System.out.println("Reached try 2");
            connection = (HttpURLConnection) url.openConnection();
            System.out.println("Reached try 3");

            connection.connect();
            System.out.println("Reached try block 4");
            InputStream stream = connection.getInputStream();
            System.out.println("Reached try block 5");
            reader = new BufferedReader(new InputStreamReader(stream));
            System.out.println("Reached try block 6");
            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null) {
                System.out.println("find"+line);
                buffer.append(line);

            }
            line=buffer.toString();

            System.out.println("FORD" + line);
            JSONObject obj = new JSONObject((line));
            JSONArray jArray= (JSONArray) obj.get("Students");
            for(int i=0; i<jArray.length(); i++){

                String fName = (String) jArray.getJSONObject(i).get("Firstname");
                //System.out.println("QWERTY "+ fName);
                String lName = (String) jArray.getJSONObject(i).get("Lastname");
                System.out.println("CATS: " + fName + " "+ lName);
                String sClass = (String) jArray.getJSONObject(i).get("Year");
                System.out.println("Holla 1");
                if(sClass.equals("2017")){
                    System.out.println("Holla 2");
                    ((MainActivity)con).allStudents(fName,lName);
                }

            }
            //String lName= (String) obj.get("Lastname");




                /*
                String finalJson = buffer.toString();
                JSONObject parentObject = new JSONObject(finalJson);
                JSONArray parentArray = parentObject.getJSONArray("movies");
                */


        } catch (MalformedURLException e) {
            //textView.setText("Reached exception");

            System.out.println("Reached MALFORMED URL");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Reached IO Error");
            //textView.setText("Reached exception IO");
            e.printStackTrace();
        } catch(Exception e) {
            System.out.println("Reached General Error");
            //textView.setText("Reached exception IO");
            e.printStackTrace();

        }
        finally {

            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}