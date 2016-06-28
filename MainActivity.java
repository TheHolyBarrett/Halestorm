package edu.milton.myapplication;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.*;


public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        /*Button hereButton = (Button)findViewById(R.id.hereButton);

        assert hereButton != null;
        hereButton.setOnClickListener(
            new Button.OnClickListener(){
                public void onClick(View v){
                    TextView text = (TextView)findViewById(R.id.textView);
                    text.setText("Thank you for checking in");
                }
            }
        );*/
        Button checkInButton = (Button)findViewById(R.id.checkInButton);
        checkInButton.setVisibility(View.INVISIBLE);
        String[] list = {"Bob", "Joe", "Fred", "Harry", "Cads", "WesterG", "Other Bob", "William Manchester Barrett III"};
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setVisibility(View.INVISIBLE);
        String[] tabs = {"Check in", "Emergency"};
        ListAdapter adapterTabs = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tabs);
        ListView tabList = (ListView) findViewById(R.id.listView2);
        tabList.setAdapter(adapterTabs);
        TextView text = (TextView)findViewById(R.id.checkInText);
        text.setText("");

        tabList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String name =  String.valueOf(parent.getItemAtPosition(position));
                        ListView tabList = (ListView) findViewById(R.id.listView2);
                        tabList.setVisibility(View.INVISIBLE);
                        if(name.equals("Check in")) {
                        ListView listView = (ListView) findViewById(R.id.listView);
                        listView.setVisibility(View.VISIBLE);
                            TextView text = (TextView) findViewById(R.id.checkInText);
                            text.setText("Please Check In");
                        }
                        if(name.equals("Emergency")){
                            TextView text = (TextView) findViewById(R.id.checkInText);
                            text.setText("Are you in immediate danger?");

                        }



                    }
                }
        );
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String name =  String.valueOf(parent.getItemAtPosition(position));
                        TextView text = (TextView)findViewById(R.id.checkInText);
                        text.setText(""+name);
                        ListView listView = (ListView) findViewById(R.id.listView);
                        listView.setVisibility(View.INVISIBLE);
                        Button checkInButton = (Button)findViewById(R.id.checkInButton);
                        checkInButton.setVisibility(View.VISIBLE);
                        checkInButton.setOnClickListener(
                                new Button.OnClickListener() {
                                    public void onClick(View v) {
                                        Button checkInButton = (Button) findViewById(R.id.checkInButton);
                                        checkInButton.setVisibility(View.INVISIBLE);
                                        TextView text = (TextView) findViewById(R.id.checkInText);
                                        text.setText("Thank you");



                                    }
                                }

                                    );



                        //Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();
                                }
                    public void onItemClick( View v)
                    {

                    }


                }
        );


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://edu.milton.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://edu.milton.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
