package com.imagination.tong.calculator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button equationButton,matrixButton,lineButton,planeButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equationButton=(Button)findViewById(R.id.equation_button);
        equationButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i=new Intent(MainActivity.this,EquationActivity.class);
                startActivity(i);
            }
        });


        matrixButton=(Button)findViewById(R.id.matrix_button);
        matrixButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i=new Intent(MainActivity.this,MatrixActivity.class);
                startActivity(i);
            }
        });

        lineButton=(Button)findViewById(R.id.line_button);
        lineButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i=new Intent(MainActivity.this,LineEActivity.class);
                startActivity(i);
            }
        });


        planeButton=(Button)findViewById(R.id.plane_button);
        planeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i=new Intent(MainActivity.this,PlaneEActivity.class);
                startActivity(i);
            }
        });
    }
}
