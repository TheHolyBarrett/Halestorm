package com.example.lukecadigan.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int state=0;
    //-1 means "need help", 1 means "ok", 0 means "hasn't responded"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //yes Button
        Button yesButton = (Button)findViewById(R.id.yesButton);
        Button noButton = (Button)findViewById(R.id.noButton);
        yesButton.setOnClickListener(
            new Button.OnClickListener() {
                public void onClick(View v) {
                    Button yesButton = (Button)findViewById(R.id.yesButton);
                    Button noButton = (Button)findViewById(R.id.noButton);
                    TextView textView = (TextView) findViewById(R.id.textView);
                    textView.setText("Message Recieved, Sending Help");
                    //noButton.setVisibility(View.VISIBLE);
                    //yesButton.setVisibility(View.INVISIBLE);

                    yesButton.setTextColor(Color.BLUE);
                    noButton.setTextColor(Color.BLACK);

                    noButton.setText("Not In Danger");
                    yesButton.setText("In Danger");
                    state=1;

                    RelativeLayout layout = (RelativeLayout)findViewById(R.id.layout);
                    layout.setBackgroundColor(Color.RED);
                }
            }
        );

        noButton.setOnClickListener(
                //new Button.OnClickListener(){
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Button yesButton = (Button)findViewById(R.id.yesButton);
                        Button noButton = (Button)findViewById(R.id.noButton);

                        TextView textView = (TextView) findViewById(R.id.textView);
                        noButton.setTextColor(Color.BLUE);
                        yesButton.setTextColor(Color.BLACK);

                        //noButton.setVisibility(View.INVISIBLE);
                        //yesButton.setVisibility(View.VISIBLE);
                        noButton.setText("Not in Danger");
                        yesButton.setText("In Danger");
                        textView.setText("Message Recieved, Update If Situation Changes");

                        RelativeLayout layout = (RelativeLayout)findViewById(R.id.layout);
                        layout.setBackgroundColor(Color.GREEN);

                        state=(-1);
                    }
                }
        );
    }



}
