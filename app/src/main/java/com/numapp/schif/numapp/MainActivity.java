package com.numapp.schif.numapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import models.PinAction;
import repositories.PinActionsRepository;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pin = "";
        Button btn0 = (Button)findViewById(R.id.button0);
        Button btn1 = (Button)findViewById(R.id.button1);
        Button btn2 = (Button)findViewById(R.id.button2);
        Button btn3 = (Button)findViewById(R.id.button3);
        Button btn4 = (Button)findViewById(R.id.button4);
        Button btn5 = (Button)findViewById(R.id.button5);
        Button btn6 = (Button)findViewById(R.id.button6);
        Button btn7 = (Button)findViewById(R.id.button7);
        Button btn8 = (Button)findViewById(R.id.button8);
        Button btn9 = (Button)findViewById(R.id.button9);
        Button btnOK = (Button)findViewById(R.id.buttonOK);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click0();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click1();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click2();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click3();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click4();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click5();
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click6();
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click7();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click8();
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click9();
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickOK();
            }
        });
    }

    public void click1(){
        pin += "1";
        TextView textView = (TextView)findViewById(R.id.textView4);
        textView.setText(pin);
    }

    public void click2(){
        pin += "2";
        TextView textView = (TextView)findViewById(R.id.textView4);
        textView.setText(pin);
    }

    public void click3(){
        pin += "3";
        TextView textView = (TextView)findViewById(R.id.textView4);
        textView.setText(pin);
    }

    public void click4(){
        pin += "4";
        TextView textView = (TextView)findViewById(R.id.textView4);
        textView.setText(pin);
    }

    public void click5(){
        pin += "5";
        TextView textView = (TextView)findViewById(R.id.textView4);
        textView.setText(pin);
    }

    public void click6(){
        pin += "6";
        TextView textView = (TextView)findViewById(R.id.textView4);
        textView.setText(pin);
    }

    public void click7(){
        pin += "7";
        TextView textView = (TextView)findViewById(R.id.textView4);
        textView.setText(pin);
    }

    public void click8(){
        pin += "8";
        TextView textView = (TextView)findViewById(R.id.textView4);
        textView.setText(pin);
    }

    public void click9(){
        pin += "9";
        TextView textView = (TextView)findViewById(R.id.textView4);
        textView.setText(pin);
    }

    public void click0(){
        pin += "0";
        TextView textView = (TextView)findViewById(R.id.textView4);
        textView.setText(pin);
    }

    public void clickOK(){
        TextView textView = (TextView)findViewById(R.id.textView4);
        PinActionsRepository pinActionsRepository = new PinActionsRepository(getApplicationContext());
        PinAction pinAction = pinActionsRepository.GetPinActionByPin(pin);
        if(pinAction != null){
            textView.setText(pinAction.Action);
        }
        else{
            CharSequence text = "El pin ingresado no es correcto";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(getApplicationContext(), text, duration);
            toast.show();
        }
        pin = "";
        textView.setText("");
    }
}
