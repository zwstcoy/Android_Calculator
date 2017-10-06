package com.imagination.tong.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tong on 10/5/2017.
 */
public class MatrixMultipy extends Activity{
    readMatrix readM=new readMatrix();
    Button produceMatrix;
    EditText pMatrix1;
    EditText pMatrix2;
    TextView answer;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix_multiplcation);

        pMatrix1=(EditText)findViewById(R.id.produce_matrix1);
        pMatrix2=(EditText)findViewById(R.id.produce_matrix2);
        answer=(TextView)findViewById(R.id.produce_answer);

        produceMatrix=(Button)findViewById(R.id.find_p_button);
        produceMatrix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Object> matrix1=new ArrayList<Object>();
                ArrayList<Object> matrix2=new ArrayList<Object>();
                ArrayList<Object> sum=new ArrayList<Object>();
                String matrixString1=pMatrix1.getText().toString();
                String matrixString2=pMatrix2.getText().toString();
                matrix1=readM.readNum(matrixString1);
                matrix2=readM.readNum(matrixString2);
            }
        });

    }

}
