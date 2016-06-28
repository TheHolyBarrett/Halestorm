package edu.milton.test4;

import android.os.AsyncTask;

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
                URL url = new URL("http://flik.ma1geek.org/getMeals.php?date=2016/03/08");

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

