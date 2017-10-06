package com.imagination.tong.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Tong on 8/25/2017.
 */
public class MatrixActivity extends Activity {
    private Button addButton, mulityButton, determentButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);

        addButton = (Button) findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MatrixActivity.this, MatrixAdd.class);
                startActivity(i);
            }
        });

        mulityButton = (Button) findViewById(R.id.multiply_button);
        mulityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MatrixActivity.this, MatrixMultipy.class);
                startActivity(i);
            }
        });

        determentButton = (Button) findViewById(R.id.determent_button);
        determentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MatrixActivity.this, MatrixDeterminant.class);
                startActivity(i);
            }
        });
    }
}
    class readMatrix{


    public  ArrayList<Object> readNum(String str){
        ArrayList<Object> list=new ArrayList<Object>();
        double x=0,n=1;
        int d=10;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==','){
                list.add(",");

            }
            else if((str.charAt(i)>='0'&&str.charAt(i)<='9')||str.charAt(i)=='.') {
                while ((i < str.length() && str.charAt(i) != ' ') && str.charAt(i) != ',') {
                    if (str.charAt(i) == '.') {
                        d = 1;
                        n = .1;

                    } else {
                        x = x * d + (n * (str.charAt(i) - '0'));
                    }
                    i++;
                }
                list.add(x);
                x = 0;
                n = 1;
                d = 10;
                i--;
            }
        }
        return list;
    }
}

