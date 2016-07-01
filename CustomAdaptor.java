package edu.milton.appforteacher;

import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
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
import java.util.ArrayList;
import android.view.LayoutInflater;
import android.content.Intent;


/**
 * Created by Will on 6/28/16.
 */
 class CustomAdaptor extends ArrayAdapter<Person> {


    public Context con;
    public String box;
    CustomAdaptor(Context context, ArrayList<Person> names, String pBox){
        super(context, R.layout.custom_row, names);
        con=context;
        box=pBox;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView =  inflater.inflate(R.layout.custom_row, parent, false);

        final Person singleName = getItem(position);
        TextView text = (TextView) customView.findViewById(R.id.textView);


        text.setText(singleName.lastName+ ", " +singleName.firstName);
         final CheckBox checkBox = (CheckBox) customView.findViewById(R.id.checkBox);
        checkBox.setText(box);
        checkBox.setOnClickListener(
                new CheckBox.OnClickListener(){
                    public void onClick(View v){

                        if(checkBox.isChecked()==true){


                            singleName.isHere=true;
                            System.out.println(singleName.lastName+ ", " +singleName.firstName);
                            ((MainActivity)con).fun(singleName.lastName+ ", " +singleName.firstName);


                        }
                        if(checkBox.isChecked()==false){
                            singleName.isHere=false;
                        }
                    }
                }
        );

       /* Button button = (Button) customView.findViewById(R.id.button);

        button.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                            remove(singleName);
                            notifyDataSetChanged();



                    }
                }
        );*/


        return customView;

    }
public static void removeItem(){


}


}
