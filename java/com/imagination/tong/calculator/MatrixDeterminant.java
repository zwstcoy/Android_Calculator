package com.imagination.tong.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Tong on 10/6/2017.
 */
public class MatrixDeterminant extends Activity{
    readMatrix readM=new readMatrix();
    Button dButton;
    EditText dMatrix1;

    TextView answer;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materix_determent);



    }
}
