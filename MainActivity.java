package com.imagination.tong.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button equationButton,matrixButton,lineButton,planeButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equationButton=(Button)findViewById(R.id.equation_button);
        matrixButton=(Button)findViewById(R.id.matrix_button);
        lineButton=(Button)findViewById(R.id.line_button);
        planeButton=(Button)findViewById(R.id.plane_button);
    }
}
