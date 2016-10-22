package com.numapp.schif.numapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import models.PinAction;
import repositories.PinActionsRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PinActionsRepository repository = new PinActionsRepository(getApplicationContext());
        PinAction action = new PinAction();
        action.Action = "Unlock";
        action.Pin = 1234;
        repository.AddPinAction(action);

        Button btn = (Button)findViewById(R.id.buttonShowUnlockCode);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUnlockCode();
            }
        });
    }

    public void getUnlockCode(){
        PinActionsRepository repository = new PinActionsRepository(getApplicationContext());
        PinAction action = repository.GetPinActionByAction("Unlock");
        TextView textView = (TextView)findViewById(R.id.unlockCodeShow);
        textView.setText(Integer.toString(action.Pin));
    }
}
