package com.imagination.tong.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Tong on 8/25/2017.
 */
public class EquationActivity extends Activity {
    Button equationButton;
    EditText context;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equaction);
        equationButton=(Button)findViewById(R.id.equation_button);

        context=(EditText)findViewById(R.id.equation_text);
        equationButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String s=context.getText().toString();
            }
        });

    }

}
