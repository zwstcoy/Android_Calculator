package com.imagination.tong.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Tong on 8/25/2017.
 */
public class LineEActivity extends Activity {
    Button lineButton;
    EditText lineVector,linePoint;
    TextView answer;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_equation);
        lineButton=(Button)findViewById(R.id.line_button);
        lineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        linePoint=(EditText)findViewById(R.id.line_point);
        lineVector=(EditText)findViewById(R.id.line_vector);
        lineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String point=linePoint.getContext().toString();
                String vector=lineVector.getContext().toString();
            }
        });

    }
    public int[] conven(String str){

        int a=0,b=0,c=0,n=0;
        int i=str.length();
        while(str.charAt(i)!=' '&&i<str.length()){
            a=str.charAt(i)-'0';
            a=a*(n++)+a;
        }
        n=0;
        while(str.charAt(i)!=' '&&i<str.length()){
            b=str.charAt(i)-'0';
            b=b*(n++)+b;
        }
        while(str.charAt(i)!=' '&&i<str.length()){
            c=str.charAt(i)-'0';
            c=c*(n++)+c;

        }
        int list[]={a,b,c};

        return list;
    }
}
