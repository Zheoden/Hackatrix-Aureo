package com.numapp.schif.numapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import models.PinAction;
import repositories.PinActionsRepository;

public class MainActivity extends AppCompatActivity {

    private String pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pin = "";
        setContentView(R.layout.activity_main);
    }

    public void click1(){
        pin += "1";
    }

    public void click2(){
        pin += "2";
    }

    public void click3(){
        pin += "3";
    }

    public void click4(){
        pin += "4";
    }

    public void click5(){
        pin += "5";
    }

    public void click6(){
        pin += "6";
    }

    public void click7(){
        pin += "7";
    }

    public void click8(){
        pin += "8";
    }

    public void click9(){
        pin += "9";
    }

    public void click0(){
        pin += "0";
    }

    public void clickOK(){
        PinActionsRepository pinActionsRepository = new PinActionsRepository(getApplicationContext());
        PinAction pinAction = pinActionsRepository.GetPinActionByPin(pin);
        if(pinAction != null){
            //Aca va el codigo para ejecutar dependiendo el action al que corresponde el pin ingresado
        }
        else{
            CharSequence text = "El pin ingresado no es correcto";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(getApplicationContext(), text, duration);
            toast.show();
        }
        pin = "";
    }
}
