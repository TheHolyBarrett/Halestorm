package edu.milton.appforteacher;

import android.content.Context;
import android.content.Intent;
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
import java.util.*;

import org.w3c.dom.Text;

import java.util.ArrayList;


/*import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;*/
public class MainActivity extends AppCompatActivity {
    //@Override
    public final String log_tag = "TAG";
    public ArrayList<Person> students = new ArrayList<Person>();
    public ArrayList<String> list = new ArrayList<String>();
    public ListAdapter adapter;
    public boolean hasRemoved=false;
    public boolean otherRemoved=false;
    public ArrayList<Person> presentStudents = new ArrayList<Person>();
    public ArrayList<String> classes = new ArrayList<String>();
    public String currentScreen = "first";
    public ArrayList<Person> englishStudents = new ArrayList<Person>();
    public ArrayList<Person> englishAbsent = new ArrayList<Person>();


public int l = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        new JSONTask(this).execute();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        System.out.println("test0");


        /*createPerson("Will","Barrett", students);
        createPerson("Luke","Cadigan",students);
        createPerson("Henry", "Westerman",students);
        createPerson("James","Dunn",students);
        createPerson("Logan","Troy",students);
        createPerson("Sarah","Willwerth",students);
        createPerson("Ellen","Wei",students);
        createPerson("Evan","Scales",students);
        createPerson("Maya","Slocum",students);
        createPerson("Spencer","Evett",students);
        createPerson("Nick","Govindan",students);
        createPerson("Sam","Oldeshue",students);
        createPerson("Caleb","Rhodes",students);
        createPerson("Desi","Rosas",students);
        createPerson("Jacob","Aronoff",students);
        createPerson("Alex","Iansiti",students);
        createPerson("Aidan","Hartman",students);
        createPerson("Austin","Vyas",students);
        createPerson("Juliet","Jarrell",students);*/

        classes.add("Check-in List");
        classes.add("English Perspectives");
        classes.add("Class 2");
        classes.add("Class 3");

        createPerson("Will", "Barrett", englishStudents);
        createPerson("Evan","Scales", englishStudents);
        createPerson("Nick","Govindan", englishStudents);
        createPerson("Michelle","Erdensanna", englishStudents);
        createPerson("Lydia","Yang", englishStudents);
        createPerson("Dalton","Letorny", englishStudents);
        createPerson("Solace","Mensah-Narh", englishStudents);
        createPerson("Keisha","Baffour-Addo", englishStudents);
        createPerson("Karina","Cheung", englishStudents);
        createPerson("Sophia","Greenaway", englishStudents);
        createPerson("Haley","Hunt", englishStudents);
        createPerson("Theophile","Miailhe", englishStudents);



        final Button back = (Button) findViewById((R.id.backButton));
        back.setVisibility(View.VISIBLE);
        firstScreen();
       /* adapter = new CustomAdaptor(this, students, "Present");
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        System.out.println("TEST");*/
        final Button checkedIn = (Button) findViewById(R.id.checkedIn);

        checkedIn.setVisibility(View.INVISIBLE);
        final TextView header = (TextView) findViewById(R.id.students);
        header.setText("Classes");






        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setVisibility(View.INVISIBLE);
        assert submitButton != null;
        submitButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if(currentScreen.equals("class list")) {
                            l = 0;
                            hasRemoved = false;
                            System.out.println("test");
                            int num = students.size();
                            System.out.println("" + students.size());
                            for (int i = 0; i < num - l; i++) {
                                if (hasRemoved == true) {
                                    i--;
                                    l++;
                                    hasRemoved = false;
                                }
                                //System.out.println("Yeet " + students.get(i).name + students.get(i).isHere + "");
                                if (students.get(i).isHere == true) {
                                    //System.out.println("First: " + students.get(i).name);
                                    //System.out.println("Yeet " + students.get(i).name + students.get(i).isHere + "");
                                    students.get(i).isHere=false;
                                    presentStudents.add(students.get(i));

                                    students.remove(i);
                                    hasRemoved = true;


                                    //System.out.println("Second: " + students.get(i).name);


                                }
                                System.out.println("BABIES");
                            }
                            whenClicked();

                        }

                        if(currentScreen.equals("present list")){
                            l = 0;
                            otherRemoved = false;
                            System.out.println("test");
                            int num = presentStudents.size();
                            System.out.println("" + presentStudents.size());
                            for (int i = 0; i < num - l; i++) {
                                if (otherRemoved == true) {
                                    i--;
                                    l++;
                                    otherRemoved = false;
                                }
                                //System.out.println("Yeet " + presentStudents.get(i).name + presentStudents.get(i).isHere + "");
                                if (presentStudents.get(i).isHere == true) {
                                    //System.out.println("First: " + presentStudents.get(i).name);
                                    //System.out.println("Yeet " + presentStudents.get(i).name + presentStudents.get(i).isHere + "");
                                    presentStudents.get(i).isHere=false;
                                    students.add(presentStudents.get(i));
                                    presentStudents.remove(i);
                                    otherRemoved = true;


                                    //System.out.println("Second: " + students.get(i).name);


                                }

                            }
                            checkedInClicked();
                        }

                        if(currentScreen.equals("english")){
                            l = 0;
                            otherRemoved = false;
                            System.out.println("test");
                            int num = englishStudents.size();
                            System.out.println("" + englishStudents.size());
                            for (int i = 0; i < num - l; i++) {
                                if (otherRemoved == true) {
                                    i--;
                                    l++;
                                    otherRemoved = false;
                                }
                                //System.out.println("Yeet " + englishStudents.get(i).name + englishStudents.get(i).isHere + "");
                                if (englishStudents.get(i).isHere == true) {
                                    //System.out.println("First: " + englishStudents.get(i).name);
                                    //System.out.println("Yeet " + englishStudents.get(i).name + englishStudents.get(i).isHere + "");
                                    englishStudents.get(i).isHere=false;
                                    englishAbsent.add(englishStudents.get(i));
                                    englishStudents.remove(i);
                                    otherRemoved = true;


                                    //System.out.println("Second: " + students.get(i).name);


                                }

                            }
                            English();
                        }

                        if(currentScreen.equals("english absent")){
                            l = 0;
                            otherRemoved = false;
                            System.out.println("test");
                            int num = englishAbsent.size();
                            System.out.println("" + englishAbsent.size());
                            for (int i = 0; i < num - l; i++) {
                                if (otherRemoved == true) {
                                    i--;
                                    l++;
                                    otherRemoved = false;
                                }
                                //System.out.println("Yeet " + englishAbsent.get(i).name + englishAbsent.get(i).isHere + "");
                                if (englishAbsent.get(i).isHere == true) {
                                    //System.out.println("First: " + englishAbsent.get(i).name);
                                    //System.out.println("Yeet " + englishAbsent.get(i).name + englishAbsent.get(i).isHere + "");
                                    englishAbsent.get(i).isHere=false;
                                    englishStudents.add(englishAbsent.get(i));
                                    englishAbsent.remove(i);
                                    otherRemoved = true;


                                    //System.out.println("Second: " + students.get(i).name);


                                }

                            }
                            englishAbsents();
                        }
                    }
                }
        );


        assert checkedIn!=null;
        checkedIn.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        System.out.print("Ya boy be testing 1");
                        Boolean isYeet=false;
                        if(checkedIn.getText().equals("Checked In") && isYeet==false) {
                            checkedInClicked();
                            checkedIn.setText("Not Checked In");
                            System.out.print("Ya boy be testing 2");
                            isYeet=true;
                        }
                        if(checkedIn.getText().equals("Not Checked In") && isYeet==false){
                            whenClicked();
                            checkedIn.setText("Checked In");
                            System.out.print("Ya boy be testing 3");
                            isYeet=true;
                        }

                        if(currentScreen.equals("english") && isYeet==false){
                            System.out.println(log_tag+"SIR");
                            englishAbsents();
                            isYeet=true;

                        }
                        if(currentScreen.equals("english absent") && isYeet==false){
                            English();
                            isYeet=true;
                            System.out.println(log_tag+"QWE");
                        }


                    }
                }
        );

        assert back!= null;
        back.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        if(currentScreen.equals("class list")){
                            firstScreen();
                        }
                        if(currentScreen.equals("english")){
                            firstScreen();
                        }

                    }
                }
        );

    }




    // for(int i=0;i<students.size();i++){
    //System.out.println(""+listView.getItemAtPosition(i).);
    //if(students.get(i).isHere==true){
    // System.out.println(""+ students.get(i).name);
    //}


                      /*      if(CustomAdaptor.isChecked==true){
                                System.out.println("testing");
                                System.out.println("name: "+listView.getItemAtPosition(i).toString());
                            }*/




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public void fun(String s)
    {
        System.out.println("this is fun "+s);
         for(int i=0; i<students.size();i++){
             if(students.get(i).equals(s)){
                 students.get(i).isHere=true;
             }
         }

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


public void createPerson(String name, String lastName, ArrayList<Person> list){
    Person person = new Person(name, lastName);
    list.add(person);
}

    public void whenClicked(){
        Collections.sort(students, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.lastName.compareTo(p2.lastName);
            }
        });

        TextView header = (TextView) findViewById(R.id.students);
        header.setText("Students");
        adapter = new CustomAdaptor(this, students, "Present");
        Button back = (Button) findViewById(R.id.backButton);
        back.setVisibility(View.VISIBLE);
        Button checkedIn = (Button) findViewById(R.id.checkedIn);
        checkedIn.setVisibility(View.VISIBLE);
        checkedIn.setText("Checked In");
        Button submitButton= (Button) findViewById(R.id.submitButton);
        submitButton.setVisibility(View.VISIBLE);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        currentScreen="class list";
    }

    public void checkedInClicked(){
        Collections.sort(presentStudents, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.lastName.compareTo(p2.lastName);
            }
        });
        adapter = new CustomAdaptor(this, presentStudents, "Undo");
        Button back = (Button) findViewById(R.id.backButton);
        back.setVisibility(View.INVISIBLE);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        currentScreen="present list";
    }

    public void English(){
        Collections.sort(englishStudents, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.lastName.compareTo(p2.lastName);
            }
        });
        adapter = new CustomAdaptor(this, englishStudents, "Absent");
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        Button back = (Button) findViewById(R.id.backButton);
        back.setVisibility(View.VISIBLE);
        Button checkedIn = (Button) findViewById(R.id.checkedIn);
        checkedIn.setText("Absent List");
        checkedIn.setVisibility(View.VISIBLE);
        Button submitButton= (Button) findViewById(R.id.submitButton);
        submitButton.setVisibility(View.VISIBLE);
        TextView header = (TextView) findViewById(R.id.students);
        header.setText("English Perspectives");
        currentScreen="english";

    }

    public void englishAbsents(){
        Collections.sort(englishAbsent, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.lastName.compareTo(p2.lastName);
            }
        });
        System.out.println(log_tag+"Indeed");
        adapter = new CustomAdaptor(this, englishAbsent, "Undo");
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        Button back = (Button) findViewById(R.id.backButton);
        back.setVisibility(View.INVISIBLE);
       Button checkedIn = (Button) findViewById(R.id.checkedIn);
        checkedIn.setText("Class List");
        checkedIn.setVisibility(View.VISIBLE);
        Button submitButton= (Button) findViewById(R.id.submitButton);
        submitButton.setVisibility(View.VISIBLE);
        TextView header = (TextView) findViewById(R.id.students);
        header.setText("English Perspectives: Absent");
        currentScreen="english absent";
        System.out.println(log_tag+"I LIKE BABIES");
    }

    public void allStudents(String s, String l){
        //System.out.println("GOT IT " + s  + " " + l);
        createPerson(s, l, students);
    }

    public void firstScreen(){
        ListAdapter firstAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, classes);
        ListView classList = (ListView) findViewById(R.id.listView);
        classList.setAdapter(firstAdapter);
        Button checkedIn = (Button) findViewById(R.id.checkedIn);
        checkedIn.setVisibility(View.INVISIBLE);
        Button submitButton= (Button) findViewById(R.id.submitButton);
        submitButton.setVisibility(View.INVISIBLE);
        Button back = (Button) findViewById(R.id.backButton);
        back.setVisibility(View.INVISIBLE);
        TextView header = (TextView) findViewById(R.id.students);
        header.setText("Classes");


        classList.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String name =  String.valueOf(parent.getItemAtPosition(position));
                        if(name.equals("Check-in List")){
                            whenClicked();

                        }

                        if(name.equals("English Perspectives")){
                            English();
                        }
                    }
                }
        );
    }

}
